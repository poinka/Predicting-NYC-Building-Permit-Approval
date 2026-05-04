This folder contains the exported outputs of the pipeline.

It collects results from different stages in one place.

Main files in this folder are:

- `hive_results.txt` — output of the initial Hive table creation step
- `hive_optimization_results.txt` — output of partitioning and bucketing step
- `hive_cleanup_results.txt` — output of removing the temporary external Hive table
- `dashboard_results.txt` — output of preparing Hive datasets for Superset
- `q1.csv ... q8.csv` — EDA query results
- `q1.jpg ... q8.jpg` — chart images used for analysis and reporting
- `model1_predictions.csv` and `model2_predictions.csv` — model predictions on the test set
- `evaluation.csv` — side-by-side comparison of model metrics
- `feature_extraction.csv` — Stage 3 feature extraction and feature selection table
- `hyperparameter_results.csv` — cross-validation results for all tested hyperparameter configurations

This folder is the main local destination for final results.
