package pl.infoshare.junit5._2_mockito._1_stubs;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class DefaultValuesExampleTest {

    @Test
    void default_values_example() {
        var defaultValuesExample = mock(DefaultValuesExample.class);

        System.out.println(defaultValuesExample.getInt());
        System.out.println(defaultValuesExample.getInteger());
        System.out.println(defaultValuesExample.getBoolean());
        System.out.println(defaultValuesExample.getPrimitiveBoolean());
        System.out.println(defaultValuesExample.getString());
        System.out.println(defaultValuesExample.getListOfStrings());
        System.out.println(defaultValuesExample.getOptionalString());
        System.out.println(defaultValuesExample.getPerson());
    }
}