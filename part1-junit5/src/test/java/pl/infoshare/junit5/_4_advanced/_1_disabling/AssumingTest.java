package pl.infoshare.junit5._4_advanced._1_disabling;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AssumingTest {

    @Test
    void assume_is_running_on_ci() {
        // given
        Assumptions.assumeTrue(Objects.equals(System.getenv("CI"), "true"));

        // when
        assertThat(true).isTrue();
    }
}
