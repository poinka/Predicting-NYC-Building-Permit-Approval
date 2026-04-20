USE team13_projectdb_hive;

DROP TABLE IF EXISTS q5_results;

CREATE EXTERNAL TABLE q5_results (
    area_bucket STRING,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q5';

-- insight 5
INSERT OVERWRITE TABLE q5_results
SELECT
    CASE
        WHEN total_construction_floor_area = 0 THEN '0'
        WHEN total_construction_floor_area < 1000 THEN '<1k'
        WHEN total_construction_floor_area < 5000 THEN '1k-5k'
        WHEN total_construction_floor_area < 20000 THEN '5k-20k'
        WHEN total_construction_floor_area < 100000 THEN '20k-100k'
        ELSE '100k+'
    END AS area_bucket,
    AVG(
        CASE 
            WHEN job_status = 'P' THEN 1
            WHEN job_status = 'J' THEN 0
        END
    ) AS approval_rate,
    COUNT(*) AS n
FROM fact_job_applications_opt
WHERE job_status IN ('P','J')
GROUP BY
    CASE
        WHEN total_construction_floor_area = 0 THEN '0'
        WHEN total_construction_floor_area < 1000 THEN '<1k'
        WHEN total_construction_floor_area < 5000 THEN '1k-5k'
        WHEN total_construction_floor_area < 20000 THEN '5k-20k'
        WHEN total_construction_floor_area < 100000 THEN '20k-100k'
        ELSE '100k+'
    END;

SELECT * FROM q5_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q5'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q5_results;