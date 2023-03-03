package com.mjc.school.repository.source.data;

import com.mjc.school.repository.utils.Utils;
import com.mjc.school.repository.entity.NewsModel;

import java.util.List;

public class NewsData {

    private static NewsData newsDataInstance;
    private static List<NewsModel> newsModelList;

    private NewsData() {
        init();
    }

    public static NewsData getNewsDataInstance() {
        if (newsDataInstance == null) {
            newsDataInstance = new NewsData();
        }
        return newsDataInstance;
    }

    public List<NewsModel> getNewsModelList() {
        return newsModelList;
    }

    private void init() {
        newsModelList = Utils.readContentFromFile();
    }

}
