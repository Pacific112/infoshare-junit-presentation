package pl.infoshare.junit5._4_object_mother.template;

import org.springframework.stereotype.Component;
import org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

@Component
public class DataTemplateFactory {

    private static final Random RANDOM = new Random();

    public DoctorBuilder createDoctorTemplate() {
        return new DoctorBuilder()
                .withName(RandomStringUtils.randomAlphabetic(5));
    }

    public PatientBuilder createPatientTemplate() {
        return new PatientBuilder()
                .withName(RandomStringUtils.randomAlphabetic(5))
                .withAge(RANDOM.nextInt(60));
    }
}
