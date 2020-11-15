package pl.infoshare.junit5._2_mockito._1_stubs;

import pl.infoshare.junit5._2_mockito.Person;

import java.util.List;
import java.util.Optional;

public class DefaultValuesExample {

    public String getString() {
        return "test string";
    }

    public int getInt() {
        return 28;
    }

    public Integer getInteger() {
        return 25;
    }

    public boolean getPrimitiveBoolean() {
        return true;
    }

    public Boolean getBoolean() {
        return true;
    }

    public List<String> getListOfStrings() {
        return List.of("string in list");
    }

    public Optional<String> getOptionalString() {
        return Optional.of("test optional string");
    }

    public Person getPerson() {
        return new Person("Maciek", 28);
    }
}
