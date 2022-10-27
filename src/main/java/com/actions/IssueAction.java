package com.actions;


import com.controllers.IssueController;
import com.model.Issue;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/issue")
public class IssueAction extends HttpServlet {

    @Inject
    IssueController issueController;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }


    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();
        Issue issue = new Issue();



        try {
            BeanUtils.populate(issue, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (StringUtils.isBlank(issue.getBookId())) {
            servletCtx.setAttribute("addIssueError", "Book ID is required<br/>");
            res.sendRedirect("./issue.jsp");
            return;
        }

        if (StringUtils.isBlank(issue.getUserId())) {
            servletCtx.setAttribute("addIssueError", "User ID required<br/>");
            res.sendRedirect("./issue.jsp");
            return;
        }
        if (StringUtils.isBlank(issue.getPeriod())) {
            servletCtx.setAttribute("addIssueError", "Period required<br/>");
            res.sendRedirect("./issue.jsp");
            return;
        }

        issueController.add(issue);

        res.sendRedirect("./home.jsp");


    }
}






