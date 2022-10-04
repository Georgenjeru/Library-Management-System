package com.library.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Home extends HttpServlet {

    ServletConfig config = null;

    public void init(ServletConfig config) throws ServletException{
        this.config = config;
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<String> students = (List<String>) session.getAttribute("students");

        String studentList = "<ul>";

        for (String student : students)
            studentList += "<li>" + student + "</li>";

        studentList += "</ul>";

        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "</head>"
                + "<body>"
                + "<h1>" + config.getServletContext().getInitParameter("applicationLabel") + "</h1>"
                + "<h2> Welcome: " + req.getParameter("username") + "  Logged In At: " + session.getAttribute("loggedInTime") + "</h2>"
                + "<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>"
                + "<br/>" + studentList
                + "<br/>Logout <a href='./'>Login</a><br/>"
                + "</body>"
                + "</html>");
    }
}
