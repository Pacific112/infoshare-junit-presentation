package pl.infoshare.junit5._5_extensions._3_resolver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(NameExtension.class)
public class NameExtensionTest {

    @Test
    void name_extension(@TrainerName String name) {
        System.out.println(name);
    }
}
