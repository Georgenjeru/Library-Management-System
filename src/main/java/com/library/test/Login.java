package com.library.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Login implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");

        PrintWriter wr = servletResponse.getWriter();
        wr.print("<html lang=\"en\" dir=\"ltr\">");
        wr.print("<head>");
        wr.print("<title>TMS - Login Page</title>");
        wr.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>");
        wr.print("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/>");
        wr.print("</head>");
        wr.print("<body>");
        wr.print("<div class=\"bg-img\">");
        wr.print("<div class=\"content\">");
        wr.print("<header>Login Form </header>");
        wr.print("<form action=\"#\">");
        wr.print("<div class=\"field space\">");
        wr.print("<div class=\"field\">");
        wr.print("<span class=\"fa fa-user\"></span>");
        wr.print("<input type=\"text\" required placeholder=\"Email or Phone\">");
        wr.print("<div class=\"field space\">");

        wr.print("</div>");
        wr.print("<div class=\"field space\">");
        wr.print("<span class=\"fa fa-lock\"></span>");
        wr.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        wr.print("</div>");
        wr.print("<div class=\"pass\">");
        wr.print("<a href=\"#\">Forgot Password?</a>");
        wr.print("</div>");
        wr.print("<div class=\"field\">");
        wr.print("<div class=\"field space\">");
        wr.print("<input type=\"submit\" value=\"LOGIN\">");
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
