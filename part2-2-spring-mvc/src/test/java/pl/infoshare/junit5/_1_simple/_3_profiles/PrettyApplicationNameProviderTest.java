package pl.infoshare.junit5._1_simple._3_profiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("pretty-name")
class PrettyApplicationNameProviderTest {

    @Autowired
    private ApplicationNameProvider testObj;

    @Test
    void should_use_correct_application_name_provider() {
        // when
        var result = testObj.getName();

        // then
        assertThat(result).isEqualTo("♡ Currenda JUnit ♡");
    }
}