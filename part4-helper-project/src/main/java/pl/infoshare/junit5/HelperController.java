package pl.infoshare.junit5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelperController {

    @GetMapping("/helpers/{id}")
    public HelperModel getHelper(@PathVariable Integer id) {
        return new HelperModel(id, "Helper: " + id);
    }

    @GetMapping("/helpers")
    public List<HelperModel> getAll() {
        return List.of(
                new HelperModel(1, "Helper: 1"),
                new HelperModel(2, "Helper: 2"),
                new HelperModel(3, "Helper: 3"),
                new HelperModel(4, "Helper: 4")
        );
    }

    @PostMapping("/helpers")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHelper(HelperModel helperModel) {

    }
}
