package com.library.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class servletSample implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");

        PrintWriter pr = servletResponse.getWriter();
        pr.print("<html>");
        pr.print("<head>");
        pr.print("<title>Example</title>");
        pr.print("</head>");
        pr.print("<body>");
        pr.print("<p>Welcome to Library Management System </p>");
        pr.println("<p>Admin Login</p>");
        pr.println("<p>Member Login</p>");
        pr.print("</body>");
        pr.print("</html>");


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
