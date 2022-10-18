package com.library.test;

import com.model.Admin;
import com.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }
    public static List<Admin> adminList;
    /*public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.login(null));
    }*/

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
            servletCtx.setAttribute("loginError" , "Password is username & password combination<br/>");
            res.sendRedirect("./login.jsp");
            return;
        }

        /*if (username == null || username.equalsIgnoreCase("")) {
            wr.print(this.login("Username is required<br/>"));
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.login("Password is required<br/>"));
            return;
        }

        if (!username.equals(getServletConfig().getInitParameter("username")) && !password.equals(getServletConfig().getInitParameter("password"))) {
            wr.print(this.login("Invalid username & password combination<br/>"));
            return;
        }
        /*User user = this.login(username, DigestUtils.md5Hex(password));
        if (user == null || user.getId() == null) {
            wr.print(this.login("Invalid username & password combination<br/>"));
            return;
        }*/

        HttpSession session = req.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("loggedInTime", "Logged In Time:" + new Date());

        res.sendRedirect("./home.jsp");
        //RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        //dispatcher.forward(req, res);

    }
    public User login(String username, String password) {

        User user = null;

        try {
            Connection connection = (Connection) servletCtx.getAttribute("dbConnection");
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from userlogin where username='" + username + "' and " +
                    "password='" + password + "'");
            while (result.next()) {
                user = new User();
                user.setId((long) result.getInt("id"));
                user.setUsername(result.getString("username"));
            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return user;

    }
}

