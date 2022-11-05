package com.model;

import javax.persistence.*;

@Entity
@Table(name = "issues")
public class Issue extends BaseEntity{
    @Column(name = "bookId")
    String BookId;
    @Column(name = "userId")
    String UserId;
    @Column(name = "period")
    String Period;

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

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
}
