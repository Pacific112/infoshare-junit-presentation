package pl.infoshare.junit5._1_server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import pl.infoshare.junit5.common.HelperModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.ExpectedCount.never;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ExampleRestTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private MockRestServiceServer helperProjectServer;

    @BeforeEach
    void setUp() {
        helperProjectServer = MockRestServiceServer.bindTo(restTemplate).build();
    }

    @Test
    void should_create_new_helper_model() throws Exception {
        // given
        var givenId = 2;
        var allHelperModels = List.of(
                new HelperModel(1, "Helper: 1")
        );

        var givenModel = new HelperModel(2, "Helper: 2");

        helperProjectServer
                .expect(once(), requestTo("http://localhost:8081/helpers"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsBytes(allHelperModels))
                );
        helperProjectServer
                .expect(once(), requestTo("http://localhost:8081/helpers/2"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsBytes(givenModel)));
        helperProjectServer
                .expect(once(), requestTo("http://localhost:8081/helpers"))
                .andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.CREATED));

        // when
        mockMvc.perform(post("/helpers/{id}", givenId))
                .andExpect(status().isOk())
                .andExpect(content().string("Created!"));
    }

    @Test
    void should_not_create_helper_model_when_already_exists() throws Exception {
        // given
        var givenId = 2;
        var givenModel = new HelperModel(2, "Helper: 2");
        var allHelperModels = List.of(
                new HelperModel(1, "Helper: 1"),
                givenModel
        );

        helperProjectServer
                .expect(once(), requestTo("http://localhost:8081/helpers"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsBytes(allHelperModels))
                );
        helperProjectServer
                .expect(once(), requestTo("http://localhost:8081/helpers/2"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsBytes(givenModel)));
        helperProjectServer
                .expect(never(), requestTo("http://localhost:8081/helpers"))
                .andExpect(method(HttpMethod.POST));

        // when
        mockMvc.perform(post("/helpers/{id}", givenId))
                .andExpect(status().isOk())
                .andExpect(content().string("Already there!"));
    }
}