package com.controllers;


import com.model.Book;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
@Remote
public class BookBean implements BookBeanI {

    @PersistenceContext
    EntityManager entityManager;


    public void add(Book book) {
        if (book == null || StringUtils.isBlank(book.getTitle()) || StringUtils.isBlank(book.getAuthor()))
            return;
        entityManager.merge(book);


    }


    public void delete(Book book) {

    }


    public void update(Book book) {

    }


    public List<Book> getList() {
        return entityManager.createQuery("FROM Book s", Book.class).getResultList();

    }


}