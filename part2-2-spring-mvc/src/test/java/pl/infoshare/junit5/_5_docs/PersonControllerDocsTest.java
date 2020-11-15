package pl.infoshare.junit5._5_docs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5._2_endpoint.PersonController;
import pl.infoshare.junit5._2_endpoint.PersonCreateService;
import pl.infoshare.junit5._2_endpoint.PersonFindService;
import pl.infoshare.junit5._2_endpoint.person.EntityNotFoundException;
import pl.infoshare.junit5._2_endpoint.person.Person;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonController.class)
@AutoConfigureRestDocs
public class PersonControllerDocsTest {

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
        var constraintDescriptions = new ConstraintDescriptions(Person.class);

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
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id").value(equalTo(1)))
                .andExpect(jsonPath("otherName").value(equalTo("Maciek")))
                .andDo(document(
                        "create-person",
                        requestFields(
                                fieldWithPath("id").description("Should be null"),
                                fieldWithPath("name")
                                        .description("Name of the person we want to create. Constraints: " + constraintDescriptions.descriptionsForProperty("name"))
                        ),
                        responseFields(
                                fieldWithPath("id").description("ID of created person"),
                                fieldWithPath("name").description("Name of created person")
                        )
                ));
    }

    @Test
    void should_fetch_person() throws Exception {
        //given
        var givenId = 1;
        var expectedPerson = new Person(givenId, "Maciek");
        when(personFindService.findById(givenId)).thenReturn(expectedPerson);

        // when
        mockMvc.perform(get("/people/{id}", givenId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id").value(equalTo(givenId)))
                .andExpect(jsonPath("name").value(equalTo("Maciek")))
                .andDo(document(
                        "fetch-person",
                        pathParameters(
                                parameterWithName("id").description("ID of the existing person")
                        ),
                        responseFields(
                                fieldWithPath("id").description("ID of created person"),
                                fieldWithPath("name").description("Name of created person")
                        )
                ));
    }

    @Test
    void should_return_not_found() throws Exception {
        //given
        var givenId = 1;
        when(personFindService.findById(givenId)).thenThrow(new EntityNotFoundException());

        // when
        mockMvc.perform(get("/people/{id}", givenId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andDo(document(
                        "fetch-person-not-found",
                        pathParameters(parameterWithName("id").description("ID of the existing person"))
                ));
    }
}
