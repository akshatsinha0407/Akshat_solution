package com.library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Exercise 9: Spring Boot Application
 *
 * Run this class to start the embedded Tomcat server.
 * REST Endpoints:
 *   GET    /api/books              - List all books
 *   GET    /api/books/{id}         - Get book by ID
 *   POST   /api/books              - Create a new book
 *   PUT    /api/books/{id}         - Update a book
 *   DELETE /api/books/{id}         - Delete a book
 *   GET    /api/books/category/{c} - Filter by category
 *   GET    /h2-console             - H2 database console
 */
@SpringBootApplication
public class LibraryManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
        System.out.println("=== Library Management Spring Boot App Started ===");
        System.out.println("API available at: http://localhost:8080/api/books");
        System.out.println("H2 Console at:   http://localhost:8080/h2-console");
    }
}
