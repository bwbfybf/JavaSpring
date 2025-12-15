package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting Spring Context using Java Config...");

        // 1. Завантаження контексту через Java-клас конфігурації
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("------------------------------------");

        // 2. Отримання головного біна
        // Spring шукає бін за назвою класу, але з малої літери: "library"
        Library library = context.getBean("library", Library.class);

        // 3. Виклик методу
        library.showInfo();

        System.out.println("------------------------------------");
        // 4. Обов'язково закриваємо контекст, щоб викликались @PreDestroy методи
        context.close();
    }
}