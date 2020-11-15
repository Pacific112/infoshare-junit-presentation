package pl.infoshare.junit5.patient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.junit5.domain.Doctor;
import pl.infoshare.junit5.domain.Patient;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/{id}")
    public Patient findPatient(@PathVariable Integer id) {
        return patientService.findPatient(id);
    }

    @GetMapping("/patients/{id}/doctor")
    public Doctor findDoctor(@PathVariable Integer id) {
        return patientService.findPatientDoctor(id);
    }
}
