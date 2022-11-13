package com.bean;

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
        if (issue == null || StringUtils.isBlank(issue.getBookDetail().getBookId()) || StringUtils.isBlank(issue.getUserId()))
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
        if (StringUtils.isBlank(issue.getBookDetail().getBookId()))
            return;
        if (StringUtils.isBlank(issue.getBookDetail().getBookId()))
        return;

        if (issue.getId() != null)
            System.out.println("Entity manager will update");


        entityManager.merge(issue);

    }
    public List<Issue> getList() {
        return entityManager.createQuery("FROM Issue s", Issue.class).getResultList();

    }
}