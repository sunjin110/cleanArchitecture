package info.sunjin.cleanArchitecture.presenteter.restapi;

import info.sunjin.cleanArchitecture.domain.model.ArticleModel;
import info.sunjin.cleanArchitecture.domain.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ArticleRestApiTest {

    @Mock
    private ArticleRepository articleRepo;

    @InjectMocks
    private ArticleRestApi api;

    @Test
    public void testGetArticle() {
        when(articleRepo.getById("article_id")).thenReturn(new ArticleModel("article_id", "title", "body", LocalDateTime.of(2024, Month.APRIL, 9, 12, 0, 0)));

        var response = api.getArticle("article_id");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("title", Objects.requireNonNull(response.getBody()).title());

        verify(articleRepo).getById("article_id");
    }

}
