package pl.infoshare.junit5._1_simple._2_assertj;

public class NumberStatistics {

    private final Integer number;

    public NumberStatistics(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public int getSquare() {
        return number * number;
    }

    public String getTextRepresentation() {
        if (number == 1) {
            return "one";
        }
        if (number == 2) {
            return "two";
        }
        return "above three";
    }
}
