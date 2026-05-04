## Project Overview

This project studies NYC building permit plan examination outcomes using the `DOB Job Application Filings` dataset. The final task is a binary classification problem on applications that reached a final plan examination decision:

- `P` means `Plan Exam Approved`
- `J` means `Plan Exam Disapproved`

The repository is organized as a pipeline. Each stage writes its own results either to HDFS, Hive, PostgreSQL, or to local project folders such as `output/`, `data/`, and `models/`.

## How The Project Flows

At a high level, the work is split into four stages.

`Stage 1` collects the raw dataset, loads it into PostgreSQL, converts the raw text table into a typed final table, and sends that table to HDFS through Sqoop.

`Stage 2` creates Hive tables on top of the HDFS data, applies storage optimization such as partitioning and bucketing, and runs EDA queries. The CSV and image files in `output/` come from this stage.

`Stage 3` trains Spark ML classification models on the cluster. It reads the prepared Hive table, selects usable features, builds a feature pipeline, trains models on YARN, and saves train/test splits, model folders, predictions, and evaluation files.

`Stage 4` prepares Hive datasets for Apache Superset. It does not build the dashboard itself in code, but it creates the tables and views that the dashboard will read.

## Stage 3 Feature Selection

The modeling stage does not use all columns from the original DOB table. The first reduction is manual domain-based preselection: columns are kept only if they can reasonably describe an application before the final plan examination outcome is known.

The initial modeling candidate set contains application context, applicant/building attributes, work-scope flags, cost/area fields, time, and geospatial fields:

`borough`, `job_type`, `professional_cert`, `owner_type`, `building_class`, `existing_occupancy`, `proposed_occupancy`, `landmarked`, `pc_filed`, `efiling_filed`, `plumbing`, `mechanical`, `boiler`, `sprinkler`, `fire_alarm`, `equipment`, `fire_suppression`, `curb_cut`, `initial_cost`, `total_est_fee`, `existing_zoning_sqft`, `proposed_zoning_sqft`, `enlargement_sqft`, `street_frontage`, `proposed_no_of_stories`, `proposed_height`, `proposed_dwelling_units`, `total_construction_floor_area`, `pre_filing_date`, `gis_latitude`, `gis_longitude`.

After this preselection, `scripts/modeling.py` applies an automatic coverage rule and keeps only candidate features with at least 50% non-null values in the binary `P/J` subset. The actual selected/dropped result is written to `output/feature_extraction.csv`.

The remaining source columns are not used as model inputs for these reasons:

- Target and target description: `job_status` is the label, and `job_status_descr` is another representation of the outcome.
- Row identifiers and database/import metadata: `fact_id`, `job_number`, `doc_number`, `bin_number`, `gis_bin`, `job_s1_no`, `created_at`.
- Address and parcel identifiers: `house_number`, `street_name`, `block`, `lot`.
- Applicant and owner identity fields: `applicant_first_name`, `applicant_last_name`, `applicant_license`, `owner_first_name`, `owner_last_name`, `owner_business_name`, `owner_house_number`, `owner_house_street_name`, `owner_phone`.
- Free-text fields: `other_description`, `job_description`.
- Post-filing or post-decision dates that can leak process progress or outcome information: `latest_action_date`, `paid`, `fully_paid`, `assigned`, `approved`, `fully_permitted`, `signoff_date`, `special_action_date`, `dobrundate`.
- Administrative status fields that are not stable pre-decision predictors or duplicate process state: `fee_status`, `withdrawal_flag`, `special_action_status`, `job_no_good_count`.
- Rare, sparse, or highly specific work-scope flags not retained in the initial candidate set: `adult_estab`, `loft_board`, `city_owned`, `little_e`, `fuel_burning`, `fuel_storage`, `standpipe`, `other`.
- Zoning, district, and location descriptors that are either sparse, too granular, or represented by other selected fields: `building_type`, `community_board`, `cluster`, `site_fill`, `zoning_dist1`, `zoning_dist2`, `zoning_dist3`, `special_district1`, `special_district2`, `gis_council_district`, `gis_census_tract`, `gis_nta_name`.
- Owner address fields: `city`, `state`, `zip`.
- Applicant title and owner nonprofit flag are excluded because the current model uses `professional_cert` and `owner_type` as simpler applicant/owner signals: `applicant_professional_title`, `non_profit`.
- Existing-size fields are excluded to avoid duplicating proposed-size and change-size fields already retained: `horizontal_enlrgmt`, `vertical_enlrgmt`, `existing_no_of_stories`, `existing_height`, `existing_dwelling_units`.

## Where Things Are

- `data/` contains local dataset files and exported train/test JSON files.
- `models/` contains local copies of trained Spark ML models downloaded from HDFS.
- `notebooks/` contains exploratory and template notebooks. The operational pipeline should not depend on them during assessment.
- `output/` contains human-readable outputs of the pipeline: Hive command logs, EDA CSV files, chart images, model predictions, and evaluation tables.
- `scripts/` contains the executable pipeline logic. This is the main folder to read if you want to understand what actually runs.
- `sql/` contains the SQL and HiveQL files that define tables, transformations, analytics queries, and dashboard datasets.

## Main Entry Point

`main.sh` runs the whole pipeline in order:

1. `preprocess.sh`
2. `stage1.sh`
3. `stage2.sh`
4. `stage3.sh`
5. `stage4.sh`
6. `postprocess.sh`

The stages can also be run one by one during development:

```bash
bash scripts/stage2.sh
bash scripts/stage3.sh
bash scripts/stage4.sh
```

This is useful when only one part of the project is being updated.

## What To Look At After Running

The main files to inspect after a run are:

- `output/q1.csv ... output/q8.csv` for EDA tables
- `output/q1.jpg ... output/q8.jpg` for exported EDA charts
- `output/model1_predictions.csv` and `output/model2_predictions.csv` for ML predictions
- `output/evaluation.csv` for model comparison
- `output/feature_extraction.csv` for the actual Stage 3 feature-selection result
- `output/hyperparameter_results.csv` for cross-validation results of all tested hyperparameter configurations
- `output/hive_results.txt`, `output/hive_optimization_results.txt`, and `output/dashboard_results.txt` for Hive execution logs
- `data/train.json` and `data/test.json` for exported ML splits
- `models/model1/` and `models/model2/` for trained Spark models

## How Stage 2 Feeds Stage 4

The EDA queries from Stage 2 produce structured outputs such as approval-rate summaries, geographic summaries, and feature coverage tables. These are saved in Hive/HDFS and collected into local CSV files in `output/`.

Stage 4 does not rerun the Stage 2 EDA queries. Superset can use the Hive result tables from Stage 2 directly for `q1` to `q7`. Stage 4 prepares additional dashboard datasets for feature coverage, model predictions, model evaluation, and hyperparameter tuning results.

The ML results from Stage 3 are exposed to Hive as `dashboard_model1_predictions`, `dashboard_model2_predictions`, `dashboard_evaluation`, `dashboard_feature_extraction`, and `dashboard_hyperparameter_results`.

Stage 4 is an aggregation layer. It does not recompute analytics or retrain models. It exposes the prepared EDA and ML outputs in a form that Superset can visualize.

## Notes

`requirements.txt` lists Python dependencies used by the scripts.

`main.sh` is part of the course template and is meant to be kept unchanged for assessment compatibility.

The notebooks in `notebooks/` are reference material. The grader may delete that folder to verify that the actual pipeline still runs from `scripts/`.
