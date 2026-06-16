package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter used by Spring for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter.");
    }

    public void addBook(String title) {
        System.out.println("BookService: Adding book -> " + title);
        bookRepository.save(title);
    }

    public String getBook(int id) {
        return bookRepository.findById(id);
    }
}
