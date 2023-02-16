package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSource {
    private static DataSource instance;
    private static List<News> dataSource;
    private DataSource() {
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
            dataSource = DataSource.readFromFile();
        }
        return instance;
    }

    public static List<News> readFromFile() {
        List<News> news = new ArrayList<>();


        try (InputStreamReader inputStream = new InputStreamReader(Objects.requireNonNull(DataSource.class.getClassLoader().getResourceAsStream("content.txt")));
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

    public List<News> readAllNews() {
        return dataSource;
    }


    public Boolean removeNews(News news) {
        return dataSource.remove(news);
    }

    public News addNews(News news) {
        dataSource.add(news);
        return news;
    }

    public static List<News> getDataSource() {
        return dataSource;
    }

}
