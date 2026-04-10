#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

echo "===== Stage 1: Data Collection ====="
bash "$ROOT_DIR/scripts/data_collection.sh"

echo "===== Stage 1: Database Build + Sqoop ====="
bash "$ROOT_DIR/scripts/data_storage.sh"

echo "===== Stage 1 completed successfully ====="