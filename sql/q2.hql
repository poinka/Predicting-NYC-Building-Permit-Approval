USE team13_projectdb_hive;

DROP TABLE IF EXISTS q2_results;

CREATE EXTERNAL TABLE q2_results (
    borough STRING,
    job_type STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q2';

-- insight 2 (partition pruning)
INSERT OVERWRITE TABLE q2_results
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
WHERE job_status IN ('P','J') -- partition pruning by job_status
  AND borough IN ('BROOKLYN', 'MANHATTAN')  -- analytical borough filter
GROUP BY borough, job_type;

SELECT * FROM q2_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q2'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q2_results;