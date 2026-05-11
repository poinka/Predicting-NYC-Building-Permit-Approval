#!/bin/bash
set -euo pipefail

# Timing helpers
STAGE_START_TIME=$(date +%s)

declare -A STEP_START_TIMES
declare -A STEP_DURATIONS

start_step() {
    local step_name="$1"
    echo
    echo "START: ${step_name}"
    STEP_START_TIMES["$step_name"]=$(date +%s)
}

end_step() {
    local step_name="$1"
    local end_time
    local start_time
    local duration

    end_time=$(date +%s)
    start_time=${STEP_START_TIMES["$step_name"]}
    duration=$((end_time - start_time))

    STEP_DURATIONS["$step_name"]=$duration

    echo "END: ${step_name} (${duration}s)"
}

print_stage_summary() {
    local stage_end_time
    local total_duration

    stage_end_time=$(date +%s)
    total_duration=$((stage_end_time - STAGE_START_TIME))

    echo
    echo "Stage 2 execution summary"

    for step_name in "${!STEP_DURATIONS[@]}"; do
        printf "%-35s %8ss\n" "$step_name" "${STEP_DURATIONS[$step_name]}"
    done

    printf "%-35s %8ss\n" "TOTAL" "$total_duration"
}

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
OUTPUT_DIR="$ROOT_DIR/output"

mkdir -p "$OUTPUT_DIR"

echo "===== Stage 2: Verify AVRO schema in HDFS ====="
start_step "Verify AVRO"
hdfs dfs -ls /user/team13/project/warehouse/avsc
hdfs dfs -ls /user/team13/project/warehouse/fact_job_applications
end_step "Verify AVRO"

echo "===== Stage 2: Create Hive database and external table ====="
start_step "Hive tables"
bash "$ROOT_DIR/scripts/run_hive_db.sh"
end_step "Hive tables"

echo "===== Stage 2: Create partitioned and bucketed table ====="
start_step "Hive optimization"
bash "$ROOT_DIR/scripts/run_hive_optimization.sh"
end_step "Hive optimization"

echo "===== Stage 2: Remove unpartitioned external table ====="
start_step "Clean-up"
bash "$ROOT_DIR/scripts/run_hive_cleanup.sh"
end_step "Clean-up"

echo "===== Stage 2: Run analytical queries ====="
start_step "Queries"
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

# Q8
run_query 8 "feature,non_null_rows"

end_step "Queries"
echo "===== Stage 2 completed successfully ====="
print_stage_summary
