package pl.infoshare.junit5._1_simple._1_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    private final SimpleCalculator testObj = new SimpleCalculator();

    @Test
    void should_return_true_for_number_divisible_by_two() {
        // given
        var givenNumber = 4;

        // when
        var result = testObj.isEven(givenNumber);

        // then
        assertTrue(result);
    }

    @Test
    void should_return_true_for_number_divisible_by_two_assertJ() {
        // given
        var givenNumber = 4;

        // when
        var result = testObj.isEven(givenNumber);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void should_return_false_for_number_that_cannot_be_divided_by_two() {
        // given
        var givenNumber = 3;

        // when
        var result = testObj.isEven(givenNumber);

        // then
        assertFalse(result);
    }

    @Test
    void should_return_false_for_number_that_cannot_be_divided_by_two_assertJ() {
        // given
        var givenNumber = 3;

        // when
        var result = testObj.isEven(givenNumber);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void should_add_two_numbers() {
        // given
        var firstNumber = 2;
        var secondNumber = 3;

        // when
        var result = testObj.add(firstNumber, secondNumber);

        // then
        assertEquals(result, 5);
    }

    @Test
    void should_add_two_numbers_assertJ() {
        // given
        var firstNumber = 2;
        var secondNumber = 3;

        // when
        var result = testObj.add(firstNumber, secondNumber);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void should_throw_exception_when_trying_to_divide_by_zero() {
        // given
        var givenDividend = 6;
        var givenDivider = 0;

        // when
        var result = Assertions.assertThrows(DivisionByZeroException.class, () -> testObj.divide(givenDividend, givenDivider));

        // then
        assertEquals(result.getMessage(), "Cannot divide by zero");
    }

    @Test
    void should_finish_calculation_below_500ms() {
        // given

        // when
        var result = Assertions.assertTimeout(Duration.ofMillis(500), () -> testObj.complexOperation(2, 3));

        // then
        assertEquals(result, 14);
    }
}