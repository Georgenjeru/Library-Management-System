package com.issue;


import com.bean.IssueBeanI;
import com.model.Issue;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteIssue")
public class DeleteIssue extends HttpServlet {
    @EJB
    IssueBeanI issueBean;

    static ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Issue issue = new Issue();
        issue.setId(Long.valueOf(req.getParameter("id")));

        try {
            issueBean.delete(issue);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        res.sendRedirect("./issue_add.jsp");
    }
}

