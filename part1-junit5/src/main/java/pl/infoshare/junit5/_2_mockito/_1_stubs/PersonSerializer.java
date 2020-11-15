package pl.infoshare.junit5._2_mockito._1_stubs;

import pl.infoshare.junit5._2_mockito.Person;

public class PersonSerializer {

    private PersonValidator personValidator;

    public PersonSerializer() {
        this.personValidator = new PersonValidator();
    }

    public String serializeWithException(Person person) {
        try {
            personValidator.canSerializeWithException(person);
            return "Serialized Person[name:" + person.getName() + ",age:" + person.getAge() + "]";
        } catch (IllegalStateException ex) {
            return "Validation exception";
        }
    }

    public String serialize(Person person) {
        if (personValidator.canSerialize(person)) {
            return "Serialized Person[name:" + person.getName() + ",age:" + person.getAge() + "]";
        } else {
            return "Not serialized";
        }
    }
}
