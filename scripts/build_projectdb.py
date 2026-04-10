import os
from pathlib import Path
from pprint import pprint

import psycopg2 as psql


ROOT_DIR = Path(__file__).resolve().parent.parent
SQL_DIR = ROOT_DIR / "sql"
DATA_DIR = ROOT_DIR / "data"
SECRETS_DIR = ROOT_DIR / "secrets"

DB_HOST = os.getenv("PGHOST", "hadoop-04.uni.innopolis.ru")
DB_PORT = int(os.getenv("PGPORT", "5432"))
DB_NAME = os.getenv("PGDATABASE", "team13_projectdb")
DB_USER = os.getenv("PGUSER", "team13")

CSV_FILE = DATA_DIR / "dob_job_application_filings.csv"
PASSWORD_FILE = SECRETS_DIR / ".psql.pass"


def read_password() -> str:
    """Read the PostgreSQL password from the secrets file.

    Returns:
        str: Database password stored in secrets/.psql.pass.
    """
    with open(PASSWORD_FILE, "r", encoding="utf-8") as f:
        return f.read().strip()


def run_sql_file(cur, path: Path) -> None:
    """Execute all SQL statements from a file using an open cursor.

    Args:
        cur: Active psycopg2 cursor used to execute SQL statements.
        path (Path): Path to the SQL file that should be executed.
    """
    with open(path, "r", encoding="utf-8") as f:
        cur.execute(f.read())


def main() -> None:
    """Build and validate the PostgreSQL database for Stage 1.

    The function performs the full database pipeline:
    1. checks that the dataset CSV and password file exist,
    2. connects to PostgreSQL,
    3. creates tables from create_tables.sql,
    4. loads the raw CSV into raw_dob_job_applications,
    5. transforms raw data into the fact table,
    6. runs validation queries from test_database.sql.

    Raises:
        FileNotFoundError: If the dataset CSV or password file is missing.
    """
    if not CSV_FILE.exists():
        raise FileNotFoundError(f"Dataset file not found: {CSV_FILE}")

    if not PASSWORD_FILE.exists():
        raise FileNotFoundError(f"Password file not found: {PASSWORD_FILE}")

    password = read_password()

    conn = psql.connect(
        host=DB_HOST,
        port=DB_PORT,
        dbname=DB_NAME,
        user=DB_USER,
        password=password,
    )

    try:
        with conn:
            with conn.cursor() as cur:
                print("Running create_tables.sql ...")
                run_sql_file(cur, SQL_DIR / "create_tables.sql")

        with conn:
            with conn.cursor() as cur:
                print("Running import_data.sql COPY ...")
                with open(SQL_DIR / "import_data.sql", "r", encoding="utf-8") as f_sql:
                    copy_command = f_sql.read()

                with open(CSV_FILE, "r", encoding="utf-8") as f_csv:
                    cur.copy_expert(copy_command, f_csv)

        with conn:
            with conn.cursor() as cur:
                print("Running transform_raw_to_core.sql ...")
                run_sql_file(cur, SQL_DIR / "transform_raw_to_core.sql")

        with conn:
            with conn.cursor() as cur:
                print("Running test_database.sql ...")
                with open(SQL_DIR / "test_database.sql", "r", encoding="utf-8") as f:
                    commands = [
                        cmd.strip()
                        for cmd in f.read().split(";")
                        if cmd.strip()
                    ]

                for i, command in enumerate(commands, start=1):
                    cur.execute(command)
                    rows = cur.fetchall()
                    print(f"\nQuery #{i}:")
                    pprint(rows)

        print("\nDatabase build completed successfully.")

    finally:
        conn.close()


if __name__ == "__main__":
    main()
