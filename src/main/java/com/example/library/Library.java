// com/example/library/Library.java
package com.example.library;

public class Library {
    private String name;
    private Author featuredAuthor; // Вкладення Рівня 2

    // Конструктор для DI (для name та featuredAuthor)
    public Library(String name, Author featuredAuthor) {
        this.name = name;
        this.featuredAuthor = featuredAuthor;
    }

    public void showInfo() {
        System.out.println("--- Library System Information ---");
        System.out.println("Library Name: " + name);
        System.out.println("Featured Author: " + featuredAuthor.toString());
    }
}