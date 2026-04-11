#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SECRETS_FILE="$ROOT_DIR/secrets/.hive.pass"
OUTPUT_FILE="$ROOT_DIR/output/hive_cleanup_results.txt"
HQL_FILE="$ROOT_DIR/sql/cleanup.hql"

if [ ! -f "$SECRETS_FILE" ]; then
    echo "Hive password file not found: $SECRETS_FILE"
    exit 1
fi

if [ ! -f "$HQL_FILE" ]; then
    echo "HiveQL file not found: $HQL_FILE"
    exit 1
fi

mkdir -p "$ROOT_DIR/output"

password=$(head -n 1 "$SECRETS_FILE")

beeline \
  -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 \
  -n team13 \
  -p "$password" \
  -f "$HQL_FILE" \
  > "$OUTPUT_FILE" 2> /dev/null

echo "Hive cleanup script executed successfully."
echo "Results saved to: $OUTPUT_FILE"