import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.DataSource;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;
import com.mjc.school.service.implementation.NewsService;
import com.mjc.school.service.interfaces.NewsMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceTest {
    static DataSource dataSource = DataSource.getInstance();
    static List<NewsModel> actual;
    static NewsService controller;
    NewsDto newsDTO = new NewsDto(5L, "Title", "Content", 2);

    @BeforeAll
    public static void startDataBase() {
        actual = dataSource.getAllNews();
        controller = new NewsService();
    }

    @Test
    void testGetAllNews() {
        List<NewsDto> newsDtos = controller.readAll();
        List<NewsModel> expected = new ArrayList<>();
        for (NewsDto element : newsDtos) {
            NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(element);
            expected.add(newsModel);
        }
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    void createNews() throws NewsValidationException {
        int dataBaseSizeBeforeSave = actual.size();
        controller.create(newsDTO);
        int dataBaseSizeAfterSave = actual.size();
        Assertions.assertEquals(1, (dataBaseSizeAfterSave - dataBaseSizeBeforeSave));
    }


    @Test
    void getNewsById() {
        long id = 1;
        NewsDto newsDTO = controller.readBy(id);
        Assertions.assertEquals("Orcas in Russia", newsDTO.getTitle());
    }

    @Test
    void update() throws NewsValidationException {
        long id = 5;
        controller.update(newsDTO);
        NewsModel newsModelUpdated = actual.get((int) (id - 1));
        Assertions.assertEquals(newsDTO.getTitle(), newsModelUpdated.getTitle());
    }

}