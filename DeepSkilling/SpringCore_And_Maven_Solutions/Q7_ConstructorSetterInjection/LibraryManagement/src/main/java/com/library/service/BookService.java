package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // ---- Constructor Injection ----
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection completed.");
    }

    // ---- Setter Injection ----
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection completed.");
    }

    public void addBook(String title) {
        System.out.println("BookService: addBook() -> " + title);
        bookRepository.save(title);
    }

    public String getBook(int id) {
        return bookRepository.findById(id);
    }
}
