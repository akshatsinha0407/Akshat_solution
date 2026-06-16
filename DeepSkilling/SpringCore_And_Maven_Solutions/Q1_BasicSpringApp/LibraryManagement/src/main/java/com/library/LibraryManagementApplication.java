package com.library;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=== Exercise 1: Basic Spring Application ===");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Spring in Action");
        bookService.addBook("Clean Code");
        System.out.println("Spring context loaded successfully!");
        ((ClassPathXmlApplicationContext) context).close();
    }
}
