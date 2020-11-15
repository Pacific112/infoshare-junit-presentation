package pl.infoshare.junit5._4_object_mother.template;

import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.Patient;

public class PatientBuilder {

    private final Patient patient;

    public PatientBuilder() {
        patient = new Patient();
    }

    public PatientBuilder withId(Integer id) {
        patient.setId(id);
        return this;
    }

    public PatientBuilder withName(String name) {
        patient.setName(name);
        return this;
    }

    public PatientBuilder withAge(Integer age) {
        patient.setAge(age);
        return this;
    }

    public PatientBuilder withDoctor(Doctor doctor) {
        patient.setDoctor(doctor);
        return this;
    }

    public Patient build() {
        return patient;
    }
}
