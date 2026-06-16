package com.library.repository;

public class BookRepository {
    public void save(String title) {
        System.out.println("BookRepository: Saving book -> " + title);
    }
    public String findById(int id) {
        System.out.println("BookRepository: Finding book id -> " + id);
        return "Effective Java (id=" + id + ")";
    }
}
