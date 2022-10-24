package com.actions;


import com.controllers.IssueController;
import com.model.Issue;
import com.mysql.jdbc.Connection;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/issue")
public class IssueAction extends HttpServlet {
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

        IssueController issueController = new IssueController();
        issueController.add((Connection) servletCtx.getAttribute("dbConnection"), issue);

        res.sendRedirect("./home.jsp");


    }
}






