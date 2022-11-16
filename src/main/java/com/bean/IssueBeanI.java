package com.bean;

import com.model.Admin;
import com.model.Issue;

import java.util.List;

public interface IssueBeanI {

    void add(Issue issue);

    void delete(Issue issue);

    void update(Issue issue);

    List<Issue> getList();

    List<Admin> viewIssuedBooks();

    List<Admin> pendingBooks();
}



