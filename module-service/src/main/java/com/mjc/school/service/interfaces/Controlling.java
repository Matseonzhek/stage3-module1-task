package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.List;
import java.util.Scanner;

public interface Controlling<T> {

    T create(NewsDto newsDTO, Scanner scanner) throws NewsValidationException;
    T update(Long id, Scanner scanner) throws NewsValidationException;
    T readBy(Long id);
    Boolean deleteNews(Long id);
    List<T> readAll();


}
