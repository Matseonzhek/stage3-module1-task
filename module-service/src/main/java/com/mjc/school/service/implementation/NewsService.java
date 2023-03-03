package com.mjc.school.service.implementation;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.NotFoundException;
import com.mjc.school.service.interfaces.NewsMapper;
import com.mjc.school.service.interfaces.Service;
import com.mjc.school.service.utils.Validator;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class NewsService implements Service<NewsDto> {

    private final Validator validator = Validator.getValidatorInstance();
    private final Repository<NewsModel> repository = new NewsRepository();

    public NewsService() {
    }

    @Override
    public NewsDto create(NewsDto newsDTO) {
        validator.validateNewsDto(newsDTO);
        NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        newsModel.setCreateDate(currentDate);
        newsModel.setLastUpdateDate(currentDate);
        NewsModel createdNewsModel = repository.create(newsModel);
        return NewsMapper.INSTANCE.newsToNewsDTO(createdNewsModel);
    }

    @Override
    public NewsDto update(NewsDto newsDTO) {
        validator.validateNewsId(newsDTO.getId());
        validator.validateNewsDto(newsDTO);
        if (repository.isExistById(newsDTO.getId())) {
            NewsModel newsModel = NewsMapper.INSTANCE.newsDTOToNews(newsDTO);
            LocalDateTime updatedTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            newsModel.setLastUpdateDate(updatedTime);
            NewsModel updatedNewsModel = repository.update(newsModel);
            return NewsMapper.INSTANCE.newsToNewsDTO(updatedNewsModel);
        } else {
            throw new NotFoundException("News does not exist");
        }
    }

    @Override
    public NewsDto readBy(Long id) {
        validator.validateNewsId(id);
        if (repository.isExistById(id)) {
            return NewsMapper.INSTANCE.newsToNewsDTO(repository.readById(id));
        } else {
            throw new NotFoundException("News does not exist");
        }

    }

    @Override
    public Boolean deleteNews(Long id) {
        validator.validateNewsId(id);
        if (repository.isExistById(id)) {
            return repository.delete(id);
        } else {
            throw new NotFoundException("News does not exist");
        }
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
