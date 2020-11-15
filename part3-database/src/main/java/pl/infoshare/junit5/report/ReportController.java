package pl.infoshare.junit5.report;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.junit5.domain.report.DoctorReport;

@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reports/doctor")
    public DoctorReport generateReport() {
        return reportService.generateReport();
    }
}
