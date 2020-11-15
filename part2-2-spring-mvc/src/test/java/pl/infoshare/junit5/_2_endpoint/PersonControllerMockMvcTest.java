package pl.infoshare.junit5._2_endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5._2_endpoint.person.Person;
import pl.infoshare.junit5._2_endpoint.person.PersonInMemoryRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerMockMvcTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PersonInMemoryRepository personInMemoryRepository;

    @BeforeEach
    void setUp() {
        personInMemoryRepository.deleteAll();
    }

    @Test
    void should_create_person_mock_mvc_way() throws Exception {
        //given
        var person = new Person(null, "Maciek");

        // when
        mockMvc.perform(
                post("/people")
                        .content(objectMapper.writeValueAsBytes(person))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(equalTo(1)))
                .andExpect(jsonPath("name").value(equalTo("Maciek")));

        var result = personInMemoryRepository.findAll();
        assertThat(result).hasOnlyOneElementSatisfying(r -> {
            assertThat(r.getId()).isEqualTo(1);
            assertThat(r.getName()).isEqualTo("Maciek");
        });
    }

    @Test
    void should_save_person() throws Exception {
        // given
        var givenPerson = new Person(1, "Some name");
        personInMemoryRepository.save(givenPerson);

        // when
        mockMvc.perform(get("/people/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(equalTo(1)))
                .andExpect(jsonPath("name").value(equalTo("Some name")));
    }
}