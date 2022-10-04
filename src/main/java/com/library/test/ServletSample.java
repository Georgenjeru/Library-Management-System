package com.library.test;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletSample extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        PrintWriter wr = res.getWriter();
        if (action != null && action.equalsIgnoreCase("register"))
            wr.print(this.register(null));
        else if (action != null && action.equalsIgnoreCase("login"))
            wr.print(this.login(null));
        else
            wr.print(this.home());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();

        String action = req.getParameter("action");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String username = req.getParameter("username");
        String email = req.getParameter("email");

        boolean register = action != null && action.equalsIgnoreCase("register");
        boolean login = action != null && action.equalsIgnoreCase("login");

        String actionError = "";
        if (register) {
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Confirm Password: " + confirmPassword);

            if (email == null || email.equalsIgnoreCase(""))
                actionError = "Email is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
                actionError += "Confirm password is required<br/>";

            if (password != null && confirmPassword != null && !password.equals(confirmPassword))
                actionError += "Password & confirm password do not match<br/>";

            if (actionError.equals(""))
                wr.print(this.home());
            else
                wr.print(this.register(actionError));

        } else if (login) {
            System.out.println("username: " + username);
            System.out.println("Password: " + password);

            if (username == null || username.equalsIgnoreCase(""))
                actionError = "Username is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (password != null && !password.equals("12345"))
                actionError += "Invalid password<br/>";

            if (actionError.equals(""))
                wr.print(this.loggedIn(username));
            else
                wr.print(this.login(actionError));

        }
    }

    public String home(){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<h1> Library Management system</h1>"
                + "</head>"
                + "<body>"
                + " To Register <a href='./welcome?action=register'>Register</a><br/>"
                + " To Logging <a href='./welcome?action=login'>Login</a><br/>"
                + "</body>"
                + "</html>";
    }

    public String register(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<h1> Registration</h1>"
                + "</head>"
                + "<body>"
                + "<form action=\"./welcome\" method=\"post\">"
                + "<table> "
                + "<tr> <td> Action: </td> <td> <input type=\"text\" name=\"action\" value=\"register\"> </td> </tr> "
                + "<tr> <td> Email: </td> <td> <input type=\"text\" name=\"email\"> </td> </tr> "
                + "<tr> <td> Password: </td> <td> <input type=\"Password\" name=\"password\"> </td> </tr> "
                + "<tr> <td> Confirm Password: </td> <td> <input type=\"Password\" name=\"confirmPassword\"> </td> </tr> "
                + "<tr> <td> <input type=\"submit\" value=\"Submit\"></tr> "
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null? actionError : "") + "</span>"
                + "</body>"
                + "</html>";
    }

    public String login(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<h1> Login</h1>"
                + "</head>"
                + "<body>"
                + "<form action=\"./welcome\" method=\"post\">"
                + "<table> "
                + "<tr> <td> Action: </td> <td> <input type=\"text\" name=\"action\" value=\"login\"> </td> </tr> "
                + "<tr> <td> Email/Username: </td> <td> <input type=\"text\" name=\"username\"> </td> </tr> "
                + "<tr> <td> Password: </td> <td> <input type=\"Password\" name=\"password\"> </td> </tr> "
                + "<tr> <td> <input type=\"submit\" value=\"Submit\"></td> </tr> "
                + "<tr> <td> <input type=\"reset\" value=\"Reset Password\"></tr>"
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null? actionError : "") + "</span>"
                + "</body>"
                + "</html>";
    }

    public String loggedIn(String username){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<h1> Logged In User: " + username + "</h1>"
                + "</head>"
                + "<body>"
                + "<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>"
                + "</body>"
                + "</html>";
    }
}