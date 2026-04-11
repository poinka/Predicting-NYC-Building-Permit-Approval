DROP DATABASE IF EXISTS team13_projectdb_hive CASCADE;

CREATE DATABASE team13_projectdb_hive
LOCATION 'project/hive/warehouse';

USE team13_projectdb_hive;

CREATE EXTERNAL TABLE fact_job_applications_ext
STORED AS AVRO
LOCATION 'project/warehouse/fact_job_applications'
TBLPROPERTIES (
  'avro.schema.url'='project/warehouse/avsc/fact_job_applications.avsc'
);

SHOW DATABASES;
SHOW TABLES;
DESCRIBE FORMATTED fact_job_applications_ext;
SELECT * FROM fact_job_applications_ext LIMIT 10;
SELECT borough, COUNT(*) AS cnt
FROM fact_job_applications_ext
GROUP BY borough
ORDER BY cnt DESC;