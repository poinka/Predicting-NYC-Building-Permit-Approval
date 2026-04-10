-- Basic sanity checks
SELECT COUNT(*) AS raw_rows FROM raw_dob_job_applications;
SELECT COUNT(*) AS fact_rows FROM fact_job_applications;

SELECT COUNT(DISTINCT job_number) AS distinct_job_numbers
FROM fact_job_applications;

SELECT *
FROM fact_job_applications
LIMIT 10;

SELECT borough, COUNT(*) AS cnt
FROM fact_job_applications
GROUP BY borough
ORDER BY borough;

SELECT job_status, COUNT(*) AS cnt
FROM fact_job_applications
GROUP BY job_status
ORDER BY cnt DESC
LIMIT 20;

SELECT
    COUNT(*) FILTER (WHERE latest_action_date IS NULL) AS latest_action_date_nulls,
    COUNT(*) FILTER (WHERE gis_latitude IS NULL OR gis_longitude IS NULL) AS missing_geo_rows
FROM fact_job_applications;