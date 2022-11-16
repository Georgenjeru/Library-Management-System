package com.bean;

import com.model.User;
import com.model.Validate;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
@Remote
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LoginBean implements LoginBeanI {
    @PersistenceContext
    EntityManager entityManager;

    public User login(Validate validate) throws Exception{
        if (validate.getUsername() == null || validate.getPassword() == null)
            throw new Exception("Incorrect password or username");

        List<Validate> validates = entityManager.createQuery("FROM Validate a WHERE a.username=:username " +
                        "and a.password=:password", Validate.class)
                .setParameter("username", validate.getUsername())
                .setParameter("password", validate.getPassword())
                .getResultList();

        if (validate == null || validates.isEmpty() || validates.get(0) == null)
            throw new Exception("Invalid username or password");

        return validates.get(0).getUser();

    }
    public boolean validateMd5(String md5Hash){

        if (md5Hash == null)
            return false;

        List<Validate> validates = entityManager.createQuery("FROM Auth a", Validate.class)
                .getResultList();

        if (validates == null || validates.isEmpty())
            return false;

        boolean authenticated = false;
        for (Validate validate : validates) {
            if (DigestUtils.md5Hex(validate.getUsername() + " SALT=CH10 " + validate.getPassword()).equals(md5Hash)) {
                authenticated = true;
                break;
            }
        }

        return  authenticated;

    }
}


