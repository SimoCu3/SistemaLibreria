package model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.time.LocalDateTime;

public class Book {

    private int id;
    private String title;
    private Author author;
    private String ibsn;
    private LocalDateTime publishedDate;

    public Book(int id, String title, Author author, String ibsn, LocalDateTime publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ibsn = ibsn;
        this.publishedDate = publishedDate;
    }

    public Book(){}

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
