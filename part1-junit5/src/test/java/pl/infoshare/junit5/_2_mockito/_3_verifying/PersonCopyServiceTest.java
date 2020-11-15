package pl.infoshare.junit5._2_mockito._3_verifying;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.infoshare.junit5._2_mockito.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonCopyServiceTest {

//    @InjectMocks
//    private PersonCopyService testObj;
//    @Mock
//    private PersonRepository personRepository;
//    @Mock
//    private PersonEventSender personEventSender;
//    @Captor
//    private ArgumentCaptor<Person> personCaptor;
//
//    @Test
//    void should_copy_person() {
//        // given
//        var givenPerson = new Person("Maciek", 28);
//
//        // when
//        testObj.copyPerson(givenPerson);
//
//        // then
//        verify(personRepository, atMostOnce()).save(isA(Person.class));
//        verify(personEventSender, times(2)).sendEvent(isA(Person.class), PersonOperation.UPDATE);
//        verify(personEventSender, atLeastOnce()).sendEvent(isA(Person.class), PersonOperation.UPDATE);
//        verify(personEventSender).sendEvent(isA(Person.class), PersonOperation.SAVE);
//    }
//
//    @Test
//    void should_copy_person_in_order() {
//        // given
//        var givenPerson = new Person("Maciek", 28);
//
//        // when
//        testObj.copyPerson(givenPerson);
//
//        // then
//        var inOrder = inOrder(personEventSender, personRepository);
//
//        inOrder.verify(personEventSender).sendEvent(isA(Person.class), PersonOperation.UPDATE);
//        inOrder.verify(personRepository).save(isA(Person.class));
//        inOrder.verify(personEventSender).sendEvent(isA(Person.class), PersonOperation.UPDATE);
//        inOrder.verify(personEventSender).sendEvent(isA(Person.class), PersonOperation.SAVE);
//    }
//
//    @Test
//    void capture_argument() {
//        // given
//        var givenPerson = new Person("Maciek", 28);
//
//        // when
//        testObj.copyPerson(givenPerson);
//
//        // then
//        verify(personRepository).save(personCaptor.capture());
//
//        var result = personCaptor.getValue();
//        assertThat(result.getName()).isEqualTo("Older Maciek");
//        assertThat(result.getAge()).isEqualTo(68);
//    }
}