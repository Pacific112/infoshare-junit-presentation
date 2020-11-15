package pl.infoshare.junit5._3_slices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.infoshare.junit5._1_simple._3_profiles.ApplicationNameProvider;

@RestController
public class AppController {

    private final ApplicationNameProvider applicationNameProvider;

    public AppController(ApplicationNameProvider applicationNameProvider) {
        this.applicationNameProvider = applicationNameProvider;
    }

    @GetMapping("/app/name")
    public String getAppName() {
        return applicationNameProvider.getName();
    }
}
