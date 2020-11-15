package pl.infoshare.junit5._2_endpoint;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._2_endpoint.person.EntityNotFoundException;
import pl.infoshare.junit5._2_endpoint.person.Person;
import pl.infoshare.junit5._2_endpoint.person.PersonInMemoryRepository;

@Component
public class PersonFindService {

    private final PersonInMemoryRepository personInMemoryRepository;

    public PersonFindService(PersonInMemoryRepository personInMemoryRepository) {
        this.personInMemoryRepository = personInMemoryRepository;
    }

    public Person findById(Integer id) {
        return personInMemoryRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

}
