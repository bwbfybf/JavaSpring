package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Author {

    @Value("Craig Walls") // Значення для імені
    private String name;

    private Book favoriteBook; // Залежність Рівня 3

    public Author() {
        System.out.println("Author: Конструктор викликано.");
    }

    // DI через Сеттер (@Autowired)
    @Autowired
    public void setFavoriteBook(Book favoriteBook) {
        System.out.println("Author: Залежність Book інжектовано через сеттер.");
        this.favoriteBook = favoriteBook;
    }

    @PostConstruct
    public void init() {
        System.out.println("Author: INIT метод викликано.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Author: DESTROY метод викликано.");
    }

    @Override
    public String toString() {
        return "Author [name='" + name + "', favoriteBook=" + favoriteBook + "]";
    }
}