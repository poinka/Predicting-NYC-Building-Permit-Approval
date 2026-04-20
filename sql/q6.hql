USE team13_projectdb_hive;

DROP TABLE IF EXISTS q6_results;

CREATE EXTERNAL TABLE q6_results (
    proposed_no_of_stories INT,
    approval_rate DOUBLE,
    n BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q6';

-- insight 6
INSERT OVERWRITE TABLE q6_results
SELECT
    proposed_no_of_stories,
    AVG(
        CASE 
            WHEN job_status = 'P' THEN 1
            WHEN job_status = 'J' THEN 0
        END
    ) AS approval_rate,
    COUNT(*) AS n
FROM fact_job_applications_opt
WHERE job_status IN ('P','J')
GROUP BY proposed_no_of_stories
HAVING COUNT(*) > 200;

SELECT * FROM q6_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q6'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q6_results;