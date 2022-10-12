package com.library.test;



import com.model.Admin;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.library.test.LoginAction.adminList;

@WebServlet("/edit")
public class Edit extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        adminList = (List<Admin>) session.getAttribute("users");
        String prevUserId = req.getParameter("prevUserId");
        System.out.println("Id:" +prevUserId);
        for (Admin admin : adminList){
            if(admin.getId()==prevUserId){
                res.getWriter().print(this.editUser(null, admin));
                break;
            }
        }

    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();


        String email = req.getParameter("email");
        String userId = req.getParameter("id");
        String name = req.getParameter("name");
        String prevUserId =req.getParameter("prevUserId");
        HttpSession session = req.getSession();
        adminList = (List<Admin>) session.getAttribute("users");


        //String userId = req.getParameter("id");
        //int traineeId = Integer.parseInt(req.getParameter("id"));

        System.out.println("userId: " + userId);


        for (Admin a: adminList){
            if (prevUserId.equalsIgnoreCase(a.getId())) {
                if (StringUtils.isBlank(name)) {
                    wr.print(this.editUser("Name is required<br/>",a));
                }

                else if (StringUtils.isBlank(email)) {
                    wr.print(this.editUser("Email is required<br/>",a));
                }
                else if (StringUtils.isBlank(userId)) {
                    wr.print(this.editUser("Id is required<br/>",a));
                }
                else {
                    a.setName(name);
                    a.setId(userId);
                    a.setEmail(email);
                    break;
                }
            }

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        dispatcher.forward(req, res);

    }

    public String editUser(String actionError, Admin admin){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "</head>"
                + "<body>"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<h2> Edit User</h2>"
                + "<form action=\"./edit?prevUserId="+admin.getId()+"\" method=\"post\">"
                + "<table> "
                + "<tr> <td> Enter new User Email: </td> <td> <input type=\"text\" name=\"email\"> </td> </tr> "
                + "<tr> <td> Enter new User ID: </td> <td> <input type=\"text\" name=\"id\"> </td> </tr> "
                + "<tr> <td> Enter new User Name: </td> <td> <input type=\"text\" name=\"name\"> </td> </tr> "
                + "<tr> <td> <input type=\"submit\" value=\"Update\"></tr> "
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null? actionError : "") + "</span><br/>"
                + "Home? <a href='./home'>Register</a><br/>"
                + "</body>"
                + "</html>";
    }
}

