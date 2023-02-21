package com.mjc.school.service.implementation;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.controller.interfaces.Viewing;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.implementation.Repository;
import com.mjc.school.repository.interfaces.RepositoryInterface;
import com.mjc.school.service.exceptions.NewsValidationException;
import com.mjc.school.service.interfaces.Controlling;
import com.mjc.school.service.interfaces.NewsMapper;
import com.mjc.school.service.interfaces.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service implements Controlling<NewsDto>, Validator {

    private final Viewing view;
    private final RepositoryInterface<NewsModel> repository;

    public Service(Viewing view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public NewsDto create(NewsDto newsDTO, Scanner scanner) throws NewsValidationException {
        if (newsDTO == null) {
            return null;
        }
        validate(newsDTO);
        NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
        repository.create(newsModel);
        return newsDTO;
    }

    @Override
    public NewsDto update(Long id, Scanner scanner) throws NewsValidationException {
        if (id == null) {
            return null;
        }
        NewsModel newsModel = repository.readById(id);
        NewsDto newsDTO = view.getNewsDTO(scanner);
        validate(newsDTO);
        newsModel.setTitle(newsDTO.getTitle());
        newsModel.setContent(newsDTO.getContent());
        newsModel.setAuthorId(newsDTO.getAuthorId());
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

    @Override
    public void validate(NewsDto newsDTO) throws NewsValidationException {
        if (!(newsDTO.getTitle().length() >= 5 && newsDTO.getTitle().length() <= 30)) {
            throw new NewsValidationException("com.mjc.school.repository.entity.News was not updated, as length of the title is less of 5 or more than 30." + newsDTO.getTitle() + ": " + newsDTO.getTitle().length());
        }
        if (!(newsDTO.getContent().length() >= 5 && newsDTO.getContent().length() <= 255)) {
            throw new NewsValidationException("com.mjc.school.repository.entity.News was not updated, as length of the content is less of 5 or more than 255 " + newsDTO.getContent() + ": " + newsDTO.getContent().length());
        }
    }
}
