package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.repository.entity.NewsModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-17T19:34:54+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto newsToNewsDTO(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        String title = null;
        String content = null;
        long authorId = 0L;

        title = newsModel.getTitle();
        content = newsModel.getContent();
        authorId = newsModel.getAuthorId();

        NewsDto newsDTO = new NewsDto( title, content, authorId );

        return newsDTO;
    }

    @Override
    public NewsModel newsDTOToNews(NewsDto newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setTitle( newsDTO.getTitle() );
        newsModel.setContent( newsDTO.getContent() );
        newsModel.setAuthorId( newsDTO.getAuthorId() );

        return newsModel;
    }
}
