package com.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Admin.FIND_ALL, query = "SELECT a FROM Admin a")})
@Entity
@Table(name = "admins")
public class Admin extends BaseEntity {


    public static final String FIND_ALL = "Admin.findAll";

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

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Issue> issues = new ArrayList<Issue>();
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

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }
}
