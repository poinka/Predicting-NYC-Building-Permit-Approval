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
SELECT feature, COUNT(value) AS non_null_rows
FROM fact_job_applications_opt
LATERAL VIEW STACK(
    30,
    'borough', CAST(borough AS STRING),
    'job_type', CAST(job_type AS STRING),
    'professional_cert', CAST(professional_cert AS STRING),
    'owner_type', CAST(owner_type AS STRING),
    'building_class', CAST(building_class AS STRING),
    'existing_occupancy', CAST(existing_occupancy AS STRING),
    'proposed_occupancy', CAST(proposed_occupancy AS STRING),
    'landmarked', CAST(landmarked AS STRING),
    'pc_filed', CAST(pc_filed AS STRING),
    'efiling_filed', CAST(efiling_filed AS STRING),
    'plumbing', CAST(plumbing AS STRING),
    'mechanical', CAST(mechanical AS STRING),
    'boiler', CAST(boiler AS STRING),
    'sprinkler', CAST(sprinkler AS STRING),
    'fire_alarm', CAST(fire_alarm AS STRING),
    'equipment', CAST(equipment AS STRING),
    'fire_suppression', CAST(fire_suppression AS STRING),
    'curb_cut', CAST(curb_cut AS STRING),
    'initial_cost', CAST(initial_cost AS STRING),
    'total_est_fee', CAST(total_est_fee AS STRING),
    'existing_zoning_sqft', CAST(existing_zoning_sqft AS STRING),
    'proposed_zoning_sqft', CAST(proposed_zoning_sqft AS STRING),
    'enlargement_sqft', CAST(enlargement_sqft AS STRING),
    'street_frontage', CAST(street_frontage AS STRING),
    'proposed_no_of_stories', CAST(proposed_no_of_stories AS STRING),
    'proposed_height', CAST(proposed_height AS STRING),
    'proposed_dwelling_units', CAST(proposed_dwelling_units AS STRING),
    'total_construction_floor_area', CAST(total_construction_floor_area AS STRING),
    'gis_latitude', CAST(gis_latitude AS STRING),
    'gis_longitude', CAST(gis_longitude AS STRING)
) s AS feature, value
WHERE job_status IN ('P','J')
GROUP BY feature;

SELECT * FROM q8_results;

INSERT OVERWRITE DIRECTORY 'project/output/q8'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
SELECT * FROM q8_results;
