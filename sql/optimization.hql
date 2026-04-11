USE team13_projectdb_hive;

DROP TABLE IF EXISTS fact_job_applications_opt;

CREATE TABLE fact_job_applications_opt (
    fact_id BIGINT,
    job_number BIGINT,
    doc_number INT,
    house_number STRING,
    street_name STRING,
    block INT,
    lot INT,
    bin_number BIGINT,
    job_type STRING,
    job_status STRING,
    job_status_descr STRING,
    latest_action_date DATE,
    building_type STRING,
    community_board STRING,
    cluster STRING,
    landmarked STRING,
    adult_estab STRING,
    loft_board STRING,
    city_owned STRING,
    little_e STRING,
    pc_filed STRING,
    efiling_filed STRING,
    plumbing STRING,
    mechanical STRING,
    boiler STRING,
    fuel_burning STRING,
    fuel_storage STRING,
    standpipe STRING,
    sprinkler STRING,
    fire_alarm STRING,
    equipment STRING,
    fire_suppression STRING,
    curb_cut STRING,
    other STRING,
    other_description STRING,
    applicant_first_name STRING,
    applicant_last_name STRING,
    applicant_professional_title STRING,
    applicant_license STRING,
    professional_cert STRING,
    pre_filing_date DATE,
    paid DATE,
    fully_paid DATE,
    assigned DATE,
    approved DATE,
    fully_permitted DATE,
    initial_cost DECIMAL(14,2),
    total_est_fee DECIMAL(14,2),
    fee_status STRING,
    existing_zoning_sqft DECIMAL(14,2),
    proposed_zoning_sqft DECIMAL(14,2),
    horizontal_enlrgmt STRING,
    vertical_enlrgmt STRING,
    enlargement_sqft DECIMAL(14,2),
    street_frontage DECIMAL(14,2),
    existing_no_of_stories DECIMAL(10,2),
    proposed_no_of_stories DECIMAL(10,2),
    existing_height DECIMAL(10,2),
    proposed_height DECIMAL(10,2),
    existing_dwelling_units INT,
    proposed_dwelling_units INT,
    existing_occupancy STRING,
    proposed_occupancy STRING,
    site_fill STRING,
    zoning_dist1 STRING,
    zoning_dist2 STRING,
    zoning_dist3 STRING,
    special_district1 STRING,
    special_district2 STRING,
    owner_type STRING,
    non_profit STRING,
    owner_first_name STRING,
    owner_last_name STRING,
    owner_business_name STRING,
    owner_house_number STRING,
    owner_house_street_name STRING,
    city STRING,
    state STRING,
    zip STRING,
    owner_phone STRING,
    job_description STRING,
    dobrundate STRING,
    job_s1_no STRING,
    total_construction_floor_area DECIMAL(14,2),
    withdrawal_flag STRING,
    signoff_date DATE,
    special_action_status STRING,
    special_action_date DATE,
    building_class STRING,
    job_no_good_count INT,
    gis_latitude DOUBLE,
    gis_longitude DOUBLE,
    gis_council_district STRING,
    gis_census_tract STRING,
    gis_nta_name STRING,
    gis_bin STRING,
    created_at BIGINT
)
PARTITIONED BY (borough STRING)
CLUSTERED BY (job_status) INTO 8 BUCKETS
STORED AS ORC;

SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
SET hive.enforce.bucketing=true;

INSERT OVERWRITE TABLE fact_job_applications_opt PARTITION (borough)
SELECT
    fact_id,
    job_number,
    doc_number,
    house_number,
    street_name,
    block,
    lot,
    bin_number,
    job_type,
    job_status,
    job_status_descr,

    CASE
        WHEN latest_action_date RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(latest_action_date, 'MM/dd/yyyy')))
        ELSE NULL
    END AS latest_action_date,

    building_type,
    community_board,
    cluster,
    landmarked,
    adult_estab,
    loft_board,
    city_owned,
    little_e,
    pc_filed,
    efiling_filed,
    plumbing,
    mechanical,
    boiler,
    fuel_burning,
    fuel_storage,
    standpipe,
    sprinkler,
    fire_alarm,
    equipment,
    fire_suppression,
    curb_cut,
    other,
    other_description,
    applicant_first_name,
    applicant_last_name,
    applicant_professional_title,
    applicant_license,
    professional_cert,

    CASE
        WHEN pre_filing_date RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(pre_filing_date, 'MM/dd/yyyy')))
        ELSE NULL
    END AS pre_filing_date,

    CASE
        WHEN paid RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(paid, 'MM/dd/yyyy')))
        ELSE NULL
    END AS paid,

    CASE
        WHEN fully_paid RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(fully_paid, 'MM/dd/yyyy')))
        ELSE NULL
    END AS fully_paid,

    CASE
        WHEN assigned RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(assigned, 'MM/dd/yyyy')))
        ELSE NULL
    END AS assigned,

    CASE
        WHEN approved RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(approved, 'MM/dd/yyyy')))
        ELSE NULL
    END AS approved,

    CASE
        WHEN fully_permitted RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(fully_permitted, 'MM/dd/yyyy')))
        ELSE NULL
    END AS fully_permitted,

    CAST(initial_cost AS DECIMAL(14,2)),
    CAST(total_est_fee AS DECIMAL(14,2)),
    fee_status,
    CAST(existing_zoning_sqft AS DECIMAL(14,2)),
    CAST(proposed_zoning_sqft AS DECIMAL(14,2)),
    horizontal_enlrgmt,
    vertical_enlrgmt,
    CAST(enlargement_sqft AS DECIMAL(14,2)),
    CAST(street_frontage AS DECIMAL(14,2)),
    CAST(existing_no_of_stories AS DECIMAL(10,2)),
    CAST(proposed_no_of_stories AS DECIMAL(10,2)),
    CAST(existing_height AS DECIMAL(10,2)),
    CAST(proposed_height AS DECIMAL(10,2)),
    existing_dwelling_units,
    proposed_dwelling_units,
    existing_occupancy,
    proposed_occupancy,
    site_fill,
    zoning_dist1,
    zoning_dist2,
    zoning_dist3,
    special_district1,
    special_district2,
    owner_type,
    non_profit,
    owner_first_name,
    owner_last_name,
    owner_business_name,
    owner_house_number,
    owner_house_street_name,
    city,
    state,
    zip,
    owner_phone,
    job_description,
    dobrundate,
    job_s1_no,
    CAST(total_construction_floor_area AS DECIMAL(14,2)),
    withdrawal_flag,

    CASE
        WHEN signoff_date RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(signoff_date, 'MM/dd/yyyy')))
        ELSE NULL
    END AS signoff_date,

    special_action_status,

    CASE
        WHEN special_action_date RLIKE '^[0-9]{2}/[0-9]{2}/[0-9]{4}$'
        THEN TO_DATE(FROM_UNIXTIME(UNIX_TIMESTAMP(special_action_date, 'MM/dd/yyyy')))
        ELSE NULL
    END AS special_action_date,

    building_class,
    job_no_good_count,
    gis_latitude,
    gis_longitude,
    gis_council_district,
    gis_census_tract,
    gis_nta_name,
    gis_bin,
    created_at,
    borough
FROM fact_job_applications_ext;

SHOW TABLES;
DESCRIBE FORMATTED fact_job_applications_opt;

SELECT borough, COUNT(*) AS cnt
FROM fact_job_applications_opt
GROUP BY borough
ORDER BY cnt DESC;