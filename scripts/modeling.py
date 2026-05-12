"""Spark ML modeling pipeline for NYC DOB plan examination outcomes."""

import math
import os

import pyspark.sql.functions as F
from pyspark.ml import Pipeline, Transformer
from pyspark.ml.classification import LogisticRegression, RandomForestClassifier
from pyspark.ml.evaluation import BinaryClassificationEvaluator
from pyspark.ml.feature import (
    ChiSqSelector,
    OneHotEncoder,
    QuantileDiscretizer,
    StringIndexer,
    VarianceThresholdSelector,
    VectorAssembler,
    VectorIndexer,
)
from pyspark.ml.tuning import CrossValidator, ParamGridBuilder
from pyspark.sql import SparkSession
from pyspark.sql.types import DateType, NumericType, StringType, TimestampType


TEAM = "team13"
WAREHOUSE = "project/hive/warehouse"
LABEL = "job_status"
HIVE_TABLE = "team13_projectdb_hive.fact_job_applications_opt"
COVERAGE_THRESHOLD = 0.5
MIN_BINARY_VARIANCE = 0.05
HIGH_CARDINALITY_RATIO = 0.8
HIGH_CARDINALITY_LIMIT = 500
CHISQ_TOP_FEATURES = 50
CHISQ_BUCKETS = 16
FINAL_FEATURE_SET = "coverage_variance_chisq"

TARGET_COLUMNS = {LABEL, "job_status_descr"}
LEAKAGE_COLUMNS = {
    "latest_action_date",
    "paid",
    "fully_paid",
    "assigned",
    "approved",
    "fully_permitted",
    "signoff_date",
    "special_action_status",
    "special_action_date",
    "withdrawal_flag",
    "fee_status",
    "job_no_good_count",
    "dobrundate",
}
GEO_COLUMNS = ["gis_latitude", "gis_longitude"]
TIME_COLUMNS = ["pre_filing_date"]
FEATURE_SET_CONFIGS = [
    {"name": "full", "coverage": False, "variance": False, "chisq": False},
    {"name": "variance", "coverage": False, "variance": True, "chisq": False},
    {"name": "coverage_variance", "coverage": True, "variance": True, "chisq": False},
    {"name": FINAL_FEATURE_SET, "coverage": True, "variance": True, "chisq": True},
]


class DatePartsTransformer(Transformer):
    """Split a timestamp column into year, month, and day columns."""

    def __init__(self, input_col):
        super().__init__()
        self.input_col = input_col

    def _transform(self, dataset):
        return (
            dataset.withColumn("filing_year", F.coalesce(F.year(F.col(self.input_col)), F.lit(0)))
            .withColumn("filing_month", F.coalesce(F.month(F.col(self.input_col)), F.lit(1)))
            .withColumn("filing_day", F.coalesce(F.dayofmonth(F.col(self.input_col)), F.lit(1)))
        )


class SinCosTransformer(Transformer):
    """Encode a cyclical numeric column with sine and cosine components."""

    def __init__(self, input_col, period, sin_col, cos_col):
        super().__init__()
        self.input_col = input_col
        self.period = period
        self.sin_col = sin_col
        self.cos_col = cos_col

    def _transform(self, dataset):
        angle = 2 * math.pi * F.col(self.input_col) / F.lit(self.period)
        return dataset.withColumn(self.sin_col, F.sin(angle)).withColumn(
            self.cos_col,
            F.cos(angle),
        )


class GeoToECEFTransformer(Transformer):
    """Convert latitude and longitude into Earth-centered coordinates."""

    def __init__(self, lat_col, lon_col):
        super().__init__()
        self.lat_col = lat_col
        self.lon_col = lon_col

    def _transform(self, dataset):
        radius = F.lit(6378137.0)
        lat = F.radians(F.col(self.lat_col))
        lon = F.radians(F.col(self.lon_col))
        return (
            dataset.withColumn("gis_x", radius * F.cos(lat) * F.cos(lon))
            .withColumn("gis_y", radius * F.cos(lat) * F.sin(lon))
            .withColumn("gis_z", radius * F.sin(lat))
        )


def run(command):
    """Run a shell command and return its output."""
    return os.popen(command).read()


