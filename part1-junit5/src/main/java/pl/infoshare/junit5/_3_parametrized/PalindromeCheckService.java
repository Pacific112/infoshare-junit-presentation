package pl.infoshare.junit5._3_parametrized;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class PalindromeCheckService {

    public boolean check(String word) {
        if (Objects.isNull(word)) {
            return false;
        }
        if (word.isBlank()) {
            return true;
        }

        var reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }
}
