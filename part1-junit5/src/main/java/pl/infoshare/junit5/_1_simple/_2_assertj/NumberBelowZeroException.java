package pl.infoshare.junit5._1_simple._2_assertj;

public class NumberBelowZeroException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Number %s is below zero";

    private final Integer incorrectNumber;

    public NumberBelowZeroException(Integer incorrectNumber) {
        super(String.format(ERROR_MESSAGE, incorrectNumber));
        this.incorrectNumber = incorrectNumber;
    }

    public Integer getIncorrectNumber() {
        return incorrectNumber;
    }
}