def build_spark_session():
    """Create Spark session connected to Hive metastore."""
    spark = (
        SparkSession.builder.appName(f"{TEAM} - spark ML")
        .master("yarn")
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")
        .config("spark.sql.warehouse.dir", WAREHOUSE)
        .config("spark.sql.avro.compression.codec", "snappy")
        .enableHiveSupport()
        .getOrCreate()
    )
    spark.sparkContext.setLogLevel("WARN")
    return spark


def is_geospatial(feature):
    """Return whether a column is part of the geospatial coordinate pair."""
    return feature in GEO_COLUMNS


def is_time(feature):
    """Return whether a column is used as a pre-decision time feature."""
    return feature in TIME_COLUMNS


def is_excluded_before_selection(feature):
    """Return static exclusion reason for fields that are not valid predictors."""
    if feature in TARGET_COLUMNS:
        return "target"
    if feature in LEAKAGE_COLUMNS:
        return "leakage"
    return ""


def feature_group(feature, data_type):
    """Return dashboard-friendly feature group name."""
    if is_geospatial(feature):
        return "geospatial"
    if is_time(feature):
        return "time"
    if isinstance(data_type, NumericType):
        return "numeric"
    if isinstance(data_type, (DateType, TimestampType)):
        return "time"
    return "categorical"


def profile_features(jobs):
    """Profile all Hive columns before automatic feature selection."""
    features = [field.name for field in jobs.schema.fields]
    expressions = []
    for feature in features:
        expressions.append(F.count(feature).alias(f"{feature}__non_null"))
        expressions.append(F.approx_count_distinct(feature).alias(f"{feature}__distinct"))
    row = jobs.select(expressions).collect()[0].asDict()
    return {
        feature: {
            "non_null": row[f"{feature}__non_null"],
            "distinct": row[f"{feature}__distinct"],
        }
        for feature in features
    }


def high_cardinality_reason(feature, profile):
    """Return exclusion reason for ID-like categorical columns."""
    non_null = profile[feature]["non_null"]
    distinct = profile[feature]["distinct"]
    if not non_null:
        return "empty"
    if distinct > HIGH_CARDINALITY_LIMIT:
        return "high_cardinality"
    if distinct / non_null >= HIGH_CARDINALITY_RATIO:
        return "high_cardinality"
    return ""


def build_feature_catalog(jobs):
    """Build feature catalog from Hive schema and data profile."""
    profile = profile_features(jobs)
    field_types = {field.name: field.dataType for field in jobs.schema.fields}
    row_count = jobs.count()
    threshold = int(row_count * COVERAGE_THRESHOLD)
    rows = []
    eligible = []
    for feature, data_type in field_types.items():
        group = feature_group(feature, data_type)
        reason = is_excluded_before_selection(feature)
        if not reason and group == "categorical":
            reason = high_cardinality_reason(feature, profile)
        if not reason and group == "time" and not is_time(feature):
            reason = "leakage"
        if not reason:
            eligible.append(feature)
        rows.append(
            {
                "feature": feature,
                "feature_group": group,
                "non_null_rows": int(profile[feature]["non_null"]),
                "selection_threshold_rows": threshold,
                "distinct_values": int(profile[feature]["distinct"]),
                "selected": "yes" if not reason else "no",
                "reason": reason or "eligible",
            }
        )
    return rows, eligible


def split_features_by_type(jobs, features):
    """Split selected source columns by Spark SQL data type."""
    field_types = {field.name: field.dataType for field in jobs.schema.fields}
    categorical = []
    numeric = []
    time = []
    geospatial = []
    for feature in features:
        data_type = field_types[feature]
        if is_geospatial(feature):
            geospatial.append(feature)
        elif is_time(feature):
            time.append(feature)
        elif isinstance(data_type, NumericType):
            numeric.append(feature)
        elif isinstance(data_type, StringType):
            categorical.append(feature)
    return categorical, numeric, time, geospatial


def select_variant_features(catalog, eligible, use_coverage):
    """Apply source-column selection for one feature-set variant."""
    if not use_coverage:
        return eligible
    return [
        feature
        for feature in eligible
        if catalog[feature]["non_null_rows"] >= catalog[feature]["selection_threshold_rows"]
    ]


