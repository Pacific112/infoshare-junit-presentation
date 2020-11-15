package pl.infoshare.junit5.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.infoshare.junit5.domain.report.DoctorReportEntry;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query("select d.id as id, d.name as name, count(p) as patientCount from Doctor d join Patient p on p.doctor = d group by d.id, d.name order by d.id")
    List<DoctorReportEntry> generateReportEntries();

}
