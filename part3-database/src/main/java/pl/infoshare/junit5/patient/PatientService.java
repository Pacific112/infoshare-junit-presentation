package pl.infoshare.junit5.patient;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

@Component
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    Patient findPatient(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(PatientNotFoundException::new);
    }

    Doctor findPatientDoctor(Integer id) {
        return patientRepository.findById(id)
                .map(Patient::getDoctor)
                .orElseThrow(PatientNotFoundException::new);
    }
}