def save_feature_extraction(spark, catalog_rows, final_features):
    """Save final feature extraction summary for dashboard compatibility."""
    feature_rows = [
        [
            row["feature"],
            row["feature_group"],
            row["non_null_rows"],
            row["selection_threshold_rows"],
            row["distinct_values"],
            "yes" if row["feature"] in final_features else "no",
        ]
        for row in catalog_rows
    ]
    (
        spark.createDataFrame(
            feature_rows,
            [
                "feature",
                "feature_group",
                "non_null_rows",
                "selection_threshold_rows",
                "distinct_values",
                "selected",
            ],
        )
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save("project/output/feature_extraction")
    )
    run(
        "rm -f output/feature_extraction.csv && "
        "hdfs dfs -cat project/output/feature_extraction/part* > "
        "output/feature_extraction.csv"
    )


def save_feature_set_catalog(spark, catalog_rows):
    """Save full source-column selection catalog."""
    rows = [
        [
            row["feature"],
            row["feature_group"],
            row["non_null_rows"],
            row["selection_threshold_rows"],
            row["distinct_values"],
            row["selected"],
            row["reason"],
        ]
        for row in catalog_rows
    ]
    (
        spark.createDataFrame(
            rows,
            [
                "feature",
                "feature_group",
                "non_null_rows",
                "selection_threshold_rows",
                "distinct_values",
                "selected",
                "reason",
            ],
        )
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save("project/output/feature_catalog")
    )
    run(
        "rm -f output/feature_catalog.csv && "
        "hdfs dfs -cat project/output/feature_catalog/part* > output/feature_catalog.csv"
    )


def build_feature_pipeline(categorical_cols, numeric_cols, time_cols, geo_cols, config):
    """Build Spark ML feature extraction pipeline."""
    stages = []
    assembled_cols = []
    continuous_cols = []
    if time_cols:
        stages += [
            DatePartsTransformer(time_cols[0]),
            SinCosTransformer("filing_month", 12, "filing_month_sin", "filing_month_cos"),
            SinCosTransformer("filing_day", 31, "filing_day_sin", "filing_day_cos"),
        ]
        continuous_cols += [
            "filing_year",
            "filing_month_sin",
            "filing_month_cos",
            "filing_day_sin",
            "filing_day_cos",
        ]
    if len(geo_cols) == 2:
        stages.append(GeoToECEFTransformer(geo_cols[0], geo_cols[1]))
        continuous_cols += ["gis_x", "gis_y", "gis_z"]
    indexers = [
        StringIndexer(inputCol=column, outputCol=f"{column}_indexed").setHandleInvalid("keep")
        for column in categorical_cols
    ]
    encoders = [
        OneHotEncoder(
            inputCol=indexer.getOutputCol(),
            outputCol=f"{indexer.getOutputCol()}_encoded",
        )
        for indexer in indexers
    ]
    stages += indexers + encoders
    continuous_cols = numeric_cols + continuous_cols
    if config["chisq"]:
        discretized_cols = [f"{column}_bucket" for column in continuous_cols]
        stages += [
            QuantileDiscretizer(
                inputCol=column,
                outputCol=f"{column}_bucket",
                numBuckets=CHISQ_BUCKETS,
                handleInvalid="keep",
            )
            for column in continuous_cols
        ]
        continuous_cols = discretized_cols
    assembled_cols = (
        [encoder.getOutputCol() for encoder in encoders] + continuous_cols
    )
    output_col = (
        "features" if not config["variance"] and not config["chisq"] else "assembled_features"
    )
    assembler = VectorAssembler(
        inputCols=assembled_cols,
        outputCol=output_col,
    )
    stages.append(assembler)
    if config["variance"]:
        variance_output = "features" if not config["chisq"] else "variance_features"
        stages.append(
            VarianceThresholdSelector(
                featuresCol="assembled_features",
                outputCol=variance_output,
                varianceThreshold=MIN_BINARY_VARIANCE,
            )
        )
    if config["chisq"]:
        chisq_input = "variance_features" if config["variance"] else "assembled_features"
        stages.append(
            ChiSqSelector(
                numTopFeatures=CHISQ_TOP_FEATURES,
                featuresCol=chisq_input,
                outputCol="features",
                labelCol="label",
            )
        )
    return Pipeline(stages=stages)


def save_json_split(dataset, hdfs_path, local_path):
    """Save train or test split to HDFS and collect it locally."""
    dataset.select("features", "label").coalesce(1).write.mode("overwrite").format("json").save(
        hdfs_path
    )
    run(f"rm -f {local_path} && hdfs dfs -cat {hdfs_path}/part* > {local_path}")


