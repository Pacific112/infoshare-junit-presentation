package pl.infoshare.junit5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class DemoService {

    private final DemoProcessRepository demoProcessRepository;
    private final DemoProcessDurationUnit demoProcessDurationUnit;

    public DemoService(DemoProcessRepository demoProcessRepository,
                       @Value("${process.duration.unit}") DemoProcessDurationUnit demoProcessDurationUnit) {
        this.demoProcessRepository = demoProcessRepository;
        this.demoProcessDurationUnit = demoProcessDurationUnit;
    }

    DemoProcessDurationResponse fetchDurationById(Integer id) {
        return demoProcessRepository.findById(id)
                .map(DemoProcess::getDurationInSeconds)
                .map(Duration::ofSeconds)
                .map(demoProcessDurationUnit::convert)
                .map(DemoProcessDurationResponse::new)
                .orElseThrow(RuntimeException::new);
    }
}
