package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.List;

public interface Controlling<T> {

    T create(NewsDto newsDTO) throws NewsValidationException;

    T update(NewsDto newsDTO) throws NewsValidationException;

    T readBy(Long id);

    Boolean deleteNews(Long id);

    List<T> readAll();


}
