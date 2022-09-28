package com.library.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet implements Servlet{
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");

        PrintWriter wr = servletResponse.getWriter();
        wr.print("<html>");
        wr.print("<head>");
        wr.print("<title>Register</title>");
        wr.print("</head>");
        wr.print("<body>");
        wr.print("<div class=\"bg-img\">");
        wr.print("<div class=\"content\">");
        wr.print("<header>Signup Form </header>");
        wr.print("<form action=\"#\">");
        wr.print("<div class=\"field space\">");
        wr.print("<div class=\"field\">");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"text\" required placeholder=\"First Name ...\">");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"text\" required placeholder=\"Last Name ...\">");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"text\" required placeholder=\"Phone No ...\">");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"email\" required placeholder=\"Email\">");
        wr.print("</div>");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        wr.print("</div>");
        wr.print("</div>");
        wr.print("<div class=\"field\">");
        wr.print("<input type=\"submit\" value=\"SIGNUP\">");
        wr.print("</div>");
        wr.print(" </form>");
        wr.print("</div>");
        wr.print("</div>");
        wr.print("</body>");
        wr.print("</html>");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
