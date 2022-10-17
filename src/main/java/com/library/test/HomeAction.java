package com.library.test;

import com.model.Admin;
import com.mysql.jdbc.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeAction extends HttpServlet {
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        servletCtx = config.getServletContext();

    }


    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().print("<!DOCTYPE html>"
                + "<html> "
                + "<head>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"./styles/app.css\"/>"
                + "</head>"
                + "<body>"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>"
                + "<br/>" + adminGrid(new Admin())
                + "<br/>Logout <a href='./logout'>Logout</a><br/>"
                + "</body>"
                + "</html>");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
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
                + "<br/>" + adminGrid(new Admin())
                + "<br/>Logout <a href='./logout'>Logout</a><br/>"
                + "</body>"
                + "</html>");
    }

    public String adminGrid(Admin adminfilter) {

        List<Admin>admins = new ArrayList<Admin>();

        try {
            Connection connection = (Connection) servletCtx.getAttribute ("dbConnection");
            Statement sqlStmt = connection.createStatement();

            ResultSet result = sqlStmt.executeQuery("select * from users");
            while (result.next()) {
                Admin admin = new Admin();
                admin.setId(result.getString("Id"));
                admin.setName(result.getString("name"));
                admin.setEmail(result.getString("Email"));
                admins.add(admin);
            }

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        String adminGrid = "<table>"
                + "<tr>"
                + "<th>User Email</th>"
                + "<th>User Identification Number</th>"
                + "<th>User Name</th>"
                + "<th>Edit</th>"
                + "<th>Delete</th>"
                + "</tr>";

        for (Admin admin : admins)
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
