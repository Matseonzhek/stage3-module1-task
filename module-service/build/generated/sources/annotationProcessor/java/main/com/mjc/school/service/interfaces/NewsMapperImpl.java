package com.mjc.school.service.interfaces;

import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.dto.NewsDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T21:14:08+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto newsToNewsDTO(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( newsModel.getId() );
        newsDto.setTitle( newsModel.getTitle() );
        newsDto.setContent( newsModel.getContent() );
        newsDto.setAuthorId( newsModel.getAuthorId() );

        return newsDto;
    }

    @Override
    public NewsModel newsDTOToNews(NewsDto newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        if ( newsDTO.getId() != null ) {
            newsModel.setId( newsDTO.getId() );
        }
        newsModel.setTitle( newsDTO.getTitle() );
        newsModel.setContent( newsDTO.getContent() );
        newsModel.setAuthorId( newsDTO.getAuthorId() );

        return newsModel;
    }
}
