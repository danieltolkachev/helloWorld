package de.htw.webtech.hello.webtech;
import de.htw.webtech.hello.webtech.persistence.TaskRepository;
import de.htw.webtech.hello.webtech.service.TaskService;
import de.htw.webtech.hello.webtech.service.TaskTransformer;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;



public class ServiceTest implements WithAssertions {

    @Mock private TaskRepository repo;
    @InjectMocks
    private TaskService test;

    long id = 111;

    @Test
    @DisplayName("should return true if deleted successfully")
    void deleteTest() {

        // given
        doReturn(true).when(repo).existsById(id);

        // when
        boolean result = test.deleteById(id);

        // then
        verify(repo).deleteById(id);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("false if deletion-marked object does not exist")
    void noExistDeleteTest() {
        // given
        doReturn(false).when(repo).existsById(id);

        // when
        boolean result = test.deleteById(id);

        // then
        verifyNoMoreInteractions(repo);
        assertThat(result).isFalse();
    }
}
