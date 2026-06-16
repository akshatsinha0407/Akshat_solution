package com.library;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Spring IoC Container ===");
        // Spring IoC container reads XML and creates/wires beans automatically
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("Refactoring");
        System.out.println("Retrieved: " + bookService.getBook(10));
        ((ClassPathXmlApplicationContext) context).close();
    }
}
