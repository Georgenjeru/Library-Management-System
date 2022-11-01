package com.controllers;


import com.model.Book;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
@Named("bookController")
public class BookController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/library")
    DataSource dataSource;

    private List<Book> list;
    public void add(Book book) {
        if (book == null || StringUtils.isBlank(book.getTitle()) || StringUtils.isBlank(book.getAuthor()))
            return;

        try {

            Statement sqlStmt = dataSource.getConnection().createStatement();

            sqlStmt.executeUpdate("insert into books(genre, title, author) " +
                    "values('" + book.getGenre() + "','" + book.getTitle() +  "','" + book.getAuthor() + "')");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Inject
    public void delete(Book book) {
        try{

            Statement sqlStmt = dataSource.getConnection().createStatement();
            System.out.println("delete from  books  where Title='" + book.getTitle() + "'");
            sqlStmt.executeUpdate("delete from  books  where Title='" + book.getTitle() + "'");
        }
        catch(Exception ex1)
        {ex1.printStackTrace();}

    }


    public void update(Book book) {

    }


    public List<Book> getList() {
        List<Book> books = new ArrayList<Book>();

        try {

            Statement sqlStmt = dataSource.getConnection().createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from books");
            while (result.next()) {
                Book book = new Book();
                book.setGenre(result.getString("genre"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                books.add(book);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return books;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}