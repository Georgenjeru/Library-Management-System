package com.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    @Embedded
    private BookDetail bookDetail;

    @Column(name = "genre")
    private String genre;
    @Column(name = "author")
    private String Author;



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Book book;

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


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }
}
