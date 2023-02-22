package com.mjc.school.controller.implementation;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.controller.interfaces.Viewing;

import java.util.List;
import java.util.Scanner;

public class View implements Viewing {
    public View() {
    }

    @Override
    public NewsDto getNewsDTO(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author ID: ");
        String authorID = scanner.nextLine();
        return new NewsDto(title, content, Long.parseLong(authorID));
    }

    @Override
    public void printListOfNewsDTO(List<NewsDto> newsDtoList) {
        newsDtoList.forEach(System.out::println);
    }

    @Override
    public void printNewsDTO(NewsDto newsById) {
        System.out.println(newsById);
    }

    @Override
    public NewsDto updateNewsDto(Long id, Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author ID: ");
        String authorID = scanner.nextLine();
        return new NewsDto(id, title, content, Long.parseLong(authorID));
    }

    @Override
    public long getId(Scanner scanner) {
        System.out.print("Enter news ID: ");
        return Long.parseLong(scanner.nextLine());
    }

}
