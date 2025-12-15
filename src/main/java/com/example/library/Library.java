package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Library {
    private String name;
    private Author featuredAuthor; // Залежність Рівня 2

    // DI через Конструктор (@Autowired)
    // Значення name береться з properties-файлу
    @Autowired
    public Library(@Value("${library.name}") String name, Author featuredAuthor) {
        this.name = name;
        this.featuredAuthor = featuredAuthor;
        System.out.println("Library: Конструктор викликано. DI завершено.");
    }

    @PostConstruct
    public void init() {
        System.out.println("Library: INIT метод викликано. Система готова.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Library: DESTROY метод викликано. Система вимикається.");
    }

    public void showInfo() {
        System.out.println("--- Library System Information (Annotation Config) ---");
        System.out.println("Library Name: " + name);
        System.out.println("Featured Author: " + featuredAuthor.toString());
    }
}