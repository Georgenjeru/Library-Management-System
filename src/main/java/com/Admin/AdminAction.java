package com.Admin;

import com.bean.AdminBeanI;
import com.model.Admin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/student")
public class AdminAction extends HttpServlet {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    AdminBeanI adminBean;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }



    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        Admin admin = new Admin();
        adminBean.executeQuery();

        try {
            BeanUtils.populate(admin, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (StringUtils.isBlank(admin.getName())) {
            servletCtx.setAttribute("addStudentError", "Name is required<br/>");
            res.sendRedirect("./admin_add.jsp");
            return;
        }

        if (StringUtils.isBlank(admin.getEmail())) {
            servletCtx.setAttribute("addStudentError", "Email is required<br/>");
            res.sendRedirect("./admin_add.jsp");
            return;
        }
        if (StringUtils.isBlank(admin.getRegNo())){
            servletCtx.setAttribute("addStudentError", "Reg No is required<br/>");
            res.sendRedirect("./admin_add.jsp");
            return;
        }
        adminBean.add(admin);

        res.sendRedirect("./dashboard.jsp");


    }
}





