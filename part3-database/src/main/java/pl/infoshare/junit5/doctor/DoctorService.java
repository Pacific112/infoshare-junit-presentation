package pl.infoshare.junit5.doctor;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.Patient;
import pl.infoshare.junit5.domain.PatientRepository;

import java.util.List;

@Component
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public DoctorService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public void addPatient(Integer doctorId, Patient patient) {
        var doctor = doctorRepository.findById(doctorId)
                .orElseThrow(DoctorNotFoundException::new);

        patient.setDoctor(doctor);
        patientRepository.save(patient);
    }

    public List<Patient> findPatients(Integer doctorId) {
        return doctorRepository.findById(doctorId)
                .map(Doctor::getPatients)
                .orElseThrow(DoctorNotFoundException::new);
    }
}
