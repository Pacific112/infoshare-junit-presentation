package pl.infoshare.junit5._1_server;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5.common.HelperModel;

@Component
public class ExampleRestTemplateService {

    private final ExampleRestTemplateClient exampleRestTemplateClient;

    public ExampleRestTemplateService(ExampleRestTemplateClient exampleRestTemplateClient) {
        this.exampleRestTemplateClient = exampleRestTemplateClient;
    }

    public String createIfNotInList(Integer id) {
        var allModels = exampleRestTemplateClient.getHelperModels();
        var specificModel = exampleRestTemplateClient.getHelperModel(id);

        if (allModels.contains(specificModel)) {
            return "Already there!";
        }

        var createSuccess = exampleRestTemplateClient.createHelperModel(specificModel);
        if (createSuccess) {
            return "Created!";
        }

        return "Failed!";
    }
}
