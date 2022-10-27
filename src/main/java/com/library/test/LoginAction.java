package com.library.test;

import com.controllers.LoginController;
import com.model.Admin;
import com.model.User;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    @Inject
    LoginController loginController;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }
    public static List<Admin> adminList;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();


        String password = req.getParameter("password");
        String username = req.getParameter("username");

        if (username == null || username.equalsIgnoreCase("")) {
            servletCtx.setAttribute("loginError" , "Username is required<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            servletCtx.setAttribute("loginError" , "Password is required<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }

        /*User user = this.login(username, password);
        if (user == null || user.getId() == null) {
            servletCtx.setAttribute("loginError" , "Incorrect Password<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }
        User user = this.login(username, DigestUtils.md5Hex(password));
        if (user == null || user.getId() == null) {
            servletCtx.setAttribute("loginError" , "Incorrect Password<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }
        User user = loginController.login(username, password);
        if (user == null || user.getId() == null) {
            servletCtx.setAttribute("loginError" , "Incorrect Password<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }*/

        HttpSession session = req.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("loggedInTime", "Logged In Time:" + new Date());

        res.sendRedirect("./home.jsp");

    }

}

