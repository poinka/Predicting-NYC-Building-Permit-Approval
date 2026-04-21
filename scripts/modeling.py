from pyspark.sql import SparkSession
import pyspark.sql.functions as F
from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler, Imputer
from pyspark.ml.classification import LogisticRegression, RandomForestClassifier
from pyspark.ml.evaluation import BinaryClassificationEvaluator
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator


team = "team13"
warehouse = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName("{} - spark ML".format(team))\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", warehouse)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()

spark.sql("USE team13_projectdb_hive").show()

data = spark.read.format("orc").table("team13_projectdb_hive.fact_job_applications_opt")

features = [
    "borough",
    "job_type",
    "professional_cert",
    "owner_type",
    "building_class",
    "existing_occupancy",
    "proposed_occupancy",
    "landmarked",
    "pc_filed",
    "efiling_filed",
    "plumbing",
    "mechanical",
    "boiler",
    "sprinkler",
    "fire_alarm",
    "equipment",
    "fire_suppression",
    "curb_cut",
    "initial_cost",
    "total_est_fee",
    "existing_zoning_sqft",
    "proposed_zoning_sqft",
    "enlargement_sqft",
    "street_frontage",
    "proposed_no_of_stories",
    "proposed_height",
    "proposed_dwelling_units",
    "total_construction_floor_area",
    "gis_latitude",
    "gis_longitude",
]

categoricalCols = [
    "borough",
    "job_type",
    "professional_cert",
    "owner_type",
    "building_class",
    "existing_occupancy",
    "proposed_occupancy",
    "landmarked",
    "pc_filed",
    "efiling_filed",
    "plumbing",
    "mechanical",
    "boiler",
    "sprinkler",
    "fire_alarm",
    "equipment",
    "fire_suppression",
    "curb_cut",
]

numericCols = [
    "initial_cost",
    "total_est_fee",
    "existing_zoning_sqft",
    "proposed_zoning_sqft",
    "enlargement_sqft",
    "street_frontage",
    "proposed_no_of_stories",
    "proposed_height",
    "proposed_dwelling_units",
    "total_construction_floor_area",
    "gis_latitude",
    "gis_longitude",
]

data = data.where(F.col("job_status").isin("P", "J"))
data = data.select(features + ["job_status"])

for c in categoricalCols:
    data = data.withColumn(c, F.coalesce(F.col(c).cast("string"), F.lit("missing")))

for c in numericCols:
    data = data.withColumn(c, F.col(c).cast("double"))

data = data.withColumn("label", F.when(F.col("job_status") == "P", 1.0).otherwise(0.0))
data = data.drop("job_status")

indexers = [StringIndexer(inputCol=c, outputCol="{}_indexed".format(c)).setHandleInvalid("keep") for c in categoricalCols]
encoders = [OneHotEncoder(inputCol="{}_indexed".format(c), outputCol="{}_encoded".format(c)) for c in categoricalCols]
imputer = Imputer(inputCols=numericCols, outputCols=numericCols)
assembler = VectorAssembler(
    inputCols=["{}_encoded".format(c) for c in categoricalCols] + numericCols,
    outputCol="features",
)

pipeline = Pipeline(stages=indexers + encoders + [imputer, assembler])
pipelineModel = pipeline.fit(data)
transformed = pipelineModel.transform(data).select("features", "label")

(train_data, test_data) = transformed.randomSplit([0.7, 0.3], seed=42)

train_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

test_data.select("features", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

evaluator = BinaryClassificationEvaluator(
    labelCol="label",
    rawPredictionCol="rawPrediction",
    metricName="areaUnderROC",
)

lr = LogisticRegression(labelCol="label", featuresCol="features")
lr_grid = ParamGridBuilder()\
    .addGrid(lr.regParam, [0.01, 0.1, 0.3])\
    .addGrid(lr.elasticNetParam, [0.0, 0.5, 1.0])\
    .build()
lr_cv = CrossValidator(
    estimator=lr,
    estimatorParamMaps=lr_grid,
    evaluator=evaluator,
    numFolds=3,
    parallelism=3,
)
lr_cv_model = lr_cv.fit(train_data)
model1 = lr_cv_model.bestModel
model1.write().overwrite().save("project/models/model1")

predictions1 = model1.transform(test_data)
predictions1.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model1_predictions")

auc1 = evaluator.evaluate(predictions1)

rf = RandomForestClassifier(labelCol="label", featuresCol="features", seed=42)
rf_grid = ParamGridBuilder()\
    .addGrid(rf.numTrees, [30, 60, 90])\
    .addGrid(rf.maxDepth, [5, 10, 15])\
    .build()
rf_cv = CrossValidator(
    estimator=rf,
    estimatorParamMaps=rf_grid,
    evaluator=evaluator,
    numFolds=3,
    parallelism=3,
)
rf_cv_model = rf_cv.fit(train_data)
model2 = rf_cv_model.bestModel
model2.write().overwrite().save("project/models/model2")

predictions2 = model2.transform(test_data)
predictions2.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/model2_predictions")

auc2 = evaluator.evaluate(predictions2)

models = [
    ["LogisticRegression", auc1],
    ["RandomForestClassifier", auc2],
]
df = spark.createDataFrame(models, ["model", "areaUnderROC"])
df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/evaluation")

spark.stop()
