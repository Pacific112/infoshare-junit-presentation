package pl.infoshare.junit5._2_mockito._2_anonymizer;

import pl.infoshare.junit5._2_mockito.Person;

public interface PersonHashService {

    String hashName(String value, int salt);

    String hashPerson(Person person);

}
