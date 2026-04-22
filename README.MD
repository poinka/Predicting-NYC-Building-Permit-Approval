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

- `output/q1.csv ... output/q9.csv` for EDA tables
- `output/q1.jpg ... output/q7.jpg` for exported EDA charts
- `output/model1_predictions.csv` and `output/model2_predictions.csv` for ML predictions
- `output/evaluation.csv` for model comparison
- `output/hive_results.txt`, `output/hive_optimization_results.txt`, and `output/dashboard_results.txt` for Hive execution logs
- `data/train.json` and `data/test.json` for exported ML splits
- `models/model1/` and `models/model2/` for trained Spark models

## How Stage 2 Feeds Stage 4

The EDA queries from Stage 2 produce structured outputs such as approval-rate summaries, geographic summaries, and feature coverage tables. These are first saved as files in HDFS and then collected into local CSV files in `output/`.

Stage 4 uses those same Stage 2 outputs again. It creates Hive external tables such as `dashboard_q1`, `dashboard_q2`, ..., `dashboard_q9`, so that Superset can read them directly as datasets for charts.

The ML results from Stage 3 are exposed to Hive as `dashboard_model1_predictions`, `dashboard_model2_predictions`, and `dashboard_evaluation`.

Stage 4 is an aggregation layer. It does not recompute analytics or retrain models. It exposes the prepared EDA and ML outputs in a form that Superset can visualize.

## Notes

`requirements.txt` lists Python dependencies used by the scripts.

`main.sh` is part of the course template and is meant to be kept unchanged for assessment compatibility.

The notebooks in `notebooks/` are reference material. The grader may delete that folder to verify that the actual pipeline still runs from `scripts/`.
