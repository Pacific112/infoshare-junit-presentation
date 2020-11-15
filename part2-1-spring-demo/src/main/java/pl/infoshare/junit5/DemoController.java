package pl.infoshare.junit5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/api/processes/{id}/duration")
    public DemoProcessDurationResponse getDurationTimeOfProcess(@PathVariable("id") Integer processId) {
        return demoService.fetchDurationById(processId);
    }
}
