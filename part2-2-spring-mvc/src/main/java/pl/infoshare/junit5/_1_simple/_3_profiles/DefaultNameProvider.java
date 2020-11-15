package pl.infoshare.junit5._1_simple._3_profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!pretty-name")
public class DefaultNameProvider implements ApplicationNameProvider {

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public String getName() {
        return applicationName;
    }
}
