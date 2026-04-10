set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
OUTPUT_DIR="$ROOT_DIR/output"
SECRETS_FILE="$ROOT_DIR/secrets/.psql.pass"

mkdir -p "$OUTPUT_DIR"

DB_HOST="${PGHOST:-hadoop-04.uni.innopolis.ru}"
DB_PORT="${PGPORT:-5432}"
DB_NAME="${PGDATABASE:-team13_projectdb}"
DB_USER="${PGUSER:-team13}"

HDFS_BASE_DIR="/user/${DB_USER}/stage1_sqoop"

DB_PASSWORD="$(cat "$SECRETS_FILE")"

JDBC_URL="jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}"

echo "Cleaning HDFS target directory: $HDFS_BASE_DIR"
hdfs dfs -rm -r -f "$HDFS_BASE_DIR" || true

TABLES=(
  "fact_job_applications"
)

for table in "${TABLES[@]}"; do
  echo "Importing table: $table"

  sqoop import \
    --connect "$JDBC_URL" \
    --username "$DB_USER" \
    --password "$DB_PASSWORD" \
    --table "$table" \
    --target-dir "${HDFS_BASE_DIR}/${table}" \
    --as-avrodatafile \
    --compression-codec snappy \
    --compress \
    --delete-target-dir \
    --outdir "$OUTPUT_DIR" \
    --m 1
done

echo "Sqoop import completed."
hdfs dfs -ls -R "$HDFS_BASE_DIR" | head -100 || true