USE team13_projectdb_hive;

DROP TABLE IF EXISTS q9_results;

CREATE EXTERNAL TABLE q9_results (
    metric STRING,
    value BIGINT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q9';

INSERT OVERWRITE TABLE q9_results
SELECT metric, value
FROM (
    SELECT 'rows_in_pj_subset' AS metric, COUNT(*) AS value
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')

    UNION ALL

    SELECT 'rows_after_drop_like_full_model', COUNT(*) AS value
    FROM fact_job_applications_opt
    WHERE job_status IN ('P','J')
      AND borough IS NOT NULL
      AND job_type IS NOT NULL
      AND professional_cert IS NOT NULL
      AND owner_type IS NOT NULL
      AND building_class IS NOT NULL
      AND existing_occupancy IS NOT NULL
      AND proposed_occupancy IS NOT NULL
      AND landmarked IS NOT NULL
      AND pc_filed IS NOT NULL
      AND efiling_filed IS NOT NULL
      AND plumbing IS NOT NULL
      AND mechanical IS NOT NULL
      AND boiler IS NOT NULL
      AND sprinkler IS NOT NULL
      AND fire_alarm IS NOT NULL
      AND equipment IS NOT NULL
      AND fire_suppression IS NOT NULL
      AND curb_cut IS NOT NULL
      AND initial_cost IS NOT NULL
      AND total_est_fee IS NOT NULL
      AND existing_zoning_sqft IS NOT NULL
      AND proposed_zoning_sqft IS NOT NULL
      AND enlargement_sqft IS NOT NULL
      AND street_frontage IS NOT NULL
      AND proposed_no_of_stories IS NOT NULL
      AND proposed_height IS NOT NULL
      AND proposed_dwelling_units IS NOT NULL
      AND total_construction_floor_area IS NOT NULL
      AND gis_latitude IS NOT NULL
      AND gis_longitude IS NOT NULL
) t;

SELECT * FROM q9_results;

INSERT OVERWRITE DIRECTORY 'project/output/q9'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q9_results;
