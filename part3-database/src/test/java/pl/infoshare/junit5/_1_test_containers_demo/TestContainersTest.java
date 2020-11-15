package pl.infoshare.junit5._1_test_containers_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestContainersTest extends DatabaseIT {

    @Test
    void should_initialize_postgres_from_docker() {
        // given
        assertThat(postgresql.getJdbcUrl()).isNotNull();
        assertThat(postgresql.getDatabaseName()).isNotNull();
        assertThat(postgresql.getUsername()).isNotNull();
        assertThat(postgresql.getPassword()).isNotNull();


        // when

        // then
    }
}
