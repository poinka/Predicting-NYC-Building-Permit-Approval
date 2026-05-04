## Project Overview

This project predicts NYC Department of Buildings plan examination outcomes from the `DOB Job Application Filings` dataset.

The modeling task is binary classification on applications that reached a final plan examination decision:

- `P` — Plan Exam Approved
- `J` — Plan Exam Disapproved

The source dataset contains DOB job permit applications submitted through Borough Offices, eFiling, or the HUB since January 1, 2000. The project stores the processed data in Hive and trains Spark ML models on the Hadoop YARN cluster.

## Pipeline Stages

`Stage 1` collects the raw CSV dataset, loads it into PostgreSQL, converts the raw text table into a typed final table, and exports the final table to HDFS through Sqoop.

`Stage 2` creates Hive tables over the HDFS data, applies storage preparation, and runs EDA queries. The optimized Hive table is partitioned by borough and bucketed by `job_status`.

`Stage 3` performs predictive modeling with Spark ML on YARN. It reads the prepared Hive table, builds the feature pipeline, trains two classification models, evaluates them, and exports model artifacts and result tables.

`Stage 4` prepares Hive tables and views for Apache Superset dashboard charts.

## Repository Layout

- `data/` contains local data artifacts exported by the pipeline, including `train.json` and `test.json`.
- `models/` contains local copies of the trained Spark ML models downloaded from HDFS.
- `notebooks/` contains notebooks used for data understanding and modeling experiments.
- `output/` contains pipeline outputs: EDA CSV files and charts, Hive execution logs, model predictions, model evaluation, feature extraction results, and hyperparameter tuning results.
- `scripts/` contains executable pipeline scripts.
- `sql/` contains PostgreSQL SQL, HiveQL, EDA queries, optimization queries, and dashboard preparation queries.

## Running The Pipeline

The full pipeline entry point is:

```bash
bash main.sh
```

Individual stages can be run directly:

```bash
bash scripts/stage1.sh
bash scripts/stage2.sh
bash scripts/stage3.sh
bash scripts/stage4.sh
```

The Stage 3 modeling code must be run on the cluster, not on a local machine:

```bash
ssh team13@10.100.30.57
cd /home/team13/Predicting-NYC-Building-Permit-Approval
bash scripts/stage3.sh
```

Stage 4 prepares Hive datasets for Superset:

```bash
bash scripts/stage4.sh
```

## Stage 3 Modeling

The modeling code is in `scripts/modeling.py`.

The model reads `team13_projectdb_hive.fact_job_applications_opt`, keeps records with `job_status IN ('P', 'J')`, converts the label to a binary Spark ML label column, and uses a 70/30 stratified train/test split.

Two model families are trained:

- Logistic Regression
- Random Forest Classifier

Both models are tuned with cross-validation. The hyperparameter results are saved to `output/hyperparameter_results.csv`.

The final evaluation uses:

- Area Under ROC
- Area Under PR

The final model comparison is saved to `output/evaluation.csv`.

## Feature Selection

The original dataset has more columns than the modeling stage uses. The first reduction is manual domain-based preselection: fields are kept only if they can describe an application before the final plan examination outcome is known and can be represented reasonably in Spark ML.

The initial candidate feature set is:

`borough`, `job_type`, `professional_cert`, `owner_type`, `building_class`, `existing_occupancy`, `proposed_occupancy`, `landmarked`, `pc_filed`, `efiling_filed`, `plumbing`, `mechanical`, `boiler`, `sprinkler`, `fire_alarm`, `equipment`, `fire_suppression`, `curb_cut`, `initial_cost`, `total_est_fee`, `existing_zoning_sqft`, `proposed_zoning_sqft`, `enlargement_sqft`, `street_frontage`, `proposed_no_of_stories`, `proposed_height`, `proposed_dwelling_units`, `total_construction_floor_area`, `pre_filing_date`, `gis_latitude`, `gis_longitude`.

After this preselection, `scripts/modeling.py` applies automatic selection rules:

- keep features with at least 50% non-null values in the binary `P/J` subset;
- for categorical features, also require at least two distinct values after filtering.

The actual selected and dropped features are saved to:

```text
output/feature_extraction.csv
```

The remaining source columns are excluded for the following reasons:

- Target fields: `job_status`, `job_status_descr`.
- Row identifiers and import metadata: `fact_id`, `job_number`, `doc_number`, `bin_number`, `gis_bin`, `job_s1_no`, `created_at`.
- Address and parcel identifiers: `house_number`, `street_name`, `block`, `lot`.
- Applicant and owner identity fields: `applicant_first_name`, `applicant_last_name`, `applicant_license`, `owner_first_name`, `owner_last_name`, `owner_business_name`, `owner_house_number`, `owner_house_street_name`, `owner_phone`.
- Free-text fields: `other_description`, `job_description`.
- Post-filing or post-decision dates that can leak process progress or outcome information: `latest_action_date`, `paid`, `fully_paid`, `assigned`, `approved`, `fully_permitted`, `signoff_date`, `special_action_date`, `dobrundate`.
- Administrative status fields that duplicate process state or are not stable pre-decision predictors: `fee_status`, `withdrawal_flag`, `special_action_status`, `job_no_good_count`.
- Sparse or highly specific work-scope flags not retained in the initial candidate set: `adult_estab`, `loft_board`, `city_owned`, `little_e`, `fuel_burning`, `fuel_storage`, `standpipe`, `other`.
- Zoning, district, and location descriptors that are sparse, too granular, or represented by selected fields: `building_type`, `community_board`, `cluster`, `site_fill`, `zoning_dist1`, `zoning_dist2`, `zoning_dist3`, `special_district1`, `special_district2`, `gis_council_district`, `gis_census_tract`, `gis_nta_name`.
- Owner address fields: `city`, `state`, `zip`.
- Applicant title and nonprofit flag: `applicant_professional_title`, `non_profit`.
- Existing-size fields that duplicate proposed-size and change-size fields already retained: `horizontal_enlrgmt`, `vertical_enlrgmt`, `existing_no_of_stories`, `existing_height`, `existing_dwelling_units`.

## Stage 3 Outputs

The modeling stage writes these local artifacts:

- `data/train.json` — exported training split
- `data/test.json` — exported test split
- `models/model1/` — saved Logistic Regression Spark model
- `models/model2/` — saved Random Forest Spark model
- `output/model1_predictions.csv` — predictions from model 1
- `output/model2_predictions.csv` — predictions from model 2
- `output/evaluation.csv` — final model metrics
- `output/feature_extraction.csv` — feature extraction and feature selection summary
- `output/hyperparameter_results.csv` — cross-validation results for all tested hyperparameter configurations

The same modeling outputs are also stored in HDFS under `project/data`, `project/models`, and `project/output`.

## Stage 2 And Stage 4 Data Flow

Stage 2 creates the EDA result tables and files. Queries `q1` to `q7` are data insights used in the dashboard. Query `q8` records feature coverage and supports the modeling feature-selection explanation.

Stage 4 prepares Hive datasets for the Superset dashboard:

- `dashboard_model1_predictions`
- `dashboard_model2_predictions`
- `dashboard_evaluation`
- `dashboard_feature_extraction`
- `dashboard_feature_selection`
- `dashboard_hyperparameter_results`
- `dashboard_class_balance`

These Hive objects are used as Superset datasets for the dashboard charts.

## Notes

`requirements.txt` lists Python dependencies used by the scripts.
