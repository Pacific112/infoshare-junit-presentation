package pl.infoshare.junit5._4_advanced._2_tags;

import org.junit.jupiter.api.Test;

public class TaggedSmokeTest {

    @Test
    @SmokeTest
    void smokeTest() {
        System.out.println("smoke");
    }

    @Test
    void notSmokeTest() {
        System.out.println("not smoke");
    }
}
