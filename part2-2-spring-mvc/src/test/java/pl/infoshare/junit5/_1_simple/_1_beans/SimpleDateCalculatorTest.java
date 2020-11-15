package pl.infoshare.junit5._1_simple._1_beans;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleDateCalculatorTest {

    @Test
    void should_calculate_date() {
        // given
        var givenDaysToAdd = 5;
        var givenDate = LocalDate.of(2010, Month.MARCH, 3);
        var expectedDate = LocalDate.of(2010, Month.MARCH, 8);

        var testObj = new SimpleDateCalculator(givenDaysToAdd);

        // when
        var result = testObj.calculateDate(givenDate);

        // then
        assertThat(result).isEqualTo(expectedDate);
    }
}