package com.bean;

import com.model.Admin;
import com.model.Book;
import com.model.Issue;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.*;
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
    public  void update(Admin admin) {
        if (admin == null || StringUtils.isBlank(admin.getRegNo()))
            return;
        if (StringUtils.isBlank(admin.getName()))
            return;
        if (StringUtils.isBlank(admin.getEmail()))
            return;

        if (admin.getId() != null)
            System.out.println("Entity manager will update");


        entityManager.merge(admin);

    }

    public Admin getAdmin(Long id) {

        return entityManager.find(Admin.class, id );

    }
    public void orderBy(){
        Query query = entityManager.createQuery("SELECT a FROM admins a ORDER BY a.id DESC");
        List<Admin> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
    public void limit() {
        Query query = entityManager.createQuery("SELECT m FROM books m ORDER BY m.id DESC ").setMaxResults(4);
        List<Book> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }


    public List<Admin> getList() {

        return entityManager.createQuery("FROM Admin a", Admin.class).getResultList();

        //return  entityManager.createNamedQuery(Admin.FIND_ALL, Admin.class).getResultList();
    }
    public List<Admin> list() {
        return  entityManager.createNamedQuery(Admin.FIND_ALL, Admin.class).getResultList();

    }
    public List<Admin> requestBook() {
        List<Admin> admins = entityManager.createQuery("", Admin.class)
                .getResultList();
        return admins;
    }


}