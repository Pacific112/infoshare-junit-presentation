package pl.infoshare.junit5._3_slices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5._2_endpoint.PersonController;
import pl.infoshare.junit5._2_endpoint.PersonCreateService;
import pl.infoshare.junit5._2_endpoint.PersonFindService;
import pl.infoshare.junit5._2_endpoint.person.Person;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
public class PersonControllerSliceTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonCreateService personCreateService;
    @MockBean
    private PersonFindService personFindService;

    @Test
    void should_create_person() throws Exception {
        //given
        var givenPerson = new Person(null, "Maciek");
        var expectedPerson = new Person(1, "Maciek");

        when(personCreateService.create(givenPerson)).thenReturn(expectedPerson);

        // when
        mockMvc.perform(
                post("/people")
                        .content(objectMapper.writeValueAsBytes(givenPerson))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(equalTo(1)))
                .andExpect(jsonPath("name").value(equalTo("Maciek")));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\n", "\t"})
    void shouldValidateCreatingPerson(String givenName) throws Exception {
        // given
        var givenPerson = new Person(null, givenName);

        // when
        mockMvc.perform(
                post("/people")
                        .content(objectMapper.writeValueAsBytes(givenPerson))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isBadRequest());

        // then
        verify(personCreateService, never()).create(isA(Person.class));
    }
}
