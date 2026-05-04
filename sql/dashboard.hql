USE team13_projectdb_hive;

DROP VIEW IF EXISTS dashboard_data_characteristics;
CREATE VIEW dashboard_data_characteristics AS
SELECT 'prepared_dataset_rows' AS metric, CAST(COUNT(*) AS STRING) AS value
FROM fact_job_applications_opt;

DROP TABLE IF EXISTS dashboard_q8;
CREATE EXTERNAL TABLE dashboard_q8 (
    feature STRING,
    non_null_rows BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q8';

DROP TABLE IF EXISTS dashboard_feature_extraction;
CREATE EXTERNAL TABLE dashboard_feature_extraction (
    feature STRING,
    feature_group STRING,
    non_null_rows BIGINT,
    selection_threshold_rows BIGINT,
    distinct_values BIGINT,
    selected STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/feature_extraction'
TBLPROPERTIES ('skip.header.line.count'='1');

DROP VIEW IF EXISTS dashboard_feature_selection;
CREATE VIEW dashboard_feature_selection AS
SELECT feature, feature_group, non_null_rows, selection_threshold_rows, distinct_values, selected
FROM dashboard_feature_extraction;

DROP TABLE IF EXISTS dashboard_model1_predictions;
CREATE EXTERNAL TABLE dashboard_model1_predictions (
    label DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/model1_predictions'
TBLPROPERTIES ('skip.header.line.count'='1');

DROP TABLE IF EXISTS dashboard_model2_predictions;
CREATE EXTERNAL TABLE dashboard_model2_predictions (
    label DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/model2_predictions'
TBLPROPERTIES ('skip.header.line.count'='1');

DROP TABLE IF EXISTS dashboard_evaluation;
CREATE EXTERNAL TABLE dashboard_evaluation (
    model STRING,
    area_under_roc DOUBLE,
    area_under_pr DOUBLE
)
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
LOCATION '/user/team13/project/output/evaluation'
TBLPROPERTIES ('skip.header.line.count'='1');

DROP TABLE IF EXISTS dashboard_hyperparameter_results;
CREATE EXTERNAL TABLE dashboard_hyperparameter_results (
    model STRING,
    param_set INT,
    reg_param STRING,
    elastic_net_param STRING,
    num_trees STRING,
    max_depth STRING,
    cv_area_under_roc DOUBLE,
    is_best STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/hyperparameter_results'
TBLPROPERTIES ('skip.header.line.count'='1');

DROP VIEW IF EXISTS dashboard_class_balance;
CREATE VIEW dashboard_class_balance AS
SELECT job_status, COUNT(*) AS cnt
FROM fact_job_applications_opt
WHERE job_status IN ('P','J')
GROUP BY job_status;

SELECT * FROM dashboard_evaluation;
SELECT * FROM dashboard_feature_selection;
SELECT * FROM dashboard_hyperparameter_results;
