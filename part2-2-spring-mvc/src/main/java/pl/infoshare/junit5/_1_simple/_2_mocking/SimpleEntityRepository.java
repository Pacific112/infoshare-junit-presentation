package pl.infoshare.junit5._1_simple._2_mocking;

import org.springframework.stereotype.Component;

@Component
public class SimpleEntityRepository {

    boolean existsByName(String name) {
        return false;
    }


    public void save(SimpleEntity simpleEntity) {

    }
}
