package com.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "admins")
public class Admin extends BaseEntity {
    @Column(name = "regNo")
    private String regNo;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;

    public Admin() {
    }

    public Admin(String regNo, String name, String email) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();
    //@JoinColumn(name = "regNo", referencedColumnName = "regNo")


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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    /*public void addBook(Book book){
        book.setId(this.getId());
        getBooks().add(book);
    }*/
}
