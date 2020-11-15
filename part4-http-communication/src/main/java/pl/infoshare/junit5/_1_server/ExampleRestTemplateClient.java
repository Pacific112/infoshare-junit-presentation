package pl.infoshare.junit5._1_server;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.infoshare.junit5.common.HelperModel;

import java.util.Arrays;
import java.util.List;

@Component
public class ExampleRestTemplateClient {

    private final RestTemplate restTemplate;

    public ExampleRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HelperModel getHelperModel(Integer id) {
        return restTemplate.getForObject(String.format("/helpers/%s", id), HelperModel.class);
    }

    public List<HelperModel> getHelperModels() {
        return Arrays.asList(restTemplate.getForObject("/helpers", HelperModel[].class));
    }

    public boolean createHelperModel(HelperModel helperModel) {
        var response = restTemplate.postForEntity("/helpers", helperModel, Void.class);
        return response.getStatusCode().equals(HttpStatus.CREATED);
    }
}
