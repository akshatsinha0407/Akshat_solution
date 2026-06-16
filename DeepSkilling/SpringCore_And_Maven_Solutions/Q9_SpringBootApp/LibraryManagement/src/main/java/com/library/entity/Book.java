package com.library.entity;
import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column
    private String category;

    public Book() {}

    public Book(String title, String author, String category) {
        this.title    = title;
        this.author   = author;
        this.category = category;
    }

    // Getters and Setters
    public Long getId()            { return id; }
    public void setId(Long id)     { this.id = id; }

    public String getTitle()              { return title; }
    public void setTitle(String title)    { this.title = title; }

    public String getAuthor()             { return author; }
    public void setAuthor(String author)  { this.author = author; }

    public String getCategory()               { return category; }
    public void setCategory(String category)  { this.category = category; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', category='" + category + "'}";
    }
}
