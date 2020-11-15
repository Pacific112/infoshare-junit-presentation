package pl.infoshare.junit5._2_endpoint;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._2_endpoint.person.PersonInMemoryRepository;

@Component
public class PersonIdCalculator {

    private final PersonInMemoryRepository personInMemoryRepository;

    public PersonIdCalculator(PersonInMemoryRepository personInMemoryRepository) {
        this.personInMemoryRepository = personInMemoryRepository;
    }

    public int getNextId() {
        return personInMemoryRepository.findAll().size() + 1;
    }
}
