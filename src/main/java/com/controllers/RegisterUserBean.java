package com.controllers;

import com.model.User;
import com.model.Validate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Remote
public class RegisterUserBean implements RegisterUserBeanI{

    @PersistenceContext
    EntityManager entityManager;

    public User register(User user) throws Exception {
        if (user == null)
            throw new Exception("Empty field");

        if (user.getFirstName() == null)
            throw new Exception("First Name is Required");

        if (user.getLastName() == null)
            throw new Exception("Last Name is Needed");

        if (user.getEmail() == null)
            throw new Exception("Email is required");

        if (user.getPassword() == null)
            throw new Exception("Password is needed");

        if (user.getConfirmPassword() == null)
            throw new Exception("Confirm Password Required");

        Validate validate = new Validate();
        validate.setUsername(user.getEmail());
        if (user.getPassword() == null || user.getConfirmPassword() == null
                || !user.getPassword().equals(user.getConfirmPassword()))
            throw new Exception("Password & confirm password must match");

        validate.setUsername(user.getEmail());
        validate.setPassword(user.getPassword());
        validate.setConfirmPassword(user.getConfirmPassword());

        user.addValidate(validate);

        return entityManager.merge(user);

    }
}