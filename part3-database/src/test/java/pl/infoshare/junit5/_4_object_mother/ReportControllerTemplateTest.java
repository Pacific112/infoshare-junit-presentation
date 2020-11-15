package pl.infoshare.junit5._4_object_mother;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.infoshare.junit5._1_test_containers_demo.DatabaseIT;
import pl.infoshare.junit5._4_object_mother.template.DataManager;
import pl.infoshare.junit5._4_object_mother.template.DataTemplateFactory;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.PatientRepository;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class ReportControllerTemplateTest extends DatabaseIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DataTemplateFactory dataTemplateFactory;
    @Autowired
    private DataManager dataManager;

    @BeforeEach
    void setUp() {
        dataManager.clearAll();
    }

    @Test
    void should_generate_proper_report() throws Exception {
        // given
        var firstDoctor = dataManager.createDoctor();
        var secondDoctor = dataManager.createDoctor("Maciek");

        dataManager.createPatient(firstDoctor);
        dataManager.createPatient(firstDoctor);
        dataManager.createPatient(secondDoctor);
        dataManager.createPatient(secondDoctor, dataTemplateFactory.createPatientTemplate().withAge(25).withName("Anastazja"));
        dataManager.createPatient(firstDoctor);

        // when
        mockMvc.perform(get("/doctors/{id}/patients", secondDoctor.getId()))
                .andDo(print());
    }
}