def save_predictions(predictions, hdfs_path, local_path):
    """Save model predictions to HDFS and collect them locally."""
    (
        predictions.select("label", "prediction")
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save(hdfs_path)
    )
    run(f"rm -f {local_path} && hdfs dfs -cat {hdfs_path}/part* > {local_path}")


def evaluate(predictions, metric_name):
    """Evaluate binary predictions with Spark ML evaluator."""
    return BinaryClassificationEvaluator(
        labelCol="label",
        rawPredictionCol="rawPrediction",
        metricName=metric_name,
    ).evaluate(predictions)


def train_logistic_regression(train_data, test_data, save_artifacts):
    """Train Logistic Regression with cross-validation."""
    model = LogisticRegression()
    evaluator = BinaryClassificationEvaluator(
        labelCol="label",
        rawPredictionCol="rawPrediction",
        metricName="areaUnderROC",
    )
    grid = (
        ParamGridBuilder()
        .addGrid(model.regParam, [0.0, 0.01, 0.1])
        .addGrid(model.elasticNetParam, [0.0, 0.5, 1.0])
        .build()
    )
    cv_model = CrossValidator(
        estimator=model,
        estimatorParamMaps=grid,
        evaluator=evaluator,
        parallelism=5,
        numFolds=3,
    ).fit(train_data)
    best_model = cv_model.bestModel
    predictions = best_model.transform(test_data)
    if save_artifacts:
        best_model.write().overwrite().save("project/models/model1")
        run("rm -rf models/model1 && hdfs dfs -get project/models/model1 models/model1")
        save_predictions(
            predictions,
            "project/output/model1_predictions",
            "output/model1_predictions.csv",
        )
    return cv_model, grid, evaluate(predictions, "areaUnderROC"), evaluate(
        predictions,
        "areaUnderPR",
    )


def train_random_forest(train_data, test_data, save_artifacts):
    """Train Random Forest with cross-validation."""
    model = RandomForestClassifier()
    evaluator = BinaryClassificationEvaluator(
        labelCol="label",
        rawPredictionCol="rawPrediction",
        metricName="areaUnderROC",
    )
    grid = (
        ParamGridBuilder()
        .addGrid(model.numTrees, [10, 20, 30])
        .addGrid(model.maxDepth, [5, 10, 15])
        .build()
    )
    cv_model = CrossValidator(
        estimator=model,
        estimatorParamMaps=grid,
        evaluator=evaluator,
        parallelism=5,
        numFolds=3,
    ).fit(train_data)
    best_model = cv_model.bestModel
    predictions = best_model.transform(test_data)
    if save_artifacts:
        best_model.write().overwrite().save("project/models/model2")
        run("rm -rf models/model2 && hdfs dfs -get project/models/model2 models/model2")
        save_predictions(
            predictions,
            "project/output/model2_predictions",
            "output/model2_predictions.csv",
        )
    return cv_model, grid, evaluate(predictions, "areaUnderROC"), evaluate(
        predictions,
        "areaUnderPR",
    )


def save_evaluation(spark, rows):
    """Save best model metrics for the dashboard."""
    (
        spark.createDataFrame(rows, ["model", "area_under_roc", "area_under_pr"])
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save("project/output/evaluation")
    )
    run(
        "rm -f output/evaluation.csv && "
        "hdfs dfs -cat project/output/evaluation/part* > output/evaluation.csv"
    )


def save_feature_set_evaluation(spark, rows):
    """Save evaluation metrics for all feature-set variants."""
    (
        spark.createDataFrame(
            rows,
            ["feature_set", "model", "area_under_roc", "area_under_pr"],
        )
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save("project/output/feature_set_evaluation")
    )
    run(
        "rm -f output/feature_set_evaluation.csv && "
        "hdfs dfs -cat project/output/feature_set_evaluation/part* > "
        "output/feature_set_evaluation.csv"
    )


def get_param(param_map, name):
    """Get parameter value from Spark ML parameter map."""
    values = [str(value) for param, value in param_map.items() if param.name == name]
    return values[0] if values else ""


