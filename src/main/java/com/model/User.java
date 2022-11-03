package com.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "validates")
public class User{
    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;
    @Column
    private String profile;
    @Column
    private String email;

    @Column
    private  Long Id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)

    private List<Validate> validates = new ArrayList<Validate>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Validate> getValidates() {
        return validates;
    }

    public void setValidates(List<Validate> validates) {
        this.validates = validates;
    }
    public void addValidate(Validate validate){
        validate.setUser(this);
        getValidates().add(validate);
    }
}