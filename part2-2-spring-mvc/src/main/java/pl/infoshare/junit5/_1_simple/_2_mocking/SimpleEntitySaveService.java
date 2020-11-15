package pl.infoshare.junit5._1_simple._2_mocking;

import org.springframework.stereotype.Component;

@Component
public class SimpleEntitySaveService {

    private final SimpleEntityRepository simpleEntityRepository;

    public SimpleEntitySaveService(SimpleEntityRepository simpleEntityRepository) {
        this.simpleEntityRepository = simpleEntityRepository;
    }

    public void save(SimpleEntity simpleEntity) {
        if (simpleEntityRepository.existsByName(simpleEntity.getName())) {
            throw new IllegalStateException();
        }

        simpleEntityRepository.save(simpleEntity);
    }
}