def save_hyperparameter_results(spark, rows):
    """Save best feature-set hyperparameter results for the dashboard."""
    (
        spark.createDataFrame(
            rows,
            [
                "model",
                "param_set",
                "reg_param",
                "elastic_net_param",
                "num_trees",
                "max_depth",
                "cv_area_under_roc",
                "is_best",
            ],
        )
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save("project/output/hyperparameter_results")
    )
    run(
        "rm -f output/hyperparameter_results.csv && "
        "hdfs dfs -cat project/output/hyperparameter_results/part* > "
        "output/hyperparameter_results.csv"
    )


def best_evaluation_rows(rows):
    """Select the best feature-set result for each model."""
    return [
        [row[1], row[2], row[3]]
        for row in best_feature_set_rows(rows).values()
    ]


def best_feature_set_rows(rows):
    """Select the best feature-set row for each model."""
    best_by_model = {}
    for feature_set, model, roc, pr in rows:
        if model not in best_by_model or roc > best_by_model[model][2]:
            best_by_model[model] = [feature_set, model, roc, pr]
    return best_by_model


def best_hyperparameter_rows(rows, evaluation_rows):
    """Keep hyperparameter rows that belong to the best feature-set per model."""
    best_feature_sets = {
        model: row[0]
        for model, row in best_feature_set_rows(evaluation_rows).items()
    }
    return [
        row[1:]
        for row in rows
        if row[0] == best_feature_sets[row[1]]
    ]


def build_hyperparameter_rows(feature_set, lr_cv, lr_grid, rf_cv, rf_grid):
    """Build cross-validation rows for one feature-set variant."""
    lr_best_metric = max(lr_cv.avgMetrics)
    rf_best_metric = max(rf_cv.avgMetrics)
    lr_rows = [
        [
            feature_set,
            "LogisticRegression",
            index + 1,
            get_param(param_map, "regParam"),
            get_param(param_map, "elasticNetParam"),
            "",
            "",
            float(lr_cv.avgMetrics[index]),
            "yes" if lr_cv.avgMetrics[index] == lr_best_metric else "no",
        ]
        for index, param_map in enumerate(lr_grid)
    ]
    rf_rows = [
        [
            feature_set,
            "RandomForestClassifier",
            index + 1,
            "",
            "",
            get_param(param_map, "numTrees"),
            get_param(param_map, "maxDepth"),
            float(rf_cv.avgMetrics[index]),
            "yes" if rf_cv.avgMetrics[index] == rf_best_metric else "no",
        ]
        for index, param_map in enumerate(rf_grid)
    ]
    return lr_rows + rf_rows


def save_feature_set_hyperparameter_results(spark, rows):
    """Save cross-validation results for all feature-set variants."""
    (
        spark.createDataFrame(
            rows,
            [
                "feature_set",
                "model",
                "param_set",
                "reg_param",
                "elastic_net_param",
                "num_trees",
                "max_depth",
                "cv_area_under_roc",
                "is_best",
            ],
        )
        .coalesce(1)
        .write.mode("overwrite")
        .format("csv")
        .option("sep", ",")
        .option("header", "true")
        .save("project/output/feature_set_hyperparameter_results")
    )
    run(
        "rm -f output/feature_set_hyperparameter_results.csv && "
        "hdfs dfs -cat project/output/feature_set_hyperparameter_results/part* > "
        "output/feature_set_hyperparameter_results.csv"
    )


def fill_missing_values(jobs, categorical_cols, numeric_cols, time_cols, geo_cols):
    """Fill missing values before vector assembly."""
    for column in categorical_cols:
        jobs = jobs.withColumn(column, F.coalesce(F.col(column).cast("string"), F.lit("missing")))
    for column in numeric_cols + geo_cols:
        jobs = jobs.withColumn(column, F.coalesce(F.col(column).cast("double"), F.lit(0.0)))
    for column in time_cols:
        jobs = jobs.withColumn(column, F.to_timestamp(column))
    return jobs


