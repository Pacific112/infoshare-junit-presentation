package pl.infoshare.junit5.doctor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.junit5.domain.Patient;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors/{id}/patients")
    public List<Patient> getPatients(@PathVariable Integer id) {
        return doctorService.findPatients(id);
    }

    @PostMapping("/doctors/{id}/patients")
    public void addPatient(@PathVariable Integer id, @RequestBody Patient patient) {
        doctorService.addPatient(id, patient);
    }
}
