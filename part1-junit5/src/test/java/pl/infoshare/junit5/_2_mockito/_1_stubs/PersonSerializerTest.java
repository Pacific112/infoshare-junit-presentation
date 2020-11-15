package pl.infoshare.junit5._2_mockito._1_stubs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.infoshare.junit5._2_mockito.Person;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonSerializerTest {

    @InjectMocks
    private PersonSerializer personSerializer;
    @Mock
    private PersonValidator personValidator;

    @Test
    void should_serialize_person() {
        // given
        var givenPerson = new Person("Maciek", 28);
        when(personValidator.canSerialize(givenPerson)).thenReturn(false);

        // when
        var result = personSerializer.serialize(givenPerson);

        // then
        assertThat(result).isEqualTo("Not serialized");
    }

    @Test
    void should_throw_exception_when_validation_failed() {
        // given
        var givenPerson = new Person("Maciek", 28);
        doThrow(new IllegalStateException()).when(personValidator).canSerializeWithException(givenPerson);

        // when
        var result = personSerializer.serializeWithException(givenPerson);

        // then
        assertThat(result).isEqualTo("Validation exception");
    }
}