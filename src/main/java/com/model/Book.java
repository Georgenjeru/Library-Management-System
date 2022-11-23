package com.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends  BaseEntity{

    @Embedded
    private BookDetail bookDetail;

    @Column(name = "genre")
    private String genre;
    @Column(name = "author")
    private String Author;

    @Column
    private String BookId;

    @Column
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Issue> issues = new ArrayList<Issue>();

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {

        this.bookDetail = bookDetail;
    }
    @JsonbTransient
    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {

        this.issues = issues;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }
}
