package com.library.repository;

public class BookRepository {
    public BookRepository() {
        System.out.println("BookRepository: Bean instantiated by Spring IoC container.");
    }
    public void save(String title) {
        System.out.println("BookRepository: Persisting -> " + title);
    }
    public String findById(int id) {
        return "Design Patterns (id=" + id + ")";
    }
}
