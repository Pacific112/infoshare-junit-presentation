package pl.infoshare.junit5._2_mockito._3_verifying;

import pl.infoshare.junit5._2_mockito.Person;

public class PersonCopyService {

    private final PersonRepository personRepository;
    private final PersonEventSender personEventSender;

    public PersonCopyService(PersonRepository personRepository, PersonEventSender personEventSender) {
        this.personRepository = personRepository;
        this.personEventSender = personEventSender;
    }

    void copyPerson(Person person) {
        Person olderPerson = makePersonOlder(person);

        personEventSender.sendEvent(olderPerson, PersonOperation.UPDATE);
        personRepository.save(olderPerson);
        personEventSender.sendEvent(olderPerson, PersonOperation.UPDATE);
        personEventSender.sendEvent(olderPerson, PersonOperation.SAVE);
    }

    private Person makePersonOlder(Person person) {
        return new Person(
                "Older " + person.getName(),
                person.getAge() + 40
        );
    }
}
