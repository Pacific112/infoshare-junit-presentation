package pl.infoshare.junit5._1_test_containers_demo;

import org.junit.jupiter.api.BeforeAll;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class DatabaseIT {

    public static PostgreSQLContainer<?> postgresql = new PostgreSQLContainer<>("postgres");

    @BeforeAll
    static void beforeAll() {
        if (!postgresql.isRunning()) {
            postgresql.start();

            System.setProperty("DB_URL", postgresql.getJdbcUrl());
            System.setProperty("DB_USERNAME", postgresql.getUsername());
            System.setProperty("DB_PASSWORD", postgresql.getPassword());
        }
    }

}
