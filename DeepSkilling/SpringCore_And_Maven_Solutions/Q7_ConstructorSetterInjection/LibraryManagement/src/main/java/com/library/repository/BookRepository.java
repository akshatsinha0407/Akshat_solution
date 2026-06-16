package com.library.repository;

public class BookRepository {
    public void save(String title) {
        System.out.println("BookRepository: Saving -> " + title);
    }
    public String findById(int id) {
        return "Clean Architecture (id=" + id + ")";
    }
}
