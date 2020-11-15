package pl.infoshare.junit5;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoProcessDurationResponse {

    private final Long processDuration;

    public DemoProcessDurationResponse(Long processDuration) {
        this.processDuration = processDuration;
    }

    @JsonProperty("duration")
    public Long getProcessDuration() {
        return processDuration;
    }
}
