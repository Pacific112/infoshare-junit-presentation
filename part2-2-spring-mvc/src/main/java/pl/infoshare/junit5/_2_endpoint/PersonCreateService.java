package pl.infoshare.junit5._2_endpoint;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._2_endpoint.person.Person;
import pl.infoshare.junit5._2_endpoint.person.PersonInMemoryRepository;

@Component
public class PersonCreateService {

    private final PersonIdCalculator personIdCalculator;
    private final PersonInMemoryRepository personInMemoryRepository;

    public PersonCreateService(PersonIdCalculator personIdCalculator, PersonInMemoryRepository personInMemoryRepository) {
        this.personIdCalculator = personIdCalculator;
        this.personInMemoryRepository = personInMemoryRepository;
    }

    public Person create(Person person) {
        var newId = personIdCalculator.getNextId();
        var personWithId = person.withId(newId);

        personInMemoryRepository.save(personWithId);

        return personWithId;
    }
}
