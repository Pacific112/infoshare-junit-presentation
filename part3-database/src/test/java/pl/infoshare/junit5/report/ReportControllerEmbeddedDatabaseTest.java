package pl.infoshare.junit5.report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureEmbeddedDatabase
public class ReportControllerEmbeddedDatabaseTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void should_generate_proper_report() throws Exception {
        // given
        var firstDoctor = createDoctor("First");
        var secondDoctor = createDoctor("Second");

        createPatient("Patient 1", 11, firstDoctor);
        createPatient("Patient 2", 12, secondDoctor);
        createPatient("Patient 3", 13, firstDoctor);
        createPatient("Patient 4", 14, secondDoctor);
        createPatient("Patient 5", 15, firstDoctor);

        // when
        mockMvc.perform(get("/reports/doctor"))
                .andDo(print())
                .andExpect(jsonPath("entries", hasSize(2)))
                .andExpect(jsonPath("entries[0].id", equalTo(1)))
                .andExpect(jsonPath("entries[0].name", equalTo("First")))
                .andExpect(jsonPath("entries[0].patientCount", equalTo(3)))
                .andExpect(jsonPath("entries[1].id", equalTo(2)))
                .andExpect(jsonPath("entries[1].name", equalTo("Second")))
                .andExpect(jsonPath("entries[1].patientCount", equalTo(2)));
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
