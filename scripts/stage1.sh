#!/bin/bash
set -euo pipefail

# Timing helpers
STAGE1_START_TIME=$(date +%s)

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

print_stage1_summary() {
    local stage1_end_time
    local total_duration

    stage1_end_time=$(date +%s)
    total_duration=$((stage1_end_time - STAGE1_START_TIME))

    echo
    echo "Stage 1 execution summary"

    for step_name in "${!STEP_DURATIONS[@]}"; do
        printf "%-35s %8ss\n" "$step_name" "${STEP_DURATIONS[$step_name]}"
    done

    printf "%-35s %8ss\n" "TOTAL" "$total_duration"
}

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
VENV_DIR="$ROOT_DIR/venv"
OUTPUT_DIR="$ROOT_DIR/output"

mkdir -p "$OUTPUT_DIR"

echo "===== Stage 1: Data Collection ====="
start_step "Data collection"
bash "$ROOT_DIR/scripts/data_collection.sh"
end_step "Data collection"

echo "===== Stage 1: Database Build ====="
start_step "Database build"
python3 "$ROOT_DIR/scripts/build_projectdb.py"
end_step "Database build"

echo "===== Stage 1: Sqoop to HDFS ====="
start_step "Sqoop to HDFS"
PGHOST=hadoop-04.uni.innopolis.ru bash "$ROOT_DIR/scripts/sqoop_to_hdfs.sh"
end_step "Sqoop to HDFS"

echo "===== Stage 1 completed successfully ====="
print_stage1_summary