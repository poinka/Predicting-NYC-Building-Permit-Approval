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
    echo "Stage 4 execution summary"

    for step_name in "${!STEP_DURATIONS[@]}"; do
        printf "%-35s %8ss\n" "$step_name" "${STEP_DURATIONS[$step_name]}"
    done

    printf "%-35s %8ss\n" "TOTAL" "$total_duration"
}


ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

echo "===== Stage 4: Prepare Hive datasets for Superset ====="
start_step "Run Hive dashboard setup"
bash "$ROOT_DIR/scripts/run_hive_dashboard.sh"
end_step "Run Hive dashboard setup"

echo "===== Stage 4 completed successfully ====="
print_stage_summary