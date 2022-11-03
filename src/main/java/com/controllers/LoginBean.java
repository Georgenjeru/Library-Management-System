package com.controllers;

import com.model.User;
import com.model.Validate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.ejb.*;
import java.util.List;


@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LoginBean implements LoginBeanI {
    @PersistenceContext
    EntityManager entityManager;

    public User login(Validate validate) throws Exception{
        if (validate.getUsername() == null || validate.getPassword() == null)
            throw new Exception("Incorrect password or username");

        List<Validate> validates = entityManager.createQuery("FROM validates a WHERE a.username=:userName " +
                        "and a.password=:pwd", Validate.class)
                .setParameter("userName", validate.getUsername())
                .setParameter("password", validate.getPassword())
                .getResultList();

        if (validate == null || validates.isEmpty() || validates.get(0) == null)
            throw new Exception("Invalid username or password");

        return validates.get(0).getUser();

    }
}

