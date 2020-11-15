package pl.infoshare.junit5._1_security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomUserController.class)
@Import(TestUserDetailsService.class)
class CustomUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails(userDetailsServiceBeanName = "testUserDetailsService")
    void authenticates_custom_user() throws Exception {
        mockMvc.perform(get("/users/me"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}