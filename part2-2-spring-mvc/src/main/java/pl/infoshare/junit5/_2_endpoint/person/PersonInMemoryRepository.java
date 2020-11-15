package pl.infoshare.junit5._2_endpoint.person;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonInMemoryRepository {

    private final List<Person> people = new ArrayList<>();

    public void save(Person person) {
        people.add(person);
    }

    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    public Optional<Person> findById(Integer id) {
        return people.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteAll() {
        people.clear();
    }
}
