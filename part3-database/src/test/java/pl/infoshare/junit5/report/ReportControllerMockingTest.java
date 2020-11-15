package pl.infoshare.junit5.report;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.infoshare.junit5.domain.DoctorRepository;
import pl.infoshare.junit5.domain.PatientRepository;
import pl.infoshare.junit5.domain.report.DoctorReportEntry;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportControllerMockingTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DoctorRepository doctorRepository;

    @Test
    void should_generate_proper_report() throws Exception {
        // given
        when(doctorRepository.generateReportEntries()).thenReturn(List.of(
                new TestDoctorReportEntry(1, "First", 3),
                new TestDoctorReportEntry(2, "Second", 2)
        ));

        // when
        mockMvc.perform(get("/reports/doctor"))
                .andDo(print())
                .andExpect(jsonPath("entries", hasSize(2)))
                .andExpect(jsonPath("entries[0].id", equalTo(1)))
                .andExpect(jsonPath("entries[0].name", equalTo("First")))
                .andExpect(jsonPath("entries[0].patientCount", equalTo(3)))
                .andExpect(jsonPath("entries[1].id", equalTo(2)))
                .andExpect(jsonPath("entries[1].name", equalTo("Second")))
                .andExpect(jsonPath("entries[1].patientCount", equalTo(2)));
    }

    class TestDoctorReportEntry implements DoctorReportEntry {

        private final Integer id;
        private final String name;
        private final Integer patientCount;

        TestDoctorReportEntry(Integer id, String name, Integer patientCount) {
            this.id = id;
            this.name = name;
            this.patientCount = patientCount;
        }

        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Integer getPatientCount() {
            return patientCount;
        }
    }
}
