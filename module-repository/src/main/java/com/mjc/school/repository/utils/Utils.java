package com.mjc.school.repository.utils;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.DataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils {
    public static List<NewsModel> readContentFromFile() {
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

    public static List<AuthorModel> readAuthorsFromFile() {
        List<AuthorModel> authorModels = new ArrayList<>();


        try (InputStreamReader inputStream = new InputStreamReader(Objects.requireNonNull(DataSource.class.getClassLoader().getResourceAsStream("content.txt")));
             BufferedReader bufferedReader = new BufferedReader(inputStream);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] newsParameters = line.split("%%");
                AuthorModel authorModel = new AuthorModel(Long.parseLong(newsParameters[0]),
                        newsParameters[1]);
                authorModels.add(authorModel);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e.getMessage());
        }
        return authorModels;
    }
}
