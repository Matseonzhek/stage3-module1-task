package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.List;
import java.util.Scanner;

public interface Controlling {
    NewsDTO createNews(NewsDTO newsDTO, Scanner scanner) throws NewsValidationException;
    NewsDTO update(Long id, Scanner scanner) throws NewsValidationException;
    NewsDTO getNewsById(Long id);
    boolean deleteNews(Long id);
    List<NewsDTO> getAllNews();

    void validate(NewsDTO newsDTO) throws NewsValidationException;
}
