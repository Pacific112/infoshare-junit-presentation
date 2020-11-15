package pl.infoshare.junit5.domain.report;

import java.util.List;

public class DoctorReport {

    private final List<DoctorReportEntry> entries;

    public DoctorReport(List<DoctorReportEntry> entries) {
        this.entries = entries;
    }

    public List<DoctorReportEntry> getEntries() {
        return entries;
    }
}
