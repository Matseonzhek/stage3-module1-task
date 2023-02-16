package com.mjc.school.repository.interfaces;

import java.util.List;

public interface RepositoryInterface<T> {
    T create(T entity);

    List<T> readAll();

    T update(T entity);

    Boolean delete(Long id);

    T readById(Long id);


}
