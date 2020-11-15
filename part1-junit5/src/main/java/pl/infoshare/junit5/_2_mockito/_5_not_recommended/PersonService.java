package pl.infoshare.junit5._2_mockito._5_not_recommended;

import pl.infoshare.junit5._2_mockito.Person;

import java.util.List;

public class PersonService {

    private final PersonRepositoryImpl personRepository;

    public PersonService(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> savePerson(Person person) {
        var foundPerson = personRepository.findByName(person.getName());
        if (foundPerson.isEmpty()) {
            personRepository.save(person);
        }

        return personRepository.findAll();
    }
}
