package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.List;

public interface Service<T> {

    T create(NewsDto newsDTO) throws NewsValidationException;

    T update(NewsDto newsDTO) throws NewsValidationException;

    T readBy(Long id);

    Boolean deleteNews(Long id);

    List<T> readAll();


}
