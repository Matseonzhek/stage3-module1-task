package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.ValidationException;

import java.util.List;

public interface Service<T> {

    T create(NewsDto newsDTO) ;

    T update(NewsDto newsDTO) ;

    T readBy(Long id);

    Boolean deleteNews(Long id);

    List<T> readAll();


}
