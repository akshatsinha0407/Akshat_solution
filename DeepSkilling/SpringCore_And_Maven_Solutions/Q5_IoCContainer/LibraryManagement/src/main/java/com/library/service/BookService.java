package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService: Bean instantiated by Spring IoC container.");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Dependency injected by IoC container.");
    }

    public void addBook(String title) {
        System.out.println("BookService: addBook() called for -> " + title);
        bookRepository.save(title);
    }

    public String getBook(int id) {
        return bookRepository.findById(id);
    }
}
