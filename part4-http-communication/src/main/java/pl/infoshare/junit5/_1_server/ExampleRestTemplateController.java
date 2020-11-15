package pl.infoshare.junit5._1_server;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestTemplateController {

    private final ExampleRestTemplateService exampleRestTemplateService;

    public ExampleRestTemplateController(ExampleRestTemplateService exampleRestTemplateService) {
        this.exampleRestTemplateService = exampleRestTemplateService;
    }

    @PostMapping("/helpers/{id}")
    public String createModel(@PathVariable Integer id) {
        return exampleRestTemplateService.createIfNotInList(id);
    }
}
