package com.controllers;

import com.model.Issue;

import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



@Stateless
@Remote
public class IssueBean implements IssueBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public void add(Issue issue) {
        if (issue == null || StringUtils.isBlank(issue.getBookId()) || StringUtils.isBlank(issue.getUserId()))
            return;

        entityManager.merge(issue);

    }


    public void delete(Issue issue) {

    }


    public void update(Issue issue) {

    }
    public List<Issue> getList() {
        return entityManager.createQuery("FROM Issue s", Issue.class).getResultList();

    }
}