package pl.infoshare.junit5._3_parametrized;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class ArgumentsProviderExampleTest {

    @ParameterizedTest
    @ArgumentsSource(ArgumentsProviderExample.class)
    void name(String name, int age, boolean isOld) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(isOld);
    }
}
