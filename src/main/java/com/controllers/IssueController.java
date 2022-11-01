package com.controllers;


import com.model.Admin;
import com.model.Issue;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@RequestScoped
@Named("issueController")

public class IssueController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/library")
    DataSource dataSource;

    private List<Issue> list;
    public void add(Issue issue) {
        if (issue == null || StringUtils.isBlank(issue.getBookId()) || StringUtils.isBlank(issue.getUserId()))
            return;

        try {
            Statement sqlStmt = dataSource.getConnection().createStatement();
            sqlStmt.executeUpdate("insert into issues(bookId, userId, period) " +
                    "values('" + issue.getBookId() + "','" + issue.getUserId() +  "','" + issue.getPeriod() + "')");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Issue issue) {

    }


    public void update(Issue issue) {

    }

    public List<Issue> getList() {
        List<Issue> issues = new ArrayList<Issue>();

        try {
            Statement sqlStmt = dataSource.getConnection().createStatement();
            ResultSet result = sqlStmt.executeQuery("select * from issues");
            while (result.next()) {
                Issue issue = new Issue();
                issue.setBookId(result.getString("bookId"));
                issue.setUserId(result.getString("userId"));
                issue.setPeriod(result.getString("period"));
                issues.add(issue);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return issues;
    }
    public void setList(List<Issue> list) {
        this.list = list;
    }
}