def prepare_modeling_data(jobs, selected_features, config):
    """Build feature vectors and stratified train/test split."""
    jobs = jobs.select(selected_features + [LABEL])
    categorical_cols, numeric_cols, time_cols, geo_cols = split_features_by_type(
        jobs,
        selected_features,
    )
    jobs = fill_missing_values(jobs, categorical_cols, numeric_cols, time_cols, geo_cols)
    jobs = jobs.withColumn(
        "label",
        F.when(F.col(LABEL) == "P", F.lit(1.0)).otherwise(F.lit(0.0)),
    )
    pipeline_model = build_feature_pipeline(
        categorical_cols,
        numeric_cols,
        time_cols,
        geo_cols,
        config,
    ).fit(jobs)
    data = pipeline_model.transform(jobs).select(["features", "label"])
    feature_indexer = VectorIndexer(
        inputCol="features",
        outputCol="indexedFeatures",
        maxCategories=4,
    ).fit(data)
    transformed = feature_indexer.transform(data).withColumn(
        "row_id",
        F.monotonically_increasing_id(),
    )
    train_data = transformed.sampleBy(
        "label",
        fractions={0.0: 0.7, 1.0: 0.7},
        seed=10,
    )
    test_data = transformed.join(
        train_data.select("row_id"),
        on="row_id",
        how="left_anti",
    ).drop("row_id")
    return train_data.drop("row_id"), test_data


def train_models(train_data, test_data, save_artifacts):
    """Train both model families for one feature set."""
    lr_cv, lr_grid, roc_lr, pr_lr = train_logistic_regression(
        train_data,
        test_data,
        save_artifacts,
    )
    rf_cv, rf_grid, roc_rf, pr_rf = train_random_forest(
        train_data,
        test_data,
        save_artifacts,
    )
    return {
        "lr_cv": lr_cv,
        "lr_grid": lr_grid,
        "rf_cv": rf_cv,
        "rf_grid": rf_grid,
        "roc_lr": roc_lr,
        "pr_lr": pr_lr,
        "roc_rf": roc_rf,
        "pr_rf": pr_rf,
    }


def run_feature_set(jobs, catalog, eligible_features, config):
    """Train both models for one feature-set variant."""
    feature_set = config["name"]
    selected_features = select_variant_features(
        catalog,
        eligible_features,
        config["coverage"],
    )
    train_data, test_data = prepare_modeling_data(jobs, selected_features, config)
    save_artifacts = feature_set == FINAL_FEATURE_SET
    if save_artifacts:
        save_json_split(train_data, "project/data/train", "data/train.json")
        save_json_split(test_data, "project/data/test", "data/test.json")
    model_results = train_models(train_data, test_data, save_artifacts)
    return {
        "feature_set": feature_set,
        "features": selected_features,
        "evaluation": [
            [
                feature_set,
                "LogisticRegression",
                float(model_results["roc_lr"]),
                float(model_results["pr_lr"]),
            ],
            [
                feature_set,
                "RandomForestClassifier",
                float(model_results["roc_rf"]),
                float(model_results["pr_rf"]),
            ],
        ],
        "hyperparameters": build_hyperparameter_rows(
            feature_set,
            model_results["lr_cv"],
            model_results["lr_grid"],
            model_results["rf_cv"],
            model_results["rf_grid"],
        ),
        "final": model_results,
    }


def save_final_outputs(spark, evaluation_rows, hyperparameter_rows):
    """Save dashboard-compatible final model outputs."""
    save_evaluation(spark, best_evaluation_rows(evaluation_rows))
    save_hyperparameter_results(
        spark,
        best_hyperparameter_rows(hyperparameter_rows, evaluation_rows),
    )


def main():
    """Run the complete Stage 3 modeling workflow."""
    spark = build_spark_session()
    jobs = spark.table(HIVE_TABLE)
    jobs = jobs.filter(F.col(LABEL).isin("P", "J"))
    catalog_rows, eligible_features = build_feature_catalog(jobs)
    catalog = {row["feature"]: row for row in catalog_rows}
    save_feature_set_catalog(spark, catalog_rows)
    all_evaluation_rows = []
    all_hyperparameter_rows = []
    final_features = []
    for config in FEATURE_SET_CONFIGS:
        result = run_feature_set(jobs, catalog, eligible_features, config)
        all_evaluation_rows += result["evaluation"]
        all_hyperparameter_rows += result["hyperparameters"]
        if result["feature_set"] == FINAL_FEATURE_SET:
            final_features = result["features"]
    save_feature_extraction(spark, catalog_rows, final_features)
    save_feature_set_evaluation(spark, all_evaluation_rows)
    save_feature_set_hyperparameter_results(spark, all_hyperparameter_rows)
    save_final_outputs(spark, all_evaluation_rows, all_hyperparameter_rows)


if __name__ == "__main__":
    main()
