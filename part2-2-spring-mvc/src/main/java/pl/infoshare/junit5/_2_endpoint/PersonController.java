package pl.infoshare.junit5._2_endpoint;

import org.springframework.web.bind.annotation.*;
import pl.infoshare.junit5._2_endpoint.person.Person;

import javax.validation.Valid;

@RestController
public class PersonController {

    private final PersonFindService personFindService;
    private final PersonCreateService personCreateService;

    public PersonController(PersonFindService personFindService, PersonCreateService personCreateService) {
        this.personFindService = personFindService;
        this.personCreateService = personCreateService;
    }

    @GetMapping("/people/{id}")
    public Person getPersonDetails(@PathVariable Integer id) {
        return personFindService.findById(id);
    }

    @PostMapping("/people")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personCreateService.create(person);
    }
}
