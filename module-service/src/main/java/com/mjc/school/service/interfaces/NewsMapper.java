package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.repository.entity.NewsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    NewsDto newsToNewsDTO(NewsModel newsModel);

    @Mapping(target = "createDate",ignore = true)
    @Mapping(target = "lastUpdateDate",ignore = true)
    NewsModel newsDTOToNews (NewsDto newsDTO);
}
