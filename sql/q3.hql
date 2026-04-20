SET hive.execution.engine=mr;
USE team13_projectdb_hive;

DROP TABLE IF EXISTS q3_results;

CREATE EXTERNAL TABLE q3_results (
    feature STRING,
    approval_rate DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q3';

-- insight 3 (systems impact)
INSERT OVERWRITE TABLE q3_results
SELECT feature, AVG(val) AS approval_rate
FROM (

    SELECT 'plumbing' AS feature,
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END AS val
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND plumbing = 'X'

    UNION ALL

    SELECT 'mechanical',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND mechanical = 'X'

    UNION ALL

    SELECT 'boiler',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND boiler = 'X'

    UNION ALL

    SELECT 'fuel_burning',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND fuel_burning = 'X'

    UNION ALL

    SELECT 'fuel_storage',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND fuel_storage = 'X'

    UNION ALL

    SELECT 'standpipe',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND standpipe = 'X'

    UNION ALL

    SELECT 'sprinkler',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND sprinkler = 'X'

    UNION ALL

    SELECT 'fire_alarm',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND fire_alarm = 'X'

    UNION ALL

    SELECT 'equipment',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND equipment = 'X'

    UNION ALL

    SELECT 'fire_suppression',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND fire_suppression = 'X'

    UNION ALL

    SELECT 'curb_cut',
        CASE WHEN job_status = 'P' THEN 1 ELSE 0 END
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J') AND curb_cut = 'X'

) t
GROUP BY feature;

SELECT * FROM q3_results;

-- export
INSERT OVERWRITE DIRECTORY 'project/output/q3'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q3_results;