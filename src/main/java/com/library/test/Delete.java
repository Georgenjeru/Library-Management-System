package com.library.test;


import com.model.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/delete")
public class Delete extends HttpServlet {

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String userId = req.getParameter("id");
        //int traineeId = Integer.parseInt(req.getParameter("id"));

        System.out.println("userId: " + userId);

        HttpSession session = req.getSession();
        List<Admin> users = (List<Admin>) session.getAttribute("users");

        for (Admin admin: users){
            if (userId.equalsIgnoreCase(admin.getId())) {
                users.remove(admin);
                break;
            }

        }
        res.sendRedirect("./home");
    }
}