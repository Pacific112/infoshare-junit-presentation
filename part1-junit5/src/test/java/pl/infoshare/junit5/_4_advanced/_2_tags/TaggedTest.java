package pl.infoshare.junit5._4_advanced._2_tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggedTest {

    @Test
    @Tag("simple-tag")
    void tagged() {
        System.out.println("I am tagged test");
    }

    @Test
    void notTagged() {
        System.out.println("I am not tagged test");
    }
}
