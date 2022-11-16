package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issues")
public class Issue extends BaseEntity{

    @Column(name = "userId")
    private String UserId;
    @Column(name = "period")
    private String Period;

    @Column
    Date StartDate;

    @Column
    Date EndDate;

    @Embedded
    private BookDetail bookDetail;

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


    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {

        this.bookDetail = bookDetail;
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

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }
}
