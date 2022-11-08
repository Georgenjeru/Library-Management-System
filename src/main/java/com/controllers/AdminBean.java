package com.controllers;

import com.model.Admin;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("adminBean")
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
    public List<Admin> list(Admin filter){
        List<Admin> admin = new ArrayList<Admin>();


        return admin;
    }
    public void delete(Admin admin) {
        Admin admn = entityManager.find(Admin.class,admin.getId());
        entityManager.remove(admn);

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
    public Admin getAdmin() {
        Admin admin = new Admin();

        return admin;
    }

    public List<Admin> getList() {
        return entityManager.createQuery("FROM Admin a", Admin.class).getResultList();
    }

}