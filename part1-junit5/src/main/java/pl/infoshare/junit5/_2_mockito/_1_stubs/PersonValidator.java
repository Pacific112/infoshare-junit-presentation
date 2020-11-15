package pl.infoshare.junit5._2_mockito._1_stubs;

import pl.infoshare.junit5._2_mockito.Person;

public class PersonValidator {

    public void canSerializeWithException(Person person) {
        if (!canSerialize(person)) {
            throw new IllegalStateException("Person cannot be serialized");
        }

    }

    public boolean canSerialize(Person person) {

        return person.getAge() >= 18;
    }
}
