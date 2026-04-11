#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

echo "===== Stage 2: Verify AVRO schema in HDFS ====="
hdfs dfs -ls /user/team13/project/warehouse/avsc
hdfs dfs -ls /user/team13/project/warehouse/fact_job_applications

echo "===== Stage 2: Create Hive database and external table ====="
bash "$ROOT_DIR/scripts/run_hive_db.sh"

echo "===== Stage 2: Create partitioned and bucketed table ====="
bash "$ROOT_DIR/scripts/run_hive_optimization.sh"

echo "===== Stage 2: Remove unpartitioned external table ====="
bash "$ROOT_DIR/scripts/run_hive_cleanup.sh"

