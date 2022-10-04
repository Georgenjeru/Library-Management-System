package com.library.test;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Index extends HttpServlet {

    ServletConfig config = null;

    public void init(ServletConfig config) throws ServletException{
        this.config = config;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<script type=\"text/javascript\" src=\"./js/sample.js\"></script>"
                + "<body>"
                + "<head> "
                + "<h1>" + config.getServletContext().getInitParameter("applicationLabel") + "</h1>"
                + "</head>"
                + " Do Register <a href='./register'>Register</a><br/>"
                + " Do Login <a href='./login'>Login</a><br/>"
                + " Please contactUs <a href='./contactus'>ContactUs</a><br/>"
                + "</body>"
                + "</html>");
    }
}
