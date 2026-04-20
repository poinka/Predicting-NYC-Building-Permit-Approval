USE team13_projectdb_hive;

DROP TABLE IF EXISTS q7_results;

CREATE EXTERNAL TABLE q7_results (
    gis_nta_name STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q7';

-- insight 7
INSERT OVERWRITE TABLE q7_results
SELECT
    gis_nta_name,
    AVG(
        CASE 
            WHEN job_status = 'P' THEN 1
            WHEN job_status = 'J' THEN 0
        END
    ) AS approval_rate,
    COUNT(*) AS n
FROM fact_job_applications_opt
WHERE job_status IN ('P','J')
GROUP BY gis_nta_name
HAVING COUNT(*) > 1000;

SELECT * FROM q7_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q7'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q7_results;