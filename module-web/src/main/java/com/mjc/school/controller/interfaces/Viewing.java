package com.mjc.school.controller.interfaces;

import com.mjc.school.controller.entity.NewsDto;

import java.util.List;
import java.util.Scanner;

public interface Viewing{
    NewsDto getNewsDTO(Scanner scanner);
    long getId(Scanner scanner);
    void printListOfNewsDTO(List<NewsDto> newsDtoList);
    void printNewsDTO(NewsDto newsById);
}
