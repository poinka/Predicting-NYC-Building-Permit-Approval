#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DATA_DIR="$ROOT_DIR/data"
MODELS_DIR="$ROOT_DIR/models"
OUTPUT_DIR="$ROOT_DIR/output"

mkdir -p "$DATA_DIR" "$MODELS_DIR" "$OUTPUT_DIR"

echo "===== Stage 3: Spark ML on YARN ====="
cd "$ROOT_DIR"
spark-submit --master yarn "$ROOT_DIR/scripts/modeling.py"

echo "===== Stage 3 completed successfully ====="
