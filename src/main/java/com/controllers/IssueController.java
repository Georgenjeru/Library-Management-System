package com.controllers;


import com.model.Issue;
import com.mysql.jdbc.Connection;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IssueController implements Serializable {
    public void add(Connection connection, Issue issue) {
        if (issue == null || StringUtils.isBlank(issue.getBookId()) || StringUtils.isBlank(issue.getUserId()))
            return;

        try {

            Statement sqlStmt = connection.createStatement();
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

    public List<Issue> list(Connection connection, Issue filter) {
        List<Issue> issues = new ArrayList<Issue>();

        try {
            Statement sqlStmt = connection.createStatement();

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
}
