package com.controllers;

import com.model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    @Resource(lookup = "java:jboss/datasources/library")
    DataSource dataSource;


    public User login(String username, String password) {

        User user = null;

        try {
            Connection connection = dataSource.getConnection();
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from userlogin where username='" + username + "' and " +
                    "password='" + password + "'");
            while (result.next()) {
                user = new User();
                user.setId((long) result.getInt("id"));
                user.setUsername(result.getString("username"));
            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return user;

    }

}
