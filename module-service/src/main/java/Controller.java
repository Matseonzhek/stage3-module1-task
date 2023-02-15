import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements Controlling {

    private final Viewing view;
    private final Connecting model;

    public Controller(Viewing view, Connecting model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public NewsDTO createNews(NewsDTO newsDTO, Scanner scanner) throws NewsValidationException {
        if (newsDTO == null) {
            return null;
        }
        validate(newsDTO);
        News news = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
        model.saveToDataBase(news);
        return newsDTO;
    }

    @Override
    public NewsDTO update(Long id, Scanner scanner) throws NewsValidationException {
        if (id == null) {
            return null;
        }
        News news = model.readFromDataBase(id);
        NewsDTO newsDTO = view.getNewsDTO(scanner);
        validate(newsDTO);
        news.setTitle(newsDTO.getTitle());
        news.setContent(newsDTO.getContent());
        news.setAuthorId(newsDTO.getAuthorId());
        return newsDTO;
    }

    @Override
    public NewsDTO getNewsById(Long id) {
        if (id == null) {
            return null;
        }
        return NewsMapper.INSTANCE.newsToNewsDTO(model.readFromDataBase(id));
    }

    @Override
    public boolean deleteNews(Long id) {
        if (id == null) {
            return false;
        }
        return model.delete(id);
    }

    @Override
    public List<NewsDTO> getAllNews() {
        List<News> newsList = model.readAllNews();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (News element : newsList) {
            NewsDTO newsDTO = NewsMapper.INSTANCE.newsToNewsDTO(element);
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }

    @Override
    public void validate(NewsDTO newsDTO) throws NewsValidationException {
        if (!(newsDTO.getTitle().length() >= 5 && newsDTO.getTitle().length() <= 30)) {
            throw new NewsValidationException("News was not updated, as length of the title is less of 5 or more than 30."
                    + newsDTO.getTitle() + ": " + newsDTO.getTitle().length());
        }
        if (!(newsDTO.getContent().length() >= 5 && newsDTO.getContent().length() <= 255)) {
            throw new NewsValidationException("News was not updated, as length of the content is less of 5 or more than 255 "
                    + newsDTO.getContent() + ": " + newsDTO.getContent().length());
        }
    }
}
