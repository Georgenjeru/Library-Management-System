package com.issue;

import com.bean.IssueBeanI;
import com.model.Issue;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/updateAdmin")
public class IssueUpdate extends HttpServlet {
    @EJB
    IssueBeanI issueBean;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();;
        resp.sendRedirect("./updateIssue.jsp.jsp");
    }

    @SuppressWarnings("unchecked")
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Issue issue = new Issue();
        try {
            BeanUtils.populate(issue, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        if (StringUtils.isBlank(issue.getId().toString())) {
            servletCtx.setAttribute("addError","Id is required");
            resp.sendRedirect("./admin_add.jsp");
            return;
        }
        if (StringUtils.isBlank(issue.getBookDetail().getBookId())) {
            servletCtx.setAttribute("addError","Book Id is required");
            resp.sendRedirect("./issue_add.jsp");
            return;
        }

        if (StringUtils.isBlank(issue.getBookDetail().getTitle())) {
            servletCtx.setAttribute("addError","Book Title is required");
            resp.sendRedirect("./issue_add.jsp");
            return;
        }
        if (StringUtils.isBlank(issue.getUserId())) {
            servletCtx.setAttribute("addError","User Id is required");
            resp.sendRedirect("./issue_add.jsp");
            return;
        }
        if (StringUtils.isBlank(issue.getPeriod())) {
            servletCtx.setAttribute("addError", "Period is required");
            resp.sendRedirect("./issue_add.jsp");
            return;
        }

        //adminBean.update(admin);
        issueBean.add(issue);

        resp.sendRedirect("./issue_add.jsp");
    }
}


