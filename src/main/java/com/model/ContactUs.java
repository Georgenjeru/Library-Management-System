package com.model;


import javax.persistence.*;

@Entity
@Table(name = "contact_us")

public class ContactUs extends BaseEntity {
    @Column
    private  String userEmail;
    @Column
    private String contactMessage;

    @Column
    private String userPhoneNo;

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage;
    }


}
