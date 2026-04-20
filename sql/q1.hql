USE team13_projectdb_hive;

DROP TABLE IF EXISTS q1_results;

CREATE EXTERNAL TABLE q1_results (
    borough STRING,
    job_type STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q1';

-- insight 1
INSERT OVERWRITE TABLE q1_results
SELECT
    borough,
    job_type,
    AVG(
        CASE 
            WHEN job_status = 'P' THEN 1
            WHEN job_status = 'J' THEN 0
        END
    ) AS approval_rate,
    COUNT(*) AS n
FROM fact_job_applications_opt
WHERE job_status IN ('P','J')
GROUP BY borough, job_type;

SELECT * FROM q1_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q1'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q1_results;