package com.library.test;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/register")
public class Register extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.register(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();
        //String action = req.getParameter("action");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String contactusMessage = req.getParameter("contactusMessage");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        String actionError = "";

            System.out.println("First Name: " + firstName);
            System.out.println("Second Name: " + secondName);
            System.out.println("User Name: " + userName);
            System.out.println("Email: " + email);
            System.out.println("Gender:" + gender);
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
                res.sendRedirect("./login");
            else
                wr.print(this.register(actionError));
        }

        public String register (String actionError){
            return "<!DOCTYPE html>"
                    + " <html>"
                    + "<head>"
                    //+"<h0> Registration Page</h0> "
                    //+" <title>"
                    //+" Registration Page"
                    + "<style>"
                    //+" h1 {text-align: center;}"
                    + "</style>"
                    //+"</title>"
                    + "</head>"
                    + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                    + "<body bgcolor=\"violet\" style=\"margin: auto; width: 220px;\">"
                    + "<form action=\"./register\" method=\"post\">"
                    + "<h3 > NEW USER REGISTRATION</h3>"
                    + "<h4> Please Enter your details to continue.....</h3> "
                    + "<table>"
                    + "<label> Action:</label>  "
                    + "<input type=\"text\" name=\"action\" value=\"register\">"
                    //+"<input type=\\\"text\\\" name=\\\"action\\\" value=\\\"register\\\">>"
                    + "<br>"
                    + "  <label> Firstname </label>"
                    + "<br>"
                    + "<input type=\"text\" name=\"firstname\" placeholder=\"First Name\">"
                    + "<br>"
                    + "<label> Lastname: </label>"
                    + "<br>"
                    + "<input type=\"text\" name=\"lastname\" placeholder=\"Last Name\">"
                    + "<br>"
                    + "<label> UserName: </label>"
                    + "<input type=\"text\" name=\"username\" placeholder=\"Username\">"
                    + "<br>"
                    + "Email:"
                    + "<br> <input type=\"email\" name=\"email\" placeholder =\"Email\"/> <br>"
                    + "<label>"
                    + " Gender :"
                    + "</label><br>"
                    + "<input type=\"checkbox\" name=\"female\"/> Female <br>"
                    + "<input type=\"checkbox\" name=\"male\"/> Male <br>"
                    + "<br>"
                    + " Password:"
                    + "<br> \"<input type=\"password\" name=\"password\"  placeholder=\"Password\"> <br>"
                    + "ConfirmPassword:"
                    + "<input type=\"password\" name=\"confirmPassword\"  placeholder=\"Confirm Password\"> <br>"
                    + "<tr> <td> <input type=\"submit\" value=\"Submit\"></tr> "
                    //+"<input type=\"button\" value=\"Submit\"/><br>"
                    + "</table>"
                    + "</form>"
                    + "<span style=\"color:red\">" + (actionError != null ? actionError : "") + "</span>"
                    + "</body>"
                    + "</html>";
        }
    }