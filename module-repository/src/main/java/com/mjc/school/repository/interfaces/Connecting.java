package com.mjc.school.repository.interfaces;

import com.mjc.school.repository.entity.News;

import java.util.List;

public interface Connecting {
    News readById(Long id);
    List<News> readAllNews();
    Boolean delete(Long id);
    void createAndUpdateDataBase(News news);

    List<News> getDataSource();

}
