package com.library;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("=== Exercise 2: Dependency Injection ===");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Spring in Action");
        System.out.println("Retrieved: " + bookService.getBook(1));
        ((ClassPathXmlApplicationContext) context).close();
    }
}
