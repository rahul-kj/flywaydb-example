Flyway Example
--------------

In this example, we wire Spring Boot with [FlywayDB](https://flywaydb.org/)

FlywayDB allows us to make DB migrations easier. To use this project, you need to have Java and Maven.

Additionally, you need to have a Database that you want to interact with, and provide the maven dependency in the `pom.xml`

To execute this program, you need to set the environment variables - `database.url` - JDBC url for the database - `database.username` - Database username - `database.password` - Database password - `database.file.locations` - classpath:[path] or filesystem:[path] - `cron.interval` - cron interval time

You need to create a table called `schema_version` with the following fields

| Field          | Type          | Null | Key | Default           | Extra |
|----------------|---------------|------|-----|-------------------|-------|
| installed_rank | int(11)       | NO   | PRI | NULL              |       |
| version        | varchar(50)   | YES  |     | NULL              |       |
| description    | varchar(200)  | NO   |     | NULL              |       |
| type           | varchar(20)   | NO   |     | NULL              |       |
| script         | varchar(1000) | NO   |     | NULL              |       |
| checksum       | int(11)       | YES  |     | NULL              |       |
| installed_by   | varchar(100)  | NO   |     | NULL              |       |
| installed_on   | timestamp     | NO   |     | CURRENT_TIMESTAMP |       |
| execution_time | int(11)       | NO   |     | NULL              |       |
| success        | tinyint(1)    | NO   | MUL | NULL              |       |
