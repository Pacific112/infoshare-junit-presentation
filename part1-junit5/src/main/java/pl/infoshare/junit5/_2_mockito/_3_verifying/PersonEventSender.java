package pl.infoshare.junit5._2_mockito._3_verifying;

import pl.infoshare.junit5._2_mockito.Person;

public interface PersonEventSender {

    void sendEvent(Person person, PersonOperation operation);

}
