package com.mjc.school.repository.source;

import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.data.AuthorData;
import com.mjc.school.repository.source.data.NewsData;

import java.util.List;

public class DataSource {
    private static DataSource instance;
    private static List<NewsModel> dataSource;


    private final List<NewsModel> newsModelList;
    private final List<AuthorModel> authorModelList;

    private DataSource() {
        newsModelList = NewsData.getNewsDataInstance().getNewsModelList();
        authorModelList = AuthorData.getAuthorDataInstance().getAuthorModelList();
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public List<NewsModel> getAllNews() {
        return newsModelList;
    }

    public List<AuthorModel> getAllAuthors() {
        return authorModelList;
    }
}
