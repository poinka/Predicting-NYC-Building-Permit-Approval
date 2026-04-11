#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
VENV_DIR="$ROOT_DIR/venv"
OUTPUT_DIR="$ROOT_DIR/output"

mkdir -p "$OUTPUT_DIR"

echo "===== Stage 1: Data Collection ====="
bash "$ROOT_DIR/scripts/data_collection.sh"

echo "===== Stage 1: Database Build ====="
python3 "$ROOT_DIR/scripts/build_projectdb.py"

echo "===== Stage 1: Sqoop to HDFS ====="
PGHOST=hadoop-04.uni.innopolis.ru bash "$ROOT_DIR/scripts/sqoop_to_hdfs.sh"

echo "===== Stage 1 completed successfully ====="