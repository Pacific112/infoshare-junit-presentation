package pl.infoshare.junit5._3_data_provision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.infoshare.junit5._1_test_containers_demo.DatabaseIT;
import pl.infoshare.junit5._4_object_mother.template.DataManager;
import pl.infoshare.junit5._4_object_mother.template.DataTemplateFactory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerSqlTest extends DatabaseIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DataManager dataManager;

    @BeforeEach
    void setUp() {
        dataManager.clearAll();
    }

    @Test
    @Sql("classpath:doctors-and-patients.sql")
    void should_generate_proper_report() throws Exception {
        // when
        mockMvc.perform(get("/doctors/{id}/patients", 1))
                .andDo(print());
    }
}
