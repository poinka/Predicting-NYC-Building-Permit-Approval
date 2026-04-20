USE team13_projectdb_hive;

DROP TABLE IF EXISTS q4_results;

CREATE EXTERNAL TABLE q4_results (
    professional_cert STRING,
    owner_type STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q4';

-- insight 4
INSERT OVERWRITE TABLE q4_results
SELECT
    professional_cert,
    owner_type,
    AVG(
        CASE 
            WHEN job_status = 'P' THEN 1
            WHEN job_status = 'J' THEN 0
        END
    ) AS approval_rate,
    COUNT(*) AS n
FROM fact_job_applications_opt
WHERE job_status IN ('P','J')
  AND professional_cert IS NOT NULL
GROUP BY professional_cert, owner_type;

SELECT * FROM q4_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q4'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q4_results;