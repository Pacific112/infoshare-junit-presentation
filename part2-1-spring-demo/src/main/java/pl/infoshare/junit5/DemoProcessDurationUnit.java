package pl.infoshare.junit5;

import java.time.Duration;
import java.util.function.Function;

public enum DemoProcessDurationUnit {
    SECONDS(Duration::getSeconds),
    MINUTES(Duration::toMinutes),
    HOURS(Duration::toHours);

    private final Function<Duration, Long> converter;

    DemoProcessDurationUnit(Function<Duration, Long> converter) {
        this.converter = converter;
    }

    public Long convert(Duration duration) {
        return converter.apply(duration);
    }
}
