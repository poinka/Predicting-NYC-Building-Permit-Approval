#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

echo "===== Stage 4: Prepare Hive datasets for Superset ====="
bash "$ROOT_DIR/scripts/run_hive_dashboard.sh"

echo "===== Stage 4 completed successfully ====="
