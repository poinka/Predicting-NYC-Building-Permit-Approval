This folder contains the exported outputs of the pipeline.

It collects results from different stages in one place.

Main files in this folder are:

- `hive_results.txt` — output of the initial Hive table creation step
- `hive_optimization_results.txt` — output of partitioning and bucketing step
- `hive_cleanup_results.txt` — output of removing the temporary external Hive table
- `dashboard_results.txt` — output of preparing Hive datasets for Superset
- `q1.csv ... q9.csv` — EDA query results
- `q1.jpg ... q7.jpg` — chart images used for analysis and reporting
- `model1_predictions.csv` and `model2_predictions.csv` — model predictions on the test set
- `evaluation.csv` — side-by-side comparison of model metrics

This folder is the main local destination for final results.
