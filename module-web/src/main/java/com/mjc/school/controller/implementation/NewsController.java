package com.mjc.school.controller.implementation;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.ValidationException;
import com.mjc.school.service.implementation.NewsService;
import com.mjc.school.service.interfaces.Service;

import java.util.List;

public class NewsController {
    private final Service<NewsDto> newsService = new NewsService();

    public NewsController() {}

    public List<NewsDto> readAll(){
        return newsService.readAll();
    }

    public NewsDto readById(Long id){
        return newsService.readBy(id);
    }

    public NewsDto create(NewsDto newsDto) throws ValidationException {
        return newsService.create(newsDto);
    }

    public NewsDto update(NewsDto newsDto) throws ValidationException {
        return newsService.update(newsDto);
    }

    public Boolean deleteById(Long id){
        return newsService.deleteNews(id);
    }
}
