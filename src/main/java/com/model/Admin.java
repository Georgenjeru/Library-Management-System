package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "admins")
public class Admin extends BaseEntity{
    @Column(name = "regNo")
    private String regNo;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;


    public Admin(){}
    public Admin(String regNo, String name, String email){
        this.regNo = regNo;
        this.name = name;
        this.email = email;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }


}
