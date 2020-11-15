package pl.infoshare.junit5._4_object_mother.template;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

@Component
public class DataManager {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final DataTemplateFactory dataTemplateFactory;

    public DataManager(DoctorRepository doctorRepository, PatientRepository patientRepository, DataTemplateFactory dataTemplateFactory) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.dataTemplateFactory = dataTemplateFactory;
    }

    public void clearAll() {
        patientRepository.deleteAll();
        doctorRepository.deleteAll();
    }

    public Doctor createDoctor() {
        return doctorRepository.save(dataTemplateFactory.createDoctorTemplate().build());
    }

    public Doctor createDoctor(String name) {
        return doctorRepository.save(dataTemplateFactory.createDoctorTemplate().withName(name).build());
    }

    public Patient createPatient(Doctor doctor) {
        return createPatient(doctor, dataTemplateFactory.createPatientTemplate());
    }

    public Patient createPatient(Doctor doctor, PatientBuilder patientBuilder) {
        return patientRepository.save(patientBuilder.withDoctor(doctor).build());
    }
}
