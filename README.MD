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

The modeling stage starts from the prepared Hive table schema. Before automatic feature selection, the code excludes only the target itself and process-leakage fields that describe the decision process after the filing is already moving through DOB review.

The target fields are excluded because they directly contain the answer:

- `job_status` is the binary label used for prediction.
- `job_status_descr` is the text description of the same status.

The leakage fields are excluded because they describe downstream workflow state, payments, assignment, approval, signoff, withdrawal, or later DOB action dates:

- `latest_action_date` records the latest status/action date and can summarize process progress.
- `paid` records payment timing after the filing enters the process.
- `fully_paid` records completed payment timing.
- `assigned` records assignment to review workflow.
- `approved` records the approval date, which directly leaks the positive outcome.
- `fully_permitted` records a later permitting milestone after approval workflow.
- `signoff_date` records signoff after review/permitting progress.
- `special_action_status` records a special administrative action state.
- `special_action_date` records the date of that special administrative action.
- `withdrawal_flag` records whether the filing was withdrawn during the process.
- `fee_status` records fee/payment state after filing.
- `job_no_good_count` records DOB process/problem status rather than a stable pre-review application attribute.
- `dobrundate` records dataset processing/update timing rather than an application attribute.

All other columns remain eligible candidates. Names, addresses, IDs, phone numbers, free-text fields, zoning descriptors, work-scope flags, ownership fields, and building descriptors are not manually removed. They are removed only if an automatic selector rejects them.

The remaining candidate columns are converted by type: categorical fields are indexed and one-hot encoded, numerical fields are assembled directly, the filing date is decomposed into cyclical date features, and latitude/longitude are converted into geospatial coordinates.

The code then compares several automatic feature-selection variants:

- all eligible structured features;
- the same feature set after `VarianceThresholdSelector` with threshold `0.05`;
- features with at least 50% non-null coverage, followed by `VarianceThresholdSelector`;
- the coverage and variance-selected feature set followed by chi-square supervised selection.

The dashboard-compatible final feature summary is saved to:

```text
output/feature_extraction.csv
```

The full source-column catalog with exclusion reasons is saved to:

```text
output/feature_catalog.csv
```

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
- `output/feature_catalog.csv` — source-column profiling and exclusion reasons
- `output/feature_set_evaluation.csv` — model metrics for each feature-selection variant
- `output/feature_set_hyperparameter_results.csv` — hyperparameter tuning results for each feature-selection variant

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
