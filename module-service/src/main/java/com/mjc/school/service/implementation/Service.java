package com.mjc.school.service.implementation;

import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.controller.interfaces.Viewing;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.interfaces.RepositoryInterface;
import com.mjc.school.service.interfaces.Controlling;
import com.mjc.school.service.interfaces.NewsMapper;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service implements Controlling {

    private final Viewing view;
    private final RepositoryInterface repository;

    public Service(Viewing view, RepositoryInterface repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public NewsDTO createNews(NewsDTO newsDTO, Scanner scanner) throws NewsValidationException {
        if (newsDTO == null) {
            return null;
        }
        validate(newsDTO);
        NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
        repository.create(newsModel);
        return newsDTO;
    }

    @Override
    public NewsDTO update(Long id, Scanner scanner) throws NewsValidationException {
        if (id == null) {
            return null;
        }
        NewsModel newsModel = (NewsModel) repository.readById(id);
        NewsDTO newsDTO = view.getNewsDTO(scanner);
        validate(newsDTO);
        newsModel.setTitle(newsDTO.getTitle());
        newsModel.setContent(newsDTO.getContent());
        newsModel.setAuthorId(newsDTO.getAuthorId());
        return newsDTO;
    }

    @Override
    public NewsDTO readBy(Long id) {
        if (id == null) {
            return null;
        }
        return NewsMapper.INSTANCE.newsToNewsDTO((NewsModel) repository.readById(id));
    }

    @Override
    public Boolean deleteNews(Long id) {
        if (id == null) {
            return false;
        }
        return repository.delete(id);
    }

    @Override
    public List<NewsDTO> readAll() {
        List<NewsModel> newsModelList = repository.readAll();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        for (NewsModel element : newsModelList) {
            NewsDTO newsDTO = NewsMapper.INSTANCE.newsToNewsDTO(element);
            newsDTOList.add(newsDTO);
        }
        return newsDTOList;
    }

    @Override
    public void validate(NewsDTO newsDTO) throws NewsValidationException {
        if (!(newsDTO.getTitle().length() >= 5 && newsDTO.getTitle().length() <= 30)) {
            throw new NewsValidationException("com.mjc.school.repository.entity.News was not updated, as length of the title is less of 5 or more than 30."
                    + newsDTO.getTitle() + ": " + newsDTO.getTitle().length());
        }
        if (!(newsDTO.getContent().length() >= 5 && newsDTO.getContent().length() <= 255)) {
            throw new NewsValidationException("com.mjc.school.repository.entity.News was not updated, as length of the content is less of 5 or more than 255 "
                    + newsDTO.getContent() + ": " + newsDTO.getContent().length());
        }
    }
}
