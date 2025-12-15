// App.java
package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Завантаження Spring контейнера та XML-конфігурації
        System.out.println("Loading Spring Context...");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");

        // Отримання головного біна Рівня 1
        Library library = (Library) context.getBean("libraryBean");
        System.out.println("Context Loaded successfully.");
        System.out.println("------------------------------------");

        // Виклик методу для демонстрації DI
        library.showInfo();

        ((ClassPathXmlApplicationContext) context).close();
    }
}