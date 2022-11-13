package com.library.test;



import com.bean.RegisterUserBeanI;
import com.model.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class RegisterAction extends HttpServlet {

    @EJB
    RegisterUserBeanI registerUserBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        User user = new User();

        try {
            BeanUtils.populate(user, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            registerUserBean.register(user);
            res.sendRedirect("./login.jsp");

        } catch (Exception ex) {
            servletCtx.setAttribute("registerError", ex.getMessage());
            res.sendRedirect("./register.jsp");
        }

    }
}


        /*String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
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

            servletCtx.setAttribute("registerError" , actionError);
            if (actionError.equals("")) {
                this.insert(email, DigestUtils.md5Hex(password));
                res.sendRedirect("./login.jsp");
            }else
                res.sendRedirect("./register.jsp");
        }

    public void insert(String username, String password) {
        try {
            Connection connection = (Connection) servletCtx.getAttribute("dbConnection");

            Statement sqlStmt = connection.createStatement();
            sqlStmt.executeUpdate("insert into userlogin(username,password) " +
                    "values('" + username+ "','" + password + "')");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
*/