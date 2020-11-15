package pl.infoshare.junit5._2_endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pl.infoshare.junit5._2_endpoint.person.Person;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerOldTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Test
    void should_create_person_old_way() {
        // given
        var givenPerson = new Person(null, "Maciek");
        var url = String.format("http://localhost:%s/people", port);

        // when
        var result = testRestTemplate.postForObject(url, givenPerson, Person.class);

        // then
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("Maciek");
    }
}