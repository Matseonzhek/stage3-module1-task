package com.mjc.school;

import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.controller.implementation.View;
import com.mjc.school.controller.interfaces.Viewing;
import com.mjc.school.repository.interfaces.Repository;
import com.mjc.school.repository.implementation.RepositoryImpl;
import com.mjc.school.service.implementation.Controller;
import com.mjc.school.service.interfaces.Controlling;
import com.mjc.school.service.exceptions.NewsValidationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Viewing view = new View();
        Repository model = RepositoryImpl.getInstance();
        Controlling controller = new Controller(view, model);
        Scanner scanner = new Scanner(System.in);
        long idNews;
        NewsDTO newsDTO;

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
                    case "1" -> view.printListOfNewsDTO(controller.getAllNews());
                    case "2" -> {
                        idNews = view.getId(scanner);
                        view.printNewsDTO(controller.getNewsById(idNews));
                    }
                    case "3" -> {
                        newsDTO = view.getNewsDTO(scanner);
                        controller.createNews(newsDTO, scanner);
                    }
                    case "4" -> {
                        idNews = view.getId(scanner);
                        controller.update(idNews, scanner);

                    }
                    case "5" -> {
                        idNews = view.getId(scanner);
                        controller.deleteNews(idNews);
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
