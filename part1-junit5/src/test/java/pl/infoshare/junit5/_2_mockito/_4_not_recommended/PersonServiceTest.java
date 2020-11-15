package pl.infoshare.junit5._2_mockito._4_not_recommended;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.infoshare.junit5._2_mockito.Person;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService testObj;
    @Spy
    private PersonRepositoryImpl personRepository;

    @Test
    void spy_example() {
        // given
        var existingPerson = new Person("Existing", 25);
        personRepository.save(existingPerson);

        when(personRepository.findByName("Existing")).thenReturn(Optional.empty());

        // when
        var result = testObj.savePerson(existingPerson);

        // then
        assertThat(result).hasSize(2).containsExactly(existingPerson, existingPerson);
        System.out.println(personRepository.findAll());
    }

    @Test
    void lenient_mock() {
        // given
        var existingPerson = new Person("Existing", 25);
        var personRepository = Mockito.mock(PersonRepositoryImpl.class);

        var otherTestObj = new PersonService(personRepository);

        lenient().when(personRepository.save(existingPerson)).thenReturn(existingPerson);
        when(personRepository.findByName("Existing")).thenReturn(Optional.of(existingPerson));
        when(personRepository.findAll()).thenReturn(List.of(existingPerson));

        // when
        var result = otherTestObj.savePerson(existingPerson);

        // then
        assertThat(result).containsExactly(existingPerson);
    }
}