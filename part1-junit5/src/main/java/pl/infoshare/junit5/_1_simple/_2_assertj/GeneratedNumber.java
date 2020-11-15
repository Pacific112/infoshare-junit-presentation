package pl.infoshare.junit5._1_simple._2_assertj;

import java.util.Objects;

public class GeneratedNumber {

    private final int value;
    private final String internalRepresentation;

    public GeneratedNumber(int value) {
        this.value = value;
        this.internalRepresentation = value % 2 == 0 ? "even" : "not even";
    }

    public int getValue() {
        return value;
    }

    public int getNegative() {
        return -value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneratedNumber that = (GeneratedNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
