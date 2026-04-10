START TRANSACTION;

INSERT INTO fact_job_applications (
    job_number,
    doc_number,
    borough,
    house_number,
    street_name,
    block,
    lot,
    bin_number,
    job_type,
    job_status,
    job_status_descr,
    latest_action_date,
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
    pre_filing_date,
    paid,
    fully_paid,
    assigned,
    approved,
    fully_permitted,
    initial_cost,
    total_est_fee,
    fee_status,
    existing_zoning_sqft,
    proposed_zoning_sqft,
    horizontal_enlrgmt,
    vertical_enlrgmt,
    enlargement_sqft,
    street_frontage,
    existing_no_of_stories,
    proposed_no_of_stories,
    existing_height,
    proposed_height,
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
    total_construction_floor_area,
    withdrawal_flag,
    signoff_date,
    special_action_status,
    special_action_date,
    building_class,
    job_no_good_count,
    gis_latitude,
    gis_longitude,
    gis_council_district,
    gis_census_tract,
    gis_nta_name,
    gis_bin
)
SELECT
    CASE
        WHEN NULLIF(TRIM(job_number), '') ~ '^[0-9]+$'
        THEN TRIM(job_number)::BIGINT
    END AS job_number,

    CASE
        WHEN NULLIF(TRIM(doc_number), '') ~ '^[0-9]+$'
        THEN TRIM(doc_number)::INTEGER
    END AS doc_number,

    NULLIF(TRIM(borough), '') AS borough,
    NULLIF(TRIM(house_number), '') AS house_number,
    NULLIF(TRIM(street_name), '') AS street_name,

    CASE
        WHEN NULLIF(TRIM(block), '') ~ '^[0-9]+$'
        THEN TRIM(block)::INTEGER
    END AS block,

    CASE
        WHEN NULLIF(TRIM(lot), '') ~ '^[0-9]+$'
        THEN TRIM(lot)::INTEGER
    END AS lot,

    CASE
        WHEN NULLIF(TRIM(bin_number), '') ~ '^[0-9]+$'
        THEN TRIM(bin_number)::BIGINT
    END AS bin_number,

    NULLIF(TRIM(job_type), '') AS job_type,
    NULLIF(TRIM(job_status), '') AS job_status,
    NULLIF(TRIM(job_status_descr), '') AS job_status_descr,

    NULLIF(TRIM(latest_action_date), '') AS latest_action_date,

    NULLIF(TRIM(building_type), '') AS building_type,

    NULLIF(TRIM(community_board), '') AS community_board,
    NULLIF(TRIM(cluster), '') AS cluster,
    NULLIF(TRIM(landmarked), '') AS landmarked,
    NULLIF(TRIM(adult_estab), '') AS adult_estab,
    NULLIF(TRIM(loft_board), '') AS loft_board,
    NULLIF(TRIM(city_owned), '') AS city_owned,
    NULLIF(TRIM(little_e), '') AS little_e,

    NULLIF(TRIM(pc_filed), '') AS pc_filed,
    NULLIF(TRIM(efiling_filed), '') AS efiling_filed,
    NULLIF(TRIM(plumbing), '') AS plumbing,
    NULLIF(TRIM(mechanical), '') AS mechanical,
    NULLIF(TRIM(boiler), '') AS boiler,
    NULLIF(TRIM(fuel_burning), '') AS fuel_burning,
    NULLIF(TRIM(fuel_storage), '') AS fuel_storage,
    NULLIF(TRIM(standpipe), '') AS standpipe,
    NULLIF(TRIM(sprinkler), '') AS sprinkler,
    NULLIF(TRIM(fire_alarm), '') AS fire_alarm,
    NULLIF(TRIM(equipment), '') AS equipment,
    NULLIF(TRIM(fire_suppression), '') AS fire_suppression,
    NULLIF(TRIM(curb_cut), '') AS curb_cut,
    NULLIF(TRIM(other), '') AS other,
    NULLIF(TRIM(other_description), '') AS other_description,

    NULLIF(TRIM(applicant_first_name), '') AS applicant_first_name,
    NULLIF(TRIM(applicant_last_name), '') AS applicant_last_name,
    NULLIF(TRIM(applicant_professional_title), '') AS applicant_professional_title,
    NULLIF(TRIM(applicant_license), '') AS applicant_license,
    NULLIF(TRIM(professional_cert), '') AS professional_cert,

    NULLIF(TRIM(pre_filing_date), '') AS pre_filing_date,
    NULLIF(TRIM(paid), '') AS paid,
    NULLIF(TRIM(fully_paid), '') AS fully_paid,
    NULLIF(TRIM(assigned), '') AS assigned,
    NULLIF(TRIM(approved), '') AS approved,
    NULLIF(TRIM(fully_permitted), '') AS fully_permitted,
    
    CASE
        WHEN NULLIF(TRIM(initial_cost), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(initial_cost)::NUMERIC(14,2)
    END AS initial_cost,

    CASE
        WHEN NULLIF(TRIM(total_est_fee), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(total_est_fee)::NUMERIC(14,2)
    END AS total_est_fee,

    NULLIF(TRIM(fee_status), '') AS fee_status,

    CASE
        WHEN NULLIF(TRIM(existing_zoning_sqft), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(existing_zoning_sqft)::NUMERIC(14,2)
    END AS existing_zoning_sqft,

    CASE
        WHEN NULLIF(TRIM(proposed_zoning_sqft), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(proposed_zoning_sqft)::NUMERIC(14,2)
    END AS proposed_zoning_sqft,

    NULLIF(TRIM(horizontal_enlrgmt), '') AS horizontal_enlrgmt,
    NULLIF(TRIM(vertical_enlrgmt), '') AS vertical_enlrgmt,

    CASE
        WHEN NULLIF(TRIM(enlargement_sqft), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(enlargement_sqft)::NUMERIC(14,2)
    END AS enlargement_sqft,

    CASE
        WHEN NULLIF(TRIM(street_frontage), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(street_frontage)::NUMERIC(14,2)
    END AS street_frontage,

    CASE
        WHEN NULLIF(TRIM(existing_no_of_stories), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(existing_no_of_stories)::NUMERIC(10,2)
    END AS existing_no_of_stories,

    CASE
        WHEN NULLIF(TRIM(proposed_no_of_stories), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(proposed_no_of_stories)::NUMERIC(10,2)
    END AS proposed_no_of_stories,

    CASE
        WHEN NULLIF(TRIM(existing_height), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(existing_height)::NUMERIC(10,2)
    END AS existing_height,

    CASE
        WHEN NULLIF(TRIM(proposed_height), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(proposed_height)::NUMERIC(10,2)
    END AS proposed_height,

    CASE
        WHEN NULLIF(TRIM(existing_dwelling_units), '') ~ '^[0-9]+$'
        THEN TRIM(existing_dwelling_units)::INTEGER
    END AS existing_dwelling_units,

    CASE
        WHEN NULLIF(TRIM(proposed_dwelling_units), '') ~ '^[0-9]+$'
        THEN TRIM(proposed_dwelling_units)::INTEGER
    END AS proposed_dwelling_units,

    NULLIF(TRIM(existing_occupancy), '') AS existing_occupancy,
    NULLIF(TRIM(proposed_occupancy), '') AS proposed_occupancy,
    NULLIF(TRIM(site_fill), '') AS site_fill,

    NULLIF(TRIM(zoning_dist1), '') AS zoning_dist1,
    NULLIF(TRIM(zoning_dist2), '') AS zoning_dist2,
    NULLIF(TRIM(zoning_dist3), '') AS zoning_dist3,
    NULLIF(TRIM(special_district1), '') AS special_district1,
    NULLIF(TRIM(special_district2), '') AS special_district2,

    NULLIF(TRIM(owner_type), '') AS owner_type,
    NULLIF(TRIM(non_profit), '') AS non_profit,
    NULLIF(TRIM(owner_first_name), '') AS owner_first_name,
    NULLIF(TRIM(owner_last_name), '') AS owner_last_name,
    NULLIF(TRIM(owner_business_name), '') AS owner_business_name,
    NULLIF(TRIM(owner_house_number), '') AS owner_house_number,
    NULLIF(TRIM(owner_house_street_name), '') AS owner_house_street_name,
    NULLIF(TRIM(city), '') AS city,
    NULLIF(TRIM(state), '') AS state,
    NULLIF(TRIM(zip), '') AS zip,
    NULLIF(TRIM(owner_phone), '') AS owner_phone,

    NULLIF(TRIM(job_description), '') AS job_description,

    NULLIF(TRIM(dobrundate), '') AS dobrundate,

    NULLIF(TRIM(job_s1_no), '') AS job_s1_no,

    CASE
        WHEN NULLIF(TRIM(total_construction_floor_area), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(total_construction_floor_area)::NUMERIC(14,2)
    END AS total_construction_floor_area,

    NULLIF(TRIM(withdrawal_flag), '') AS withdrawal_flag,

    NULLIF(TRIM(signoff_date), '') AS signoff_date,

    NULLIF(TRIM(special_action_status), '') AS special_action_status,

    NULLIF(TRIM(special_action_date), '') AS special_action_date,

    NULLIF(TRIM(building_class), '') AS building_class,

    CASE
        WHEN NULLIF(TRIM(job_no_good_count), '') ~ '^[0-9]+$'
        THEN TRIM(job_no_good_count)::INTEGER
    END AS job_no_good_count,

    CASE
        WHEN NULLIF(TRIM(gis_latitude), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(gis_latitude)::DOUBLE PRECISION
    END AS gis_latitude,

    CASE
        WHEN NULLIF(TRIM(gis_longitude), '') ~ '^-?[0-9]+(\.[0-9]+)?$'
        THEN TRIM(gis_longitude)::DOUBLE PRECISION
    END AS gis_longitude,

    NULLIF(TRIM(gis_council_district), '') AS gis_council_district,
    NULLIF(TRIM(gis_census_tract), '') AS gis_census_tract,
    NULLIF(TRIM(gis_nta_name), '') AS gis_nta_name,
    NULLIF(TRIM(gis_bin), '') AS gis_bin

FROM raw_dob_job_applications r;

COMMIT;