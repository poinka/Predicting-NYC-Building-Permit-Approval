This folder contains the executable pipeline.

The main files are the stage scripts:

- `stage1.sh` runs data collection, PostgreSQL loading, and Sqoop export to HDFS
- `stage2.sh` runs Hive preparation, optimization, cleanup, and all EDA queries
- `stage3.sh` runs Spark ML modeling on YARN
- `stage4.sh` prepares Hive datasets for Apache Superset

The helper scripts are:

- `data_collection.sh` downloads the raw dataset
- `build_projectdb.py` creates and fills PostgreSQL tables
- `sqoop_to_hdfs.sh` exports the final PostgreSQL table into HDFS as Avro
- `run_hive_db.sh`, `run_hive_optimization.sh`, `run_hive_cleanup.sh` run the main Hive steps
- `run_q1.sh ... run_q8.sh` execute individual EDA queries
- `run_hive_dashboard.sh` prepares the Hive layer that Superset will later use
- `modeling.py` contains the actual Spark ML pipeline used in Stage 3

`modeling.py` starts from a manually selected set of modeling candidates. It then keeps only features with at least 50% non-null values in the binary `P/J` subset. For categorical columns, it also removes columns with only one distinct value after filtering, because constant categorical columns cannot be encoded as useful model features.

`scripts/` contains the executable order of the project pipeline.
