package pl.infoshare.junit5._1_simple._2_assertj;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberGenerator {

    public GeneratedNumber getNext(int n) {
        if (n < 0) {
            throw new NumberBelowZeroException(n);
        }
        return new GeneratedNumber(n + 1);
    }

    public Optional<GeneratedNumber> getPrevious(int n) {
        if (n == 0) {
            return Optional.empty();
        }

        return Optional.of(new GeneratedNumber(n - 1));
    }

    public List<GeneratedNumber> getNextNumbers(int n, int count) {
        return IntStream.range(n, n + count)
                .mapToObj(GeneratedNumber::new)
                .collect(Collectors.toList());
    }
}
