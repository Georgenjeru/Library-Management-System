package com.controllers;


import com.model.Book;
import com.mysql.jdbc.Connection;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookController implements Serializable {
    public void add(Connection connection, Book book) {
        if (book == null || StringUtils.isBlank(book.getTitle()) || StringUtils.isBlank(book.getAuthor()))
            return;

        try {

            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("insert into books(genre, title, author) " +
                    "values('" + book.getGenre() + "','" + book.getTitle() +  "','" + book.getAuthor() + "')");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Book book) {

    }


    public void update(Book book) {

    }

    public List<Book> list(Connection connection, Book filter) {
        List<Book> books = new ArrayList<Book>();

        try {
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from books");
            while (result.next()) {
                Book book = new Book();
                book.setGenre(result.getString("genre"));
                book.setTitle(result.getString("tittle"));
                book.setAuthor(result.getString("author"));
                books.add(book);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return books;
    }
}