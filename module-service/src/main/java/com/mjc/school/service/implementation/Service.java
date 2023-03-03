package com.mjc.school.service.implementation;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.service.Utils.Validator;
import com.mjc.school.service.exceptions.NewsValidationException;
import com.mjc.school.service.interfaces.Controlling;
import com.mjc.school.service.interfaces.NewsMapper;

import java.util.ArrayList;
import java.util.List;

public class Service implements Controlling<NewsDto> {

    private final Validator validator = new Validator();
    private final Repository<NewsModel> repository = new NewsRepository();

    public Service() {
    }

    @Override
    public NewsDto create(NewsDto newsDTO) throws NewsValidationException {
        if (newsDTO == null) {
            return null;
        }
        validator.validate(newsDTO);
        NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
        repository.create(newsModel);
        return newsDTO;
    }

    @Override
    public NewsDto update(NewsDto newsDTO) throws NewsValidationException {
        validator.validate(newsDTO);
        NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
        repository.update(newsModel);
        return newsDTO;
    }

    @Override
    public NewsDto readBy(Long id) {
        if (id == null) {
            return null;
        }
        return NewsMapper.INSTANCE.newsToNewsDTO(repository.readById(id));
    }

    @Override
    public Boolean deleteNews(Long id) {
        if (id == null) {
            return false;
        }
        return repository.delete(id);
    }

    @Override
    public List<NewsDto> readAll() {
        List<NewsModel> newsModelList = repository.readAll();
        List<NewsDto> newsDtoList = new ArrayList<>();
        for (NewsModel element : newsModelList) {
            NewsDto newsDTO = NewsMapper.INSTANCE.newsToNewsDTO(element);
            newsDtoList.add(newsDTO);
        }
        return newsDtoList;
    }

}
