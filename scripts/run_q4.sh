#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SECRETS_FILE="$ROOT_DIR/secrets/.hive.pass"
HQL_FILE="$ROOT_DIR/sql/q4.hql"

password=$(head -n 1 "$SECRETS_FILE")

beeline \
  -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 \
  -n team13 \
  -p "$password" \
  -f "$HQL_FILE"

echo "Q4 executed successfully"