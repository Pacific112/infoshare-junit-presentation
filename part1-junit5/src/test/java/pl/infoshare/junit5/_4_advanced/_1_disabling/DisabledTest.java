package pl.infoshare.junit5._4_advanced._1_disabling;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class DisabledTest {


    @Test
    @EnabledOnOs(OS.MAC)
    void enabled_on_mac() {
        // given

        // when

        // then
        assertThat(true).isTrue();
    }
}
