USE team13_projectdb_hive;

DROP VIEW IF EXISTS dashboard_data_characteristics;

CREATE VIEW dashboard_data_characteristics AS
SELECT 'prepared_dataset_rows' AS metric, CAST(COUNT(*) AS STRING) AS value
FROM fact_job_applications_opt

UNION ALL

SELECT 'binary_dataset_rows', CAST(COUNT(*) AS STRING)
FROM fact_job_applications_opt
WHERE job_status IN ('P', 'J')

UNION ALL

SELECT 'modeling_feature_selection_rule', 'keep features with non_null >= 50% in the P/J subset'

UNION ALL

SELECT 'modeling_feature_count_confirmed_by_eda', '18'

UNION ALL

SELECT 'selected_modeling_features', 'borough, job_type, professional_cert, owner_type, building_class, existing_occupancy, proposed_occupancy, landmarked, existing_zoning_sqft, proposed_zoning_sqft, enlargement_sqft, street_frontage, proposed_no_of_stories, proposed_height, proposed_dwelling_units, total_construction_floor_area, gis_latitude, gis_longitude'

UNION ALL

SELECT 'dropped_low_coverage_features', 'pc_filed, efiling_filed, plumbing, mechanical, boiler, sprinkler, fire_alarm, equipment, fire_suppression, curb_cut, initial_cost, total_est_fee'

UNION ALL

SELECT 'target', 'job_status (P=approved, J=disapproved)'

UNION ALL

SELECT 'approved_count', CAST(SUM(CASE WHEN job_status = 'P' THEN 1 ELSE 0 END) AS STRING)
FROM fact_job_applications_opt
WHERE job_status IN ('P', 'J')

UNION ALL

SELECT 'disapproved_count', CAST(SUM(CASE WHEN job_status = 'J' THEN 1 ELSE 0 END) AS STRING)
FROM fact_job_applications_opt
WHERE job_status IN ('P', 'J');

DROP VIEW IF EXISTS dashboard_data_sample;

CREATE VIEW dashboard_data_sample AS
SELECT job_status,
       borough,
       job_type,
       owner_type,
       building_class,
       pre_filing_date,
       gis_latitude,
       gis_longitude
FROM fact_job_applications_opt
WHERE job_status IN ('P', 'J')
LIMIT 20;

DROP TABLE IF EXISTS dashboard_q1;
CREATE EXTERNAL TABLE dashboard_q1 (
    borough STRING,
    job_type STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q1';

DROP TABLE IF EXISTS dashboard_q2;
CREATE EXTERNAL TABLE dashboard_q2 (
    borough STRING,
    job_type STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q2';

DROP TABLE IF EXISTS dashboard_q3;
CREATE EXTERNAL TABLE dashboard_q3 (
    feature STRING,
    approval_rate DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q3';

DROP TABLE IF EXISTS dashboard_q4;
CREATE EXTERNAL TABLE dashboard_q4 (
    professional_cert STRING,
    owner_type STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q4';

DROP TABLE IF EXISTS dashboard_q5;
CREATE EXTERNAL TABLE dashboard_q5 (
    area_bucket STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q5';

DROP TABLE IF EXISTS dashboard_q6;
CREATE EXTERNAL TABLE dashboard_q6 (
    proposed_no_of_stories DOUBLE,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q6';

DROP TABLE IF EXISTS dashboard_q7;
CREATE EXTERNAL TABLE dashboard_q7 (
    gis_nta_name STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q7';

DROP TABLE IF EXISTS dashboard_q8;
CREATE EXTERNAL TABLE dashboard_q8 (
    feature STRING,
    non_null_rows BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q8';

DROP TABLE IF EXISTS dashboard_q9;
CREATE EXTERNAL TABLE dashboard_q9 (
    metric STRING,
    value BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/team13/project/output/q9';

DROP TABLE IF EXISTS dashboard_model1_predictions;
CREATE EXTERNAL TABLE dashboard_model1_predictions (
    label DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
TBLPROPERTIES ('skip.header.line.count'='1')
LOCATION '/user/team13/project/output/model1_predictions';

DROP TABLE IF EXISTS dashboard_model2_predictions;
CREATE EXTERNAL TABLE dashboard_model2_predictions (
    label DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
TBLPROPERTIES ('skip.header.line.count'='1')
LOCATION '/user/team13/project/output/model2_predictions';

DROP TABLE IF EXISTS dashboard_evaluation;
CREATE EXTERNAL TABLE dashboard_evaluation (
    model STRING,
    area_under_roc DOUBLE,
    area_under_pr DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
TBLPROPERTIES ('skip.header.line.count'='1')
LOCATION '/user/team13/project/output/evaluation';

SELECT * FROM dashboard_data_characteristics;
SELECT * FROM dashboard_evaluation;
