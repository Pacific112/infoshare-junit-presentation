package pl.infoshare.junit5._2_in_memory_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(InMemoryPatientRepository.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void should_use_in_memory_implementation() throws Exception {
        // given
        var doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("D");

        var patient = new Patient();
        patient.setId(1);
        patient.setName("P");
        patient.setAge(28);
        patient.setDoctor(doctor);
        patientRepository.save(patient);

        // when
        mockMvc.perform(get("/patients/{id}/doctor", patient.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        assertThat(patientRepository.findAll()).hasSize(1);

        // then
    }
}
