package com.mjc.school.repository.implementation;

import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.interfaces.RepositoryInterface;
import com.mjc.school.repository.source.DataSource;

import java.util.List;

public class Repository implements RepositoryInterface<News> {

    private final DataSource dataSource;

    public Repository() {
        this.dataSource =  DataSource.getInstance();
    }

    @Override
    public News create(News entity) {
        return dataSource.addNews(entity);
    }

    @Override
    public List<News> readAll() {
        return dataSource.readAllNews();
    }

    @Override
    public News update(News entity) {
        return dataSource.addNews(entity);
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.removeNews(readById(id));
    }

    @Override
    public News readById(Long id) {
        return dataSource
                .readAllNews()
                .stream()
                .filter(news -> news.getId()==id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No data found"));
    }
}
