package com.mjc.school.repository.interfaces;

import java.util.List;

public interface Repository<T> {
    T create(T newsModel);

    List<T> readAll();

    T update(T entity);

    Boolean delete(Long id);

    T readById(Long id);

    Boolean isExistById(Long id);


}
