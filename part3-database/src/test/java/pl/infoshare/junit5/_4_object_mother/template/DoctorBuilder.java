package pl.infoshare.junit5._4_object_mother.template;

import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.Patient;

import java.util.ArrayList;

public class DoctorBuilder {

    private final Doctor doctor;

    public DoctorBuilder() {
        doctor = new Doctor();
        doctor.setPatients(new ArrayList<>());
    }

    public DoctorBuilder withId(Integer id) {
        doctor.setId(id);
        return this;
    }

    public DoctorBuilder withName(String name) {
        doctor.setName(name);
        return this;
    }

    public DoctorBuilder withPatient(Patient patient) {
        doctor.getPatients().add(patient);
        return this;
    }

    public Doctor build() {
        return doctor;
    }
}
