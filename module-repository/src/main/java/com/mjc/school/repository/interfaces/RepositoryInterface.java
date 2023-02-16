package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.entity.NewsModel;

import java.util.List;

public interface RepositoryInterface {
    NewsModel create(NewsModel newsModel);

    List<NewsModel> readAll();

    NewsModel update(NewsModel entity);

    Boolean delete(Long id);

    NewsModel readById(Long id);


}
