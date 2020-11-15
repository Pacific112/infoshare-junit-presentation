package pl.infoshare.junit5._1_test_containers_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerContainerDatabaseTest extends DatabaseIT {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_generate_proper_report() throws Exception {
        // given
        var firstDoctor = createDoctor("First");
        var givenPatient = createPatient("P", 28, null);

        // when
        mockMvc.perform(get("/doctors/{id}/patients", firstDoctor.getId())
        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(givenPatient)))
                .andDo(print())
                .andExpect(status().isOk());

        assertThat(patientRepository.findAll()).hasSize(1);
    }

    private Doctor createDoctor(String name) {
        var doctor = new Doctor();
        doctor.setName(name);

        return doctorRepository.save(doctor);
    }

    private Patient createPatient(String name, int age, Doctor doctor) {
        var patient = new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setDoctor(doctor);

        return patientRepository.save(patient);
    }

}
