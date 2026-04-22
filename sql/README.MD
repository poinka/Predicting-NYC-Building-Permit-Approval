This folder contains the SQL and HiveQL logic behind the project.

The files are grouped by stage.

For PostgreSQL and initial loading:

- `create_tables.sql`
- `import_data.sql`
- `transform_raw_to_core.sql`
- `test_database.sql`

For Hive storage and optimization:

- `db.hql`
- `optimization.hql`
- `cleanup.hql`

For EDA:

- `q1.hql ... q9.hql`

For dashboard preparation:

- `dashboard.hql`

`scripts/` defines execution order. `sql/` defines the table and query logic.
