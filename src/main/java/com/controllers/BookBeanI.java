package com.controllers;

import com.model.Admin;
import com.model.Book;

import java.util.List;

public interface BookBeanI {

    void add(Book book);
    List<Book> getList() throws Exception;

    void delete(Book book);

    void update(Book book);
}

