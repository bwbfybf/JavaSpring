// com/example/library/Book.java
package com.example.library;

public class Book {
    private String title;
    private String isbn;

    // Конструктор для DI (для title)
    public Book(String title) {
        this.title = title;
    }

    // Сеттер для DI (для isbn)
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book [title='" + title + "', isbn='" + isbn + "']";
    }
}