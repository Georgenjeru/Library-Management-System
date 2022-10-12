package com.library.test;

import com.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeAction extends HttpServlet {


    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles/app.css\"/>"
                + "</head>"
                + "<body>"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>"
                + "<br/>" + adminGrid((List<Admin>) session.getAttribute("users"))
                + "<br/>Logout <a href='./logout'>Logout</a><br/>"
                + "</body>"
                + "</html>");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getId() == null)
            res.sendRedirect("./");

        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles/app.css\"/>"
                + "</head>"
                + "<body>"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<h2> Welcome: " + session.getAttribute("username") + "  Logged In At: " + session.getAttribute("loggedInTime") + "</h2>"
                + "<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>"
                + "<br/>Logout <a href='./student'>Add User</a><br/>"
                + "<br/>" + adminGrid((List<Admin>) session.getAttribute("users"))
                + "<br/>Logout <a href='./logout'>Logout</a><br/>"
                + "</body>"
                + "</html>");
    }

    public String adminGrid(List<Admin> users) {

        if (users == null)
            users = new ArrayList<Admin>();

        String adminGrid = "<table>"
                + "<tr>"
                + "<th>User Email</th>"
                + "<th>User Identification Number</th>"
                + "<th>User Name</th>"
                + "<th>Edit</th>"
                + "<th>Delete</th>"
                + "</tr>";

        for (Admin admin : users)
            adminGrid += "<tr>"
                    + "<td>" + admin.getEmail() + "</td>"
                    + "<td>" + admin.getId() + "</td>"
                    + "<td>" + admin.getName() + "</td>"
                    + "<td><a href=\"./edit?prevUserId=" +  admin.getId()+ "\">Edit</a></td>"
                    + "<td><a href=\"./delete?id=" +  admin.getId()+ "\">Delete</a></td>"
                    + "</tr>";

        adminGrid += "</table>";
        return adminGrid;

    }
}
