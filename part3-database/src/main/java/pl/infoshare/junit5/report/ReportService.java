package pl.infoshare.junit5.report;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.report.DoctorReport;

@Component
public class ReportService {

    private final DoctorRepository doctorRepository;

    public ReportService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorReport generateReport() {
        var reportEntries = doctorRepository.generateReportEntries();
        return new DoctorReport(reportEntries);
    }
}
