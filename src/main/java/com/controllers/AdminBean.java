package com.controllers;

import com.model.Admin;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
public class AdminBean implements AdminBeanI {

    @PersistenceContext
    EntityManager entityManager;


    public void add(Admin admin) {
        if (admin == null || StringUtils.isBlank(admin.getName()) || StringUtils.isBlank(admin.getRegNo()))
            return;
        if (admin.getEmail() == null)
            admin.setEmail("email");

        entityManager.merge(admin);


    }
    public void delete(Admin admin) {

        /*try{

            Statement sqlStmt = dataSource.getConnection().createStatement();
            System.out.println("delete from  users  where Id='" + admin.getId() + "'");
            sqlStmt.executeUpdate("delete from  users  where Id='" + admin.getId() + "'");
        }
        catch(Exception ex1)
        {ex1.printStackTrace();*/

    }
    public void update(Admin admin) {
        /*try {
            Statement sqlStmt  = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("UPDATE members " + "SET" + "name  = '" + admin.getName() + "'," +
                    "User Id = '" + admin.getId() + "'," +
                    "name = '" + admin.getName() + "'" +
                    "email = '" + admin.getEmail() + "'" +
                    "WHERE " + "username=" + "'" + admin.getName() + "'");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }


    public List<Admin> getList() {
        return entityManager.createQuery("FROM Admin a", Admin.class).getResultList();
    }

}