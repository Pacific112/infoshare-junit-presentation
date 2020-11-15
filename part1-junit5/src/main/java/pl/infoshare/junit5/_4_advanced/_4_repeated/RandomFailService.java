package pl.infoshare.junit5._4_advanced._4_repeated;

import java.util.Random;

public class RandomFailService {

    private final static Random RANDOM = new Random();

    public int failRandomly() {
        var random = RANDOM.nextInt(20);
        if (random == 16) {
            throw new RuntimeException("Failed");
        }

        return random;
    }

}
