package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.repository.entity.News;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T20:11:18+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDTO newsToNewsDTO(News news) {
        if ( news == null ) {
            return null;
        }

        String title = null;
        String content = null;
        long authorId = 0L;

        title = news.getTitle();
        content = news.getContent();
        authorId = news.getAuthorId();

        NewsDTO newsDTO = new NewsDTO( title, content, authorId );

        return newsDTO;
    }

    @Override
    public News newsDTOToNews(NewsDTO newsDTO) {
        if ( newsDTO == null ) {
            return null;
        }

        News news = new News();

        news.setTitle( newsDTO.getTitle() );
        news.setContent( newsDTO.getContent() );
        news.setAuthorId( newsDTO.getAuthorId() );

        return news;
    }
}
