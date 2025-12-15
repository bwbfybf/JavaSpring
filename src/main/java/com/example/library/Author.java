// com/example/library/Author.java
package com.example.library;

public class Author {
    private String name;
    private Book favoriteBook; // Вкладення Рівня 3

    // Конструктор для DI (для name)
    public Author(String name) {
        this.name = name;
    }

    // Сеттер для DI (для favoriteBook - посилання на бін)
    public void setFavoriteBook(Book favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    @Override
    public String toString() {
        return "Author [name='" + name + "', favoriteBook=" + favoriteBook + "]";
    }
}