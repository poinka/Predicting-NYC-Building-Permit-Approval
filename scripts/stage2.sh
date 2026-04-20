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

echo "===== Stage 2: Run analytical queries ====="

run_query () {
  local q=$1
  local header=$2

  echo "---- Running Q$q ----"

  # cleanup HDFS output 
  hdfs dfs -rm -r -f project/output/q$q || true

  # create 
  bash "$ROOT_DIR/scripts/run_q$q.sh"

  # cleanup local csv
  rm -f "$ROOT_DIR/output/q$q.csv"

  # write header
  echo "$header" > "$ROOT_DIR/output/q$q.csv"

  # append data
  hdfs dfs -cat project/output/q$q/* >> "$ROOT_DIR/output/q$q.csv"

  echo "Q$q done"
}


# Q1
run_query 1 "borough,job_type,approval_rate,n"

# Q2
run_query 2 "borough,job_type,approval_rate,n"

# Q3
run_query 3 "feature,approval_rate"

# Q4
run_query 4 "professional_cert,owner_type,approval_rate,n"

# Q5
run_query 5 "area_bucket,approval_rate,n"

# Q6
run_query 6 "proposed_no_of_stories,approval_rate,n"

# Q7
run_query 7 "gis_nta_name,approval_rate,n"

echo "===== Stage 2 completed successfully ====="
