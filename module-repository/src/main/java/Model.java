import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model implements Connecting {
    private static Model instance;
    private static List<News> dataSource;
    private Model() {
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
            dataSource = Model.readFromFile();
        }
        return instance;
    }

    public static List<News> readFromFile() {
        List<News> news = new ArrayList<>();


        try (InputStreamReader inputStream = new InputStreamReader(Objects.requireNonNull(Model.class.getClassLoader().getResourceAsStream("content.txt")));
             BufferedReader bufferedReader = new BufferedReader(inputStream);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] newsParameters = line.split("%%");
                News newsEvent = new News(Long.parseLong(newsParameters[0]),
                        newsParameters[1], newsParameters[2],
                        LocalDateTime.parse(newsParameters[3]),
                        LocalDateTime.parse(newsParameters[4]),
                        Long.parseLong(newsParameters[5]));
                news.add(newsEvent);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e.getMessage());
        }
        return news;
    }

    @Override
    public News readFromDataBase(Long id) {
        return dataSource.stream()
                .filter(news -> news.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No data found"));
    }

    @Override
    public List<News> readAllNews() {
        return dataSource;
    }


    @Override
    public boolean delete(Long id) {
        News deletedElement = readFromDataBase(id);
        return dataSource.remove(deletedElement);
    }

    @Override
    public void saveToDataBase(News news) {
        dataSource.add(news);
    }

    @Override
    public  List<News> getDataSource() {
        return dataSource;
    }

}
