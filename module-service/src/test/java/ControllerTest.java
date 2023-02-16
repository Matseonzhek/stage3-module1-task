import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.controller.implementation.View;
import com.mjc.school.controller.interfaces.Viewing;
import com.mjc.school.repository.interfaces.Connecting;
import com.mjc.school.repository.implementation.Model;
import com.mjc.school.repository.entity.News;
import com.mjc.school.service.implementation.Controller;
import com.mjc.school.service.interfaces.Controlling;
import com.mjc.school.service.interfaces.NewsMapper;
import com.mjc.school.service.exceptions.NewsValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerTest {
    static Viewing viewing;
    static Connecting model;
    static List<News> actual;
    static Controlling controller;
    NewsDTO newsDTO = new NewsDTO("Title", "Content", 2);

    @BeforeAll
    public static void startDataBase() {
        viewing = new View();
        model = Model.getInstance();
        actual = model.getDataSource();
        controller = new Controller(viewing, model);
    }

    @Test
    void testGetAllNews() {
        List<NewsDTO> newsDTOS = controller.getAllNews();
        List<News> expected = new ArrayList<>();
        for (NewsDTO element : newsDTOS) {
            News news = NewsMapper.INSTANCE.newsDTOToNews(element);
            expected.add(news);
        }
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    void createNews() throws NewsValidationException {
        int dataBaseSizeBeforeSave = actual.size();
        controller.createNews(newsDTO, new Scanner(System.in));
        int dataBaseSizeAfterSave = actual.size();
        Assertions.assertEquals(1, (dataBaseSizeAfterSave - dataBaseSizeBeforeSave));
    }


    @Test
    void getNewsById() {
        long id = 1;
        NewsDTO newsDTO = controller.getNewsById(id);
        Assertions.assertEquals("Orcas in Russia",newsDTO.getTitle());
    }

}
