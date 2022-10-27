package com.controllers;

import com.model.Admin;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminController implements Serializable {
    public void add(Connection connection, Admin admin) {
        if (admin == null || StringUtils.isBlank(admin.getName()) || StringUtils.isBlank(admin.getId()))
            return;

        try {

            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("insert into users(Id, Name, Email) " +
                    "values('" + admin.getId() + "','" + admin.getName() +  "','" + admin.getEmail() + "')");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Connection connection, Admin admin) {
        try{
            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("delete from  users  where Id='" + admin.getId() + "'");

        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }

    public void update(Connection connection, Admin admin) {

    }

    public List<Admin> list(Connection connection, Admin filter) {
        List<Admin> admins = new ArrayList<Admin>();

        try {
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from users");
            while (result.next()) {
                Admin admin = new Admin();
                admin.setId(result.getString("Id"));
                admin.setName(result.getString("name"));
                admin.setEmail(result.getString("Email"));
                admins.add(admin);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return admins;
    }
}