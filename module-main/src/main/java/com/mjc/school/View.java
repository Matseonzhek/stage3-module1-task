package com.mjc.school;

import com.mjc.school.service.dto.NewsDto;

import java.util.List;
import java.util.Scanner;

public class View {
    public View() {
    }

    public NewsDto getNewsDTO(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author ID: ");
        String authorID = scanner.nextLine();
        return new NewsDto(title, content, Long.parseLong(authorID));
    }

    public void printListOfNewsDTO(List<NewsDto> newsDtoList) {
        newsDtoList.forEach(System.out::println);
    }

    public void printNewsDTO(NewsDto newsById) {
        System.out.println(newsById);
    }

    public NewsDto updateNewsDto(Long id, Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter content: ");
        String content = scanner.nextLine();
        System.out.print("Enter author ID: ");
        String authorID = scanner.nextLine();
        return new NewsDto(id, title, content, Long.parseLong(authorID));
    }

    public long getId(Scanner scanner) {
        System.out.print("Enter news ID: ");
        return Long.parseLong(scanner.nextLine());
    }

}
