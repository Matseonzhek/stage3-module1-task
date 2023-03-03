package com.mjc.school.repository.implementation;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.repository.source.DataSource;

import java.util.Comparator;
import java.util.List;

public class NewsRepository implements Repository<NewsModel> {

    private final DataSource dataSource;

    public NewsRepository() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        List<NewsModel> newsModelList = dataSource.getAllNews();
        newsModelList.sort(Comparator.comparing(NewsModel::getId));
        if (!newsModelList.isEmpty()) {
            newsModel.setId(newsModelList.get(newsModelList.size() - 1).getId() + 1);
        } else {
            newsModel.setId(1L);
        }
        newsModelList.add(newsModel);
        return newsModel;
    }

    @Override
    public List<NewsModel> readAll() {
        return dataSource.getAllNews();
    }

    @Override
    public NewsModel update(NewsModel entity) {
        long id = entity.getId();
        NewsModel updatedModel = readById(id);
        updatedModel.setTitle(entity.getTitle());
        updatedModel.setContent(entity.getContent());
        updatedModel.setLastUpdateDate(entity.getLastUpdateDate());
        updatedModel.setAuthorId(entity.getAuthorId());

        return updatedModel;
    }

    @Override
    public Boolean delete(Long id) {
        return dataSource.getAllNews().remove(readById(id));
    }

    @Override
    public NewsModel readById(Long id) {
        return dataSource
                .getAllNews()
                .stream()
                .filter(news -> news.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public Boolean isExistById(Long id) {
        return dataSource.getAllNews().stream().anyMatch(news -> id.equals(news.getId()));
    }


}
