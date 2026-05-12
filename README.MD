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
- `dashboard_hyperparameter_results`

These Hive objects are used as Superset datasets for the dashboard charts.

## Notes

`requirements.txt` lists Python dependencies used by the scripts.
