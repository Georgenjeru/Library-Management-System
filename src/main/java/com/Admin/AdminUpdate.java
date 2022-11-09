package com.Admin;


import com.controllers.AdminBeanI;
import com.model.Admin;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

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



@WebServlet("/updateAdmin")
public class AdminUpdate extends HttpServlet {
    @EJB
    AdminBeanI adminBean;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();;
        resp.sendRedirect("./updateAdmin.jsp");
    }

    @SuppressWarnings("unchecked")
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Admin admin = new Admin();
        try {
            BeanUtils.populate(admin, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        if (StringUtils.isBlank(admin.getId().toString())) {
            servletCtx.setAttribute("addError","Id is required");
            resp.sendRedirect("./admin_add.jsp");
            return;
        }
        if (StringUtils.isBlank(admin.getRegNo())) {
            servletCtx.setAttribute("addError","regNo is required");
            resp.sendRedirect("./admin_add.jsp");
            return;
        }

        if (StringUtils.isBlank(admin.getName())) {
            servletCtx.setAttribute("addError","name is required");
            resp.sendRedirect("./admin_add.jsp");
            return;
        }
        if (StringUtils.isBlank(admin.getEmail())) {
            servletCtx.setAttribute("addError","email is required");
            resp.sendRedirect("./admin_add.jsp");
            return;
        }

        //adminBean.update(admin);
        adminBean.add(admin);

        resp.sendRedirect("./admin_add.jsp");
    }
}

