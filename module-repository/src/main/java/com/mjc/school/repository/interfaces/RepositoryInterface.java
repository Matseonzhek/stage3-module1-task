package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.entity.News;

import java.util.List;

public interface RepositoryInterface {
    News create(News news);

    List<News> readAll();

    News update(News entity);

    Boolean delete(Long id);

    News readById(Long id);


}
