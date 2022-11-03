package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "validate")
public class Validate {

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    private User user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
