package pl.infoshare.junit5._6_rest_assured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import pl.infoshare.junit5._2_endpoint.person.Person;
import pl.infoshare.junit5._2_endpoint.person.PersonInMemoryRepository;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredPersonTest {

    @Autowired
    private PersonInMemoryRepository personInMemoryRepository;

    @BeforeEach
    void setUp() {
        personInMemoryRepository.deleteAll();
    }

    @Test
    void should_create_person(@LocalServerPort int port) {
        //given
        var givenPerson = new Person(null, "person name");

        // when
        given()
                .port(port)
                .body(givenPerson)
                .contentType(ContentType.JSON)
                .when()
                .post("/people")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("person name"));

        // then
        var result = personInMemoryRepository.findAll();
        assertThat(result).hasSize(1);
    }

    @Test
    void should_fetch_person(@LocalServerPort int port) {
        // given
        var givenPerson = new Person(1, "person name");
        personInMemoryRepository.save(givenPerson);

        // when
        given()
                .port(port)
                .when()
                .get("/people/{id}", 1)
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("person name"));
    }

    @Test
    void should_return_not_found(@LocalServerPort int port) {
        // when
        given()
                .port(port)
                .when()
                .get("/people/{id}", 1)
                .prettyPeek()
                .then()
                .statusCode(404);
    }
}
