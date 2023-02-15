import java.util.List;

public interface Connecting {
    News readFromDataBase(Long id);
    List<News> readAllNews();
    boolean delete(Long id);
    void saveToDataBase(News news);

    List<News> getDataSource();

}
