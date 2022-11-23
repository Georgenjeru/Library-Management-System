package com.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "issues")
public class Issue extends BaseEntity{


    @Column
    private String BookId;
    @Column(name = "userId")
    private String UserId;
    @Column(name = "period")
    private String Period;

    /* @Column
   LocalDate StartDate;

    @Column
    LocalDate EndDate;

    @Embedded
    private BookDetail bookDetail;*/

    @Column
    private String Title;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Admin admin;


    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {

        this.admin = admin;
    }


    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

}
