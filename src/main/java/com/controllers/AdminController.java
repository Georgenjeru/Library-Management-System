package com.controllers;

import com.model.Admin;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named(value = "adminController")

public class AdminController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/library")
    DataSource dataSource;

    private List<Admin> list;


    @Inject
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
    @Inject
    public void delete(Admin admin) {
        try{

            Statement sqlStmt = dataSource.getConnection().createStatement();
            System.out.println("delete from  users  where Id='" + admin.getId() + "'");
            sqlStmt.executeUpdate("delete from  users  where Id='" + admin.getId() + "'");
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }
    public void update(Admin admin) {
        try {
            Statement sqlStmt  = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("UPDATE members " + "SET" + "name  = '" + admin.getName() + "'," +
                    "User Id = '" + admin.getId() + "'," +
                    "name = '" + admin.getName() + "'" +
                    "email = '" + admin.getEmail() + "'" +
                    "WHERE " + "username=" + "'" + admin.getName() + "'");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Inject
    public List<Admin> getList() {
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

    public void setList(List<Admin> list) {
        this.list = list;
    }
}