package com.mjc.school.repository.implementation;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.interfaces.RepositoryInterface;
import com.mjc.school.repository.source.DataSource;

import java.util.List;

public class Repository implements RepositoryInterface {

    private final DataSource dataSource;

    public Repository() {
        this.dataSource =  DataSource.getInstance();
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        return dataSource.addNews(newsModel);
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.readAllNews();
    }

    @Override
    public NewsModel update(NewsModel entity) {
        return dataSource.addNews(entity);
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.removeNews(readById(id));
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource
                .readAllNews()
                .stream()
                .filter(news -> news.getId()==id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No data found"));
    }
}
