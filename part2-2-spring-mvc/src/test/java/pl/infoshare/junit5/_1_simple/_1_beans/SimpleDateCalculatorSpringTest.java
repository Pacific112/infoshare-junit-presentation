package pl.infoshare.junit5._1_simple._1_beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SimpleDateCalculatorSpringTest {

    @Autowired
    private SimpleDateCalculator testObj;

    @Test
    void should_calculate_date() {
        // given
        var givenDate = LocalDate.of(1992, Month.APRIL, 15);
        var expectedDate = LocalDate.of(1992, Month.APRIL, 25);

        // when
        var result = testObj.calculateDate(givenDate);

        // then
        assertThat(result).isEqualTo(expectedDate);
    }
}
