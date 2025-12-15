package com.example.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component // Реєструє цей клас як Spring-бін
public class Book {

    // Отримуємо значення з properties-файлу за допомогою @Value
    @Value("Spring Core Principles") // Встановлюємо значення безпосередньо
    private String title;

    @Value("${book.isbn.default}") // Отримуємо значення з application.properties
    private String isbn;

    // Конструктор за замовчуванням потрібен для @Component (якщо немає іншого @Autowired конструктора)
    public Book() {
        System.out.println("Book: Конструктор викликано.");
    }

    // Методи життєвого циклу
    @PostConstruct
    public void init() {
        System.out.println("Book: INIT метод (@PostConstruct) викликано. Книга готова.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Book: DESTROY метод (@PreDestroy) викликано. Книга знищена.");
    }

    @Override
    public String toString() {
        return "Book [title='" + title + "', isbn='" + isbn + "']";
    }
}