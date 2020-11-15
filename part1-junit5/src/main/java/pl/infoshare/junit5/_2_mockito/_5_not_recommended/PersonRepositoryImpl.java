package pl.infoshare.junit5._2_mockito._5_not_recommended;

import pl.infoshare.junit5._2_mockito.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepositoryImpl {

    private final List<Person> persons = new ArrayList<>();

    Person save(Person person) {
        persons.add(person);
        return person;
    }

    List<Person> findAll() {
        return persons;
    }

    Optional<Person> findByName(String name) {
        return persons.stream().filter(p -> p.getName().equals(name)).findFirst();
    }
}
