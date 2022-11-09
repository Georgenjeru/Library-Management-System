package com.model;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookDetail {

    @Column
    private String BookId;

    @Column
    private String Title;

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
