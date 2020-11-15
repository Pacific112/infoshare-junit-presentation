package pl.infoshare.junit5._3_parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeCheckServiceTest {

    private final PalindromeCheckService testObj = new PalindromeCheckService();

    @ParameterizedTest
    @ValueSource(strings = {"ala", "kajak"})
    @EmptySource
    void should_return_true_when_string_is_empty_or_is_palindrome(String givenWord) {
        // when
        var result = testObj.check(givenWord);

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"maciek", "koziara"})
    @NullSource
    void should_return_false_when_string_is_null_or_not_palindrome(String givenWord) {
        // when
        var result = testObj.check(givenWord);

        // then
        assertThat(result).isFalse();
    }
}