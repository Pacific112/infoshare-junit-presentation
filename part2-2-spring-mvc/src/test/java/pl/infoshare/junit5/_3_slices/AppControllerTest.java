package pl.infoshare.junit5._3_slices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5._1_simple._3_profiles.DefaultNameProvider;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AppController.class)
@Import(DefaultNameProvider.class)
public class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_application_name() throws Exception {
        // when
        mockMvc.perform(get("/app/name"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Currenda JUnit"));
    }
}
