package pl.infoshare.junit5._2_mockito._2_anonymizer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.infoshare.junit5._2_mockito.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonAnonymizerTest {

    @InjectMocks
    private PersonAnonymizer testObj;
    @Mock
    private PersonHashService personHashService;

    @Test
    void should_hash_name() {
        // given
        var givenPerson = new Person("Maciek", 28);
        when(personHashService.hashName(eq("Maciek"), anyInt())).thenReturn("Hashed Maciek");
        when(personHashService.hashName(endsWith("[randomized]"), anyInt())).thenReturn("Result Hashed Maciek");

        // when
        var result = testObj.anonymizeName(givenPerson);

        // then
        assertThat(result).isEqualTo("Result Hashed Maciek");
    }

    @Test
    void should_hash_person() {
        // given
        var givenPerson = new Person("Maciek", 28);
        when(personHashService.hashPerson(argThat(arg -> arg.getName().equals("Maciek")))).thenReturn("hashed person");

        // when
        var result = testObj.anonymizePerson(givenPerson);

        // then
        assertThat(result).isEqualTo("hashed person");
    }

    @Test
    void config_example() {
//        when(personHashService.hashName("1", 1)).thenReturn("First").thenReturn("Second");
        when(personHashService.hashName("1", 1)).thenReturn("First");
        when(personHashService.hashName("1", 1)).thenReturn("Second");

        System.out.println(personHashService.hashName("1", 1));
        System.out.println(personHashService.hashName("1", 1));
        System.out.println(personHashService.hashName("1", 1));
    }
}