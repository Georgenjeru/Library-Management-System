package com.bean;

import com.model.Book;
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
@Named("bookController")
public class BookBean implements BookBeanI {

    @PersistenceContext
    EntityManager entityManager;


    public void add(Book book) {
        if (book == null || StringUtils.isBlank(book.getBookId()) || StringUtils.isBlank(book.getBookDetail().getTitle()))
            return;
        if (book.getAuthor() == null)
            book.setAuthor("author");

        entityManager.merge(book);


    }


    public void delete(Book book) {
        Book book1 = entityManager.find(Book.class,book.getId());
        entityManager.remove(book1);
    }
    public List<Book> list(Book filter){
        List<Book> books = new ArrayList<Book>();


        return books;
    }


    public  void update(Book book) {
        if (book == null || StringUtils.isBlank(book.getAuthor()))
            return;
        if (StringUtils.isBlank(book.getBookDetail().getTitle()))
            return;
        if (StringUtils.isBlank(book.getGenre()))
            return;
        if (StringUtils.isBlank(book.getBookId()))
            return;

        if (book.getId() != null)
            System.out.println("Entity manager will update");


        entityManager.merge(book);

    }
    public Book getBook(Long id) {
        return entityManager.find(Book.class, id );

    }
    /*public void groupBy() {
        Query query = entityManager.createQuery("SELECT bookId FROM books b GROUP BY b.bookId DESC");
        List<Object[]> list = query.getResultList();
        for (Object[] object : list) {
            System.out.println(object[0] + "     " + object[1]);
        }
    }*/

    public List<Book> getList() {

        return entityManager.createQuery("FROM Book b", Book.class).getResultList();
    }

    public List<Book> issueList() {

        return entityManager.createQuery("FROM Book b", Book.class).getResultList();
    }



}