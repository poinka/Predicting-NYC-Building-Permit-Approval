#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DATA_DIR="$ROOT_DIR/data"
MODELS_DIR="$ROOT_DIR/models"
OUTPUT_DIR="$ROOT_DIR/output"

mkdir -p "$DATA_DIR" "$MODELS_DIR" "$OUTPUT_DIR"

echo "===== Stage 3: Spark ML on YARN ====="
spark-submit --master yarn "$ROOT_DIR/scripts/modeling.py"

echo "===== Stage 3: Collect train/test splits ====="
hdfs dfs -cat project/data/train/part* > "$DATA_DIR/train.json"
hdfs dfs -cat project/data/test/part* > "$DATA_DIR/test.json"

echo "===== Stage 3: Collect models ====="
rm -rf "$MODELS_DIR/model1" "$MODELS_DIR/model2"
hdfs dfs -get project/models/model1 "$MODELS_DIR"
hdfs dfs -get project/models/model2 "$MODELS_DIR"

collect_csv () {
  local hdfs_dir=$1
  local local_file=$2

  rm -f "$local_file"
  hdfs dfs -cat "$hdfs_dir"/part* > "$local_file"
}

echo "===== Stage 3: Collect metrics and predictions ====="
collect_csv project/output/model1_predictions "$OUTPUT_DIR/model1_predictions.csv"
collect_csv project/output/model2_predictions "$OUTPUT_DIR/model2_predictions.csv"
collect_csv project/output/evaluation "$OUTPUT_DIR/evaluation.csv"

echo "===== Stage 3 completed successfully ====="
