package com.library.test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "")
public class Index extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<style>"
                +" h4 {text-align: center;}"
                + "h6 {text-align: center;}"
                +"</style>"
                + "<body bgcolor=\"Lightskyblue\" style=\"margin: auto; width: 220px;\">"
                + "<script type=\"text/javascript\" src=\"./js/sample.js\"></script>"
                + "<body>"
                + "<head> "
                +  "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                //+ "<h1>" + config.getServletContext().getInitParameter("applicationLabel") + "</h1>"
                + "</head>"
                + " Do Register <a href='./register'>Register</a><br/>"
                + " Do Login <a href='./login'>Login</a><br/>"
                + " Please contactUs <a href='./contactus'>ContactUs</a><br/>"
                + "</body>"
                + "</html>");
    }
}
