package com.model;

import javax.persistence.*;

@Entity
@Table(name = "issues")
public class Issue extends BaseEntity{

    @Column(name = "userId")
    private String UserId;
    @Column(name = "period")
    private String Period;

    @Embedded
    private BookDetail bookDetail;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)


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
}
