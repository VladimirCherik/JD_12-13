package org.example;

import org.flywaydb.core.Flyway;

public class CreateDatabase {
    public static void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./spacetrain", null, null)
                .locations("classpath:db.migration")
                .load();
        flyway.migrate();
    }
}
