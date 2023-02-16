package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.NewsModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSource {
    private static DataSource instance;
    private static List<NewsModel> dataSource;
    private DataSource() {
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
            dataSource = DataSource.readFromFile();
        }
        return instance;
    }

    public static List<NewsModel> readFromFile() {
        List<NewsModel> newsModels = new ArrayList<>();


        try (InputStreamReader inputStream = new InputStreamReader(Objects.requireNonNull(DataSource.class.getClassLoader().getResourceAsStream("content.txt")));
             BufferedReader bufferedReader = new BufferedReader(inputStream);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] newsParameters = line.split("%%");
                NewsModel newsModelEvent = new NewsModel(Long.parseLong(newsParameters[0]),
                        newsParameters[1], newsParameters[2],
                        LocalDateTime.parse(newsParameters[3]),
                        LocalDateTime.parse(newsParameters[4]),
                        Long.parseLong(newsParameters[5]));
                newsModels.add(newsModelEvent);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e.getMessage());
        }
        return newsModels;
    }

    public List<NewsModel> readAllNews() {
        return dataSource;
    }


    public Boolean removeNews(NewsModel newsModel) {
        return dataSource.remove(newsModel);
    }

    public NewsModel addNews(NewsModel newsModel) {
        dataSource.add(newsModel);
        return newsModel;
    }

    public static List<NewsModel> getDataSource() {
        return dataSource;
    }

}
