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
    echo "Stage 3 execution summary"

    for step_name in "${!STEP_DURATIONS[@]}"; do
        printf "%-35s %8ss\n" "$step_name" "${STEP_DURATIONS[$step_name]}"
    done

    printf "%-35s %8ss\n" "TOTAL" "$total_duration"
}


ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DATA_DIR="$ROOT_DIR/data"
MODELS_DIR="$ROOT_DIR/models"
OUTPUT_DIR="$ROOT_DIR/output"

mkdir -p "$DATA_DIR" "$MODELS_DIR" "$OUTPUT_DIR"

echo "===== Stage 3: Spark ML on YARN ====="
start_step "Spark ML"
cd "$ROOT_DIR"
spark-submit --master yarn "$ROOT_DIR/scripts/modeling.py"
end_step "Spark ML"

echo "===== Stage 3 completed successfully ====="
print_stage_summary