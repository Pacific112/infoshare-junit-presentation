package pl.infoshare.junit5._1_simple._1_junit;

public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException() {
        super("Cannot divide by zero");
    }
}
