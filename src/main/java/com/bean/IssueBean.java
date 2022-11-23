package com.bean;

import com.model.Admin;
import com.model.Book;
import com.model.Issue;
import org.apache.commons.lang3.StringUtils;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        Issue issue1 = entityManager.find(Issue.class,issue.getId());
        entityManager.remove(issue1);

    }

    public  void update(Issue issue) {
        if (issue == null || StringUtils.isBlank(issue.getUserId()))
            return;
        if (StringUtils.isBlank(issue.getPeriod()))
            return;
        if (StringUtils.isBlank(issue.getBookId()))
            return;
        if (StringUtils.isBlank(issue.getBookId()))
        return;
        /*if (StringUtils.isBlank(issue.getStartDate().toString()))
            return;
        if (StringUtils.isBlank(issue.getEndDate().toString()))
            return;*/

        if (issue.getId() != null)
            System.out.println("Entity manager will update");


        entityManager.merge(issue);

    }
    public List<Issue> getList() {
        return entityManager.createQuery("FROM Issue s", Issue.class).getResultList();

    }
    public List<Admin> getUsersWithBooks() {
        Query query = entityManager.createQuery("SELECT DISTINCT a FROM admins a INNER JOIN a.books b", Issue.class);
        List<Admin> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }
    public List<Admin> pendingBooks() {
        Query query = entityManager.createQuery("SELECT DISTINCT a FROM admins a LEFT JOIN a.books b", Issue.class);
        List<Admin> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }

    public List<Issue> getIssueByBookId(String BookId) {
        try {
            Query query = entityManager.createNamedQuery("Issue.findByBookId", Issue.class);
            query.setParameter("bookId", BookId);
            return (List<Issue>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void orderBy(){
        Query query = entityManager.createQuery("SELECT s FROM issues a ORDER BY s.id DESC");
        List<Issue> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
    public List<Issue> getUnIssuedBooks(String BookId) {
        try {
            Query query = entityManager.createNamedQuery("Issue.findByBookId", Issue.class);
            query.setParameter("bookId", BookId);
            return (List<Issue>) query.getResultList();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Issue> getTotalIssues() {
        Query query = entityManager.createQuery("SELECT DISTINCT a FROM admins a INNER JOIN a.books b", Issue.class);
        List<Issue> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }

}