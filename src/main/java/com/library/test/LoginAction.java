package com.library.test;


import com.bean.LoginBeanI;
import com.model.Admin;
import com.model.User;
import com.model.Validate;
import org.apache.commons.beanutils.BeanUtils;


import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    @EJB
    LoginBeanI loginBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    public static List<Admin> adminList;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Validate validate = new Validate();
        try {
            BeanUtils.populate(validate, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            User user = loginBean.login(validate);
            HttpSession session = req.getSession(true);
            session.setAttribute("username", user.getEmail());
            session.setAttribute("loggedInTime", " Logged In At: " + new Date());

            res.sendRedirect("./dashboard.jsp");

        } catch (Exception ex) {
            servletCtx.setAttribute("loginError", ex.getMessage());
            res.sendRedirect("./login.jsp");
        }

    }
}

