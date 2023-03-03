package com.mjc.school;

import com.mjc.school.controller.implementation.NewsController;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        NewsController newsController = new NewsController();
        Scanner scanner = new Scanner(System.in);
        long idNews;
        NewsDto newsDTO;

        while (true) {
            try {
                System.out.println("Enter the number of operation");
                System.out.println("1 - Get all news.");
                System.out.println("2 - Get news by id");
                System.out.println("3 - Create news");
                System.out.println("4 - Update news");
                System.out.println("5 - Remove new by id");
                System.out.println("0 - Exit");

                switch (scanner.nextLine()) {
                    case "1" -> view.printListOfNewsDTO(newsController.readAll());
                    case "2" -> {
                        idNews = view.getId(scanner);
                        view.printNewsDTO(newsController.readById(idNews));
                    }
                    case "3" -> {
                        newsDTO = view.getNewsDTO(scanner);
                        newsController.create(newsDTO);
                    }
                    case "4" -> {
                        idNews = view.getId(scanner);
                        newsDTO = view.updateNewsDto(idNews, scanner);
                        newsController.update(newsDTO);
                    }
                    case "5" -> {
                        idNews = view.getId(scanner);
                        newsController.deleteById(idNews);
                    }
                    case "0" -> {
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Command not found");
                    }
                }
            } catch (RuntimeException | NewsValidationException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
