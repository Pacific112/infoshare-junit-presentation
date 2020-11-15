package pl.infoshare.junit5._2_mockito._2_anonymizer;

import pl.infoshare.junit5._2_mockito.Person;

import java.util.Random;
import java.util.stream.Collectors;

public class PersonAnonymizer {

    private static final Random RANDOM = new Random();

    private final PersonHashService personHashService;

    public PersonAnonymizer(PersonHashService personHashService) {
        this.personHashService = personHashService;
    }

    String anonymizePerson(Person person) {
        var personCopy = new Person(person.getName(), person.getAge());
        return personHashService.hashPerson(personCopy);
    }

    String anonymizeName(Person person) {
        var salt = RANDOM.nextInt();

        var hashedName = personHashService.hashName(person.getName(), salt);
        var randomizedHash = randomizeCharacters(hashedName) + "[randomized]";

        return personHashService.hashName(randomizedHash, salt);
    }

    private String randomizeCharacters(String name) {
        return name.chars()
                .map(i -> i+ RANDOM.nextInt(5))
                .mapToObj(i -> (char) i)
                .map(c -> c + "")
                .collect(Collectors.joining());
    }
}
