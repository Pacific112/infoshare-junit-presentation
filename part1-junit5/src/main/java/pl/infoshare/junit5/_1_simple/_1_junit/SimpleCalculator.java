package pl.infoshare.junit5._1_simple._1_junit;

import java.util.stream.IntStream;

public class SimpleCalculator {

    public boolean isEven(int x) {
        return x % 2 == 0;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public double divide(int x, int y) {
        if (y == 0) {
            throw new DivisionByZeroException();
        }

        return x / y;
    }

    public int complexOperation(int x, int y) {
        return IntStream.range(x, x * y)
                .peek(n -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .sum();
    }
}
