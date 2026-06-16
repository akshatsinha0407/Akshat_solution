package com.library;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 7: Constructor & Setter Injection ===");
        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook("The Pragmatic Programmer");
        System.out.println("Retrieved: " + bookService.getBook(5));
        ((ClassPathXmlApplicationContext) context).close();
    }
}
