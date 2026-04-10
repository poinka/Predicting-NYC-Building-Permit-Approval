set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DATA_DIR="$ROOT_DIR/data"
OUT_FILE="$DATA_DIR/dob_job_application_filings.csv"

mkdir -p "$DATA_DIR"

PUBLIC_URL="https://disk.yandex.ru/d/Vzo23GVkkY_F2w"
API_ENDPOINT="https://cloud-api.yandex.net/v1/disk/public/resources/download"

TMP_JSON="$(mktemp)"
trap 'rm -f "$TMP_JSON"' EXIT

echo "Getting direct download link from Yandex Disk..."

curl --fail --silent --show-error --get \
  --data-urlencode "public_key=${PUBLIC_URL}" \
  "$API_ENDPOINT" \
  -o "$TMP_JSON"

if [ ! -s "$TMP_JSON" ]; then
    echo "Yandex Disk API returned an empty response."
    exit 1
fi

echo "API response preview:"
head -c 300 "$TMP_JSON"
echo
echo

DIRECT_URL=$(
  python3 - "$TMP_JSON" <<'PY'
import json
import sys

path = sys.argv[1]
with open(path, "r", encoding="utf-8") as f:
    data = json.load(f)

href = data.get("href")
if not href:
    raise SystemExit(f"No 'href' in API response: {data}")

print(href)
PY
)

echo "Downloading dataset to $OUT_FILE ..."
curl --fail --location --output "$OUT_FILE" "$DIRECT_URL"

if [ ! -s "$OUT_FILE" ]; then
    echo "Downloaded file is missing or empty: $OUT_FILE"
    exit 1
fi

echo "Download completed."
ls -lh "$OUT_FILE"