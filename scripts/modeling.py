import math
import os

import pyspark.sql.functions as F
from pyspark.ml import Pipeline, Transformer
from pyspark.ml.classification import LogisticRegression, RandomForestClassifier
from pyspark.ml.evaluation import BinaryClassificationEvaluator
from pyspark.ml.feature import OneHotEncoder, StringIndexer, VectorAssembler, VectorIndexer
from pyspark.ml.tuning import CrossValidator, ParamGridBuilder
from pyspark.sql import SparkSession


class DatePartsTransformer(Transformer):
    def __init__(self, inputCol):
        super().__init__()
        self.inputCol = inputCol

    def _transform(self, df):
        return df.withColumn("filing_year", F.year(F.col(self.inputCol))).withColumn("filing_month", F.month(F.col(self.inputCol))).withColumn("filing_day", F.dayofmonth(F.col(self.inputCol)))


class SinCosTransformer(Transformer):
    def __init__(self, inputCol, period, sinCol, cosCol):
        super().__init__()
        self.inputCol = inputCol
        self.period = period
        self.sinCol = sinCol
        self.cosCol = cosCol

    def _transform(self, df):
        angle = 2 * math.pi * F.col(self.inputCol) / F.lit(self.period)
        return df.withColumn(self.sinCol, F.sin(angle)).withColumn(self.cosCol, F.cos(angle))


class GeoToECEFTransformer(Transformer):
    def __init__(self, latCol, lonCol):
        super().__init__()
        self.latCol = latCol
        self.lonCol = lonCol

    def _transform(self, df):
        radius = F.lit(6378137.0)
        lat = F.radians(F.col(self.latCol))
        lon = F.radians(F.col(self.lonCol))
        return df.withColumn("gis_x", radius * F.cos(lat) * F.cos(lon)).withColumn("gis_y", radius * F.cos(lat) * F.sin(lon)).withColumn("gis_z", radius * F.sin(lat))


def run(command):
    return os.popen(command).read()


team = "team13"
warehouse = "project/hive/warehouse"

spark = SparkSession.builder.appName("{} - spark ML".format(team)).master("yarn").config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883").config("spark.sql.warehouse.dir", warehouse).config("spark.sql.avro.compression.codec", "snappy").enableHiveSupport().getOrCreate()

features = ["borough", "job_type", "professional_cert", "owner_type", "building_class", "existing_occupancy", "proposed_occupancy", "landmarked", "existing_zoning_sqft", "proposed_zoning_sqft", "enlargement_sqft", "street_frontage", "proposed_no_of_stories", "proposed_height", "proposed_dwelling_units", "total_construction_floor_area", "pre_filing_date", "gis_latitude", "gis_longitude"]
label = "job_status"

jobs = spark.table("team13_projectdb_hive.fact_job_applications_opt")
jobs = jobs.filter(F.col(label).isin("P", "J"))
jobs = jobs.withColumn("pre_filing_date", F.to_timestamp("pre_filing_date"))
min_non_null = jobs.count() * 0.5
feature_counts = jobs.select([F.count(c).alias(c) for c in features]).collect()[0].asDict()
features = [c for c in features if feature_counts[c] >= min_non_null]
jobs = jobs.select(features + [label]).na.drop()
jobs = jobs.withColumn("label", F.when(F.col("job_status") == "P", F.lit(1.0)).otherwise(F.lit(0.0)))

categoricalCols = [c for c in ["borough", "job_type", "professional_cert", "owner_type", "building_class", "existing_occupancy", "proposed_occupancy", "landmarked"] if c in features]
numericCols = [c for c in ["existing_zoning_sqft", "proposed_zoning_sqft", "enlargement_sqft", "street_frontage", "proposed_no_of_stories", "proposed_height", "proposed_dwelling_units", "total_construction_floor_area"] if c in features]
timeCols = [c for c in ["pre_filing_date"] if c in features]
geoCols = [c for c in ["gis_latitude", "gis_longitude"] if c in features]

dateTransformer = DatePartsTransformer(timeCols[0])
monthTransformer = SinCosTransformer("filing_month", 12, "filing_month_sin", "filing_month_cos")
dayTransformer = SinCosTransformer("filing_day", 31, "filing_day_sin", "filing_day_cos")
geoTransformer = GeoToECEFTransformer(geoCols[0], geoCols[1])

indexers = [StringIndexer(inputCol=c, outputCol="{}_indexed".format(c)).setHandleInvalid("skip") for c in categoricalCols]
encoders = [OneHotEncoder(inputCol=indexer.getOutputCol(), outputCol="{}_encoded".format(indexer.getOutputCol())) for indexer in indexers]
assembler = VectorAssembler(inputCols=[encoder.getOutputCol() for encoder in encoders] + numericCols + ["filing_year", "filing_month_sin", "filing_month_cos", "filing_day_sin", "filing_day_cos", "gis_x", "gis_y", "gis_z"], outputCol="features")
pipeline = Pipeline(stages=[dateTransformer, monthTransformer, dayTransformer, geoTransformer] + indexers + encoders + [assembler])

model = pipeline.fit(jobs)
data = model.transform(jobs).select(["features", "label"])
featureIndexer = VectorIndexer(inputCol="features", outputCol="indexedFeatures", maxCategories=4).fit(data)
transformed = featureIndexer.transform(data).withColumn("row_id", F.monotonically_increasing_id())
train_data = transformed.sampleBy("label", fractions={0.0: 0.7, 1.0: 0.7}, seed=10)
test_data = transformed.join(train_data.select("row_id"), on="row_id", how="left_anti").drop("row_id")
train_data = train_data.drop("row_id")

train_data.select("features", "label").coalesce(1).write.mode("overwrite").format("json").save("project/data/train")
run("rm -f data/train.json && hdfs dfs -cat project/data/train/part* > data/train.json")
test_data.select("features", "label").coalesce(1).write.mode("overwrite").format("json").save("project/data/test")
run("rm -f data/test.json && hdfs dfs -cat project/data/test/part* > data/test.json")

lr = LogisticRegression()
model_lr = lr.fit(train_data)
predictions = model_lr.transform(test_data)
evaluator1_roc = BinaryClassificationEvaluator(labelCol="label", rawPredictionCol="rawPrediction", metricName="areaUnderROC")
grid = ParamGridBuilder().addGrid(lr.regParam, [0.0, 0.01, 0.1]).addGrid(lr.elasticNetParam, [0.0, 0.5, 1.0]).build()
cv = CrossValidator(estimator=lr, estimatorParamMaps=grid, evaluator=evaluator1_roc, parallelism=5, numFolds=3)
model1 = cv.fit(train_data).bestModel
model1.write().overwrite().save("project/models/model1")
run("rm -rf models/model1 && hdfs dfs -get project/models/model1 models/model1")
predictions = model1.transform(test_data)
predictions.select("label", "prediction").coalesce(1).write.mode("overwrite").format("csv").option("sep", ",").option("header", "true").save("project/output/model1_predictions")
run("rm -f output/model1_predictions.csv && hdfs dfs -cat project/output/model1_predictions/part* > output/model1_predictions.csv")
roc1 = BinaryClassificationEvaluator(labelCol="label", rawPredictionCol="rawPrediction", metricName="areaUnderROC").evaluate(predictions)
pr1 = BinaryClassificationEvaluator(labelCol="label", rawPredictionCol="rawPrediction", metricName="areaUnderPR").evaluate(predictions)

rf = RandomForestClassifier()
model_rf = rf.fit(train_data)
predictions = model_rf.transform(test_data)
evaluator2_roc = BinaryClassificationEvaluator(labelCol="label", rawPredictionCol="rawPrediction", metricName="areaUnderROC")
grid = ParamGridBuilder().addGrid(rf.numTrees, [10, 20, 30]).addGrid(rf.maxDepth, [5, 10, 15]).build()
cv = CrossValidator(estimator=rf, estimatorParamMaps=grid, evaluator=evaluator2_roc, parallelism=5, numFolds=3)
model2 = cv.fit(train_data).bestModel
model2.write().overwrite().save("project/models/model2")
run("rm -rf models/model2 && hdfs dfs -get project/models/model2 models/model2")
predictions = model2.transform(test_data)
predictions.select("label", "prediction").coalesce(1).write.mode("overwrite").format("csv").option("sep", ",").option("header", "true").save("project/output/model2_predictions")
run("rm -f output/model2_predictions.csv && hdfs dfs -cat project/output/model2_predictions/part* > output/model2_predictions.csv")
roc2 = BinaryClassificationEvaluator(labelCol="label", rawPredictionCol="rawPrediction", metricName="areaUnderROC").evaluate(predictions)
pr2 = BinaryClassificationEvaluator(labelCol="label", rawPredictionCol="rawPrediction", metricName="areaUnderPR").evaluate(predictions)

models = [[str(model1), roc1, pr1], [str(model2), roc2, pr2]]
df = spark.createDataFrame(models, ["model", "area_under_roc", "area_under_pr"])
df.coalesce(1).write.mode("overwrite").format("csv").option("sep", ",").option("header", "true").save("project/output/evaluation")
run("rm -f output/evaluation.csv && hdfs dfs -cat project/output/evaluation/part* > output/evaluation.csv")
