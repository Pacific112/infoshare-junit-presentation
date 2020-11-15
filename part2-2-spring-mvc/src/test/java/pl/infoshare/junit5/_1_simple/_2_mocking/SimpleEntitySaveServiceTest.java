package pl.infoshare.junit5._1_simple._2_mocking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class SimpleEntitySaveServiceTest {

    @Autowired
    private SimpleEntitySaveService simpleEntitySaveService;
    @MockBean
    private SimpleEntityRepository simpleEntityRepository;

    @Test
    void should_save_entity() {
        // given
        var givenEntity = new SimpleEntity();
        givenEntity.setId(12);
        givenEntity.setName("Name");

        when(simpleEntityRepository.existsByName("Name")).thenReturn(false);

        // when
        simpleEntitySaveService.save(givenEntity);

        // then
        verify(simpleEntityRepository).save(givenEntity);
    }

    @Test
    void other_test() {
        // given

        // when

        // then
    }
}