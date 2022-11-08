package com.Admin;

import com.controllers.AdminBeanI;
import com.model.Admin;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteAdmin")
public class DeleteAdmin extends HttpServlet {
    @EJB
    AdminBeanI adminBean;

    static ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Admin admin = new Admin();
        admin.setId(Long.valueOf(req.getParameter("id")));

        try {
            adminBean.delete(admin);
        }catch(Exception e){
                throw new RuntimeException(e);
        }
            res.sendRedirect("./admin_add.jsp");
        }
    }
