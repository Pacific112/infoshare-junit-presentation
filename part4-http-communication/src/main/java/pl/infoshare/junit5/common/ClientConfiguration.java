package pl.infoshare.junit5.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfiguration {

    @Bean
    public RestTemplate helperModelClient(RestTemplateBuilder restTemplateBuilder,
                                          @Value("${helper.project.uri}") String helperProjectUri) {
        return restTemplateBuilder.rootUri(helperProjectUri).build();
    }
}
