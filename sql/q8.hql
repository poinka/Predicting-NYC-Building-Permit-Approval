USE team13_projectdb_hive;

DROP TABLE IF EXISTS q8_results;

CREATE EXTERNAL TABLE q8_results (
    feature STRING,
    non_null_rows BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q8';

INSERT OVERWRITE TABLE q8_results
SELECT feature, non_null_rows
FROM (
    SELECT 'borough' AS feature, COUNT(borough) AS non_null_rows
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'job_type', COUNT(job_type)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'professional_cert', COUNT(professional_cert)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'owner_type', COUNT(owner_type)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'building_class', COUNT(building_class)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'existing_occupancy', COUNT(existing_occupancy)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'proposed_occupancy', COUNT(proposed_occupancy)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'landmarked', COUNT(landmarked)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'pc_filed', COUNT(pc_filed)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'efiling_filed', COUNT(efiling_filed)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'plumbing', COUNT(plumbing)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'mechanical', COUNT(mechanical)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'boiler', COUNT(boiler)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'sprinkler', COUNT(sprinkler)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'fire_alarm', COUNT(fire_alarm)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'equipment', COUNT(equipment)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'fire_suppression', COUNT(fire_suppression)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'curb_cut', COUNT(curb_cut)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'initial_cost', COUNT(initial_cost)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'total_est_fee', COUNT(total_est_fee)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'existing_zoning_sqft', COUNT(existing_zoning_sqft)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'proposed_zoning_sqft', COUNT(proposed_zoning_sqft)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'enlargement_sqft', COUNT(enlargement_sqft)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'street_frontage', COUNT(street_frontage)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'proposed_no_of_stories', COUNT(proposed_no_of_stories)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'proposed_height', COUNT(proposed_height)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'proposed_dwelling_units', COUNT(proposed_dwelling_units)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'total_construction_floor_area', COUNT(total_construction_floor_area)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'gis_latitude', COUNT(gis_latitude)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'gis_longitude', COUNT(gis_longitude)
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')
) t;

SELECT * FROM q8_results;

INSERT OVERWRITE DIRECTORY 'project/output/q8'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q8_results;
