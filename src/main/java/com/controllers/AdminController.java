package com.controllers;

import com.model.Admin;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named(value = "adminController")

public class AdminController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/library")
    DataSource dataSource;

    public void add(Admin admin) {
        if (admin == null || StringUtils.isBlank(admin.getName()) || StringUtils.isBlank(admin.getId()))
            return;

        try {

            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("insert into users(Id, Name, Email) " +
                    "values('" + admin.getId() + "','" + admin.getName() +  "','" + admin.getEmail() + "')");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Admin admin) {
        try{

            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("delete from  users  where Id='" + admin.getId() + "'");

        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }

    public void update(Connection connection, Admin admin) {

    }

    public List<Admin> list( Admin filter) {
        List<Admin> admins = new ArrayList<Admin>();

        try {

            Statement sqlStmt = dataSource.getConnection().createStatement();


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