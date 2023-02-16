package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.repository.entity.NewsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDTO newsToNewsDTO(NewsModel newsModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "lastUpdateDate",ignore = true)
    NewsModel newsDTOToNews (NewsDTO newsDTO);
}
