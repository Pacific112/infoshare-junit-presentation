package pl.infoshare.junit5.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void should_generate_report_entries() {
        // given
        var firstDoctor = createDoctor("Doctor 1");
        createDoctor("Doctor 2");

        createPatient("Patient 1", 2, firstDoctor);

        // when
        var reportEntries = doctorRepository.generateReportEntries();

        // then
        assertThat(reportEntries).hasSize(1);
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