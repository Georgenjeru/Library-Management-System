package com.library.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");

        PrintWriter pw = servletResponse.getWriter();
        pw.print("<html lang=\"en\" dir=\"ltr\">");
        pw.print("<head>");
        pw.print("<title>TMS - Login Page</title>");
        pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>");
        pw.print("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/>");
        pw.print("</head>");

        pw.print("<style>");
        pw.print("h2{text-align:center}");
        pw.print("h5{text-align:center}");
        pw.print("import url('https://fonts.googleapis.com/css2?family=Architects+Daughter&family=Chakra+Petch&family=Dongle:wght@300&family=Josefin+Sans:wght@200&family=Luxurious+Roman&family=Mochiy+Pop+P+One&family=Roboto:ital,wght@0,300;1,100;1,300&family=Yanone+Kaffeesatz:wght@300&display=swap');");
        pw.print("*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}");
        pw.print(".bg-img{background: url('library.jpg');height: 100vh;background-size: cover;background-position: center;}");
        pw.print(".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #fcba03;}");
        pw.print(".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}");
        pw.print(".content header{color: black;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}");
        pw.print(".field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}");
        pw.print(".field span{ color: #777;width: 50px;line-height: 45px;}");
        pw.print(".field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}");
        pw.print(".space{margin-top: 16px;}");
        pw.print(".show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}");
        pw.print(".pass-key:valid ~ .show{display: block;}");
        pw.print(".pass{text-align: left;margin: 10px 0;}");
        pw.print(".pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}");
        pw.print(".pass:hover a{text-decoration: underline;}");
        pw.print(".field input[type=\"submit\"]{background: #3498db;border: 1px solid #2691d9;color: white;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}");
        pw.print(".field input[type=\"submit\"]:hover{background: #2691d9;}");
        pw.print(".login{color: red;margin: 20px 0;font-family: 'Poppins',sans-serif;}");
        pw.print(".links{display: flex;cursor: pointer;color: red;margin: 0 0 20px 0;}");
        pw.print(".links i{font-size: 17px;}");
        pw.print("i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}");
        pw.print("</style>");

        pw.print("<body>");
        pw.print("<div class=\"bg-img\">");
        pw.print("<div class=\"content\">");
        pw.print("<header>Library Management System</header>");
        pw.print("<header>Admin/User Login </header>");
        pw.print("<form action=\"#\">");
        pw.print("<div class=\"field\">");
        pw.print("<span class=\"fa fa-user\"></span>");
        pw.print("<input type=\"text\" required placeholder=\"Email Address\">");
        pw.print("</div>");
        pw.print("<div class=\"field space\">");
        pw.print("<span class=\"fa fa-lock\"></span>");
        pw.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        pw.print("</div>");
        pw.print("<div class=\"pass\">");
        pw.print("<a href=\"#\">Forgot Password?</a>");
        pw.print("</div>");
        pw.print("<div class=\"field\">");
        pw.print("<input type=\"submit\" value=\"LOGIN\">");
        pw.print("</div>");
        pw.print("</form>");
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