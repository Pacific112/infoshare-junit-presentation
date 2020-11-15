package pl.infoshare.junit5._3_parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AreaCalculatorTest {

    private final AreaCalculator testObj = new AreaCalculator();


    @ParameterizedTest
    @MethodSource("provideRectangles")
    void should_calculate_area(Rectangle givenRectangle, Integer expectedResult) {
        // when
        var result = testObj.calculate(givenRectangle);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideRectangles() {
        return Stream.of(
                Arguments.of(new Rectangle(5, 6), 30),
                Arguments.of(new Rectangle(2, 2), 4),
                Arguments.of(new Rectangle(99, 2), 198)
        );
    }
}