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

        PrintWriter pw = servletResponse.getWriter();
        pw.print("<html>");
        pw.print("<head>");
        pw.print("<title>Register</title>");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<div class=\"bg-img\">");
        pw.print("<div class=\"content\">");
        pw.print("<header>Please Fill in your the Details </header>");
        pw.print("<form action=\"#\">");
        pw.print("<div class=\"field space\">");
        pw.print("<div class=\"field\">");
        pw.print("<div class=\"field space\">");
        pw.print("<input type=\"text\" required placeholder=\"First Name ...\">");
        pw.print("<div class=\"field space\">");
        pw.print("<input type=\"text\" required placeholder=\"Last Name ...\">");
        pw.print("<div class=\"field space\">");
        pw.print("<input type=\"text\" required placeholder=\"Phone No ...\">");
        pw.print("<div class=\"field space\">");
        pw.print("<input type=\"email\" required placeholder=\"Email\">");
        pw.print("</div>");
        pw.print("<div class=\"field space\">");
        pw.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        pw.print("<div class=\"field space\">");
        pw.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        pw.print("</div>");
        pw.print("</div>");
        pw.print("<div class=\"field\">");
        pw.print("<input type=\"submit\" value=\"SIGNUP\">");
        pw.print("</div>");
        pw.print(" </form>");
        pw.print("</div>");
        pw.print("</div>");
        pw.print("</body>");
        pw.print("</html>");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
