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

        PrintWriter wr = servletResponse.getWriter();
        wr.print("<html lang=\"en\" dir=\"ltr\">");
        wr.print("<head>");
        wr.print("<title>TMS - Login Page</title>");
        wr.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>");
        wr.print("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/>");
        wr.print("</head>");

        wr.print("<style>");
        wr.print("h2{text-align:center}");
        wr.print("h5{text-align:center}");
        wr.print("import url('https://fonts.googleapis.com/css2?family=Architects+Daughter&family=Chakra+Petch&family=Dongle:wght@300&family=Josefin+Sans:wght@200&family=Luxurious+Roman&family=Mochiy+Pop+P+One&family=Roboto:ital,wght@0,300;1,100;1,300&family=Yanone+Kaffeesatz:wght@300&display=swap');");
        wr.print("*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}");
        wr.print(".bg-img{background: url('paper.gif');height: 100vh;background-size: cover;background-position: center;}");
        wr.print(".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #fcba03;}");
        wr.print(".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}");
        wr.print(".content header{color: black;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}");
        wr.print(".field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}");
        wr.print(".field span{ color: #777;width: 50px;line-height: 45px;}");
        wr.print(".field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}");
        wr.print(".space{margin-top: 16px;}");
        wr.print(".show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}");
        wr.print(".pass-key:valid ~ .show{display: block;}");
        wr.print(".pass{text-align: left;margin: 10px 0;}");
        wr.print(".pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}");
        wr.print(".pass:hover a{text-decoration: underline;}");
        wr.print(".field input[type=\"submit\"]{background: #3498db;border: 1px solid #2691d9;color: white;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}");
        wr.print(".field input[type=\"submit\"]:hover{background: #2691d9;}");
        wr.print(".login{color: red;margin: 20px 0;font-family: 'Poppins',sans-serif;}");
        wr.print(".links{display: flex;cursor: pointer;color: red;margin: 0 0 20px 0;}");
        wr.print(".links i{font-size: 17px;}");
        wr.print("i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}");
        wr.print("</style>");

        wr.print("<body>");
        wr.print("<div class=\"bg-img\">");
        wr.print("<div class=\"content\">");
        wr.print("<header>Library Management System</header>");
        wr.print("<header>Admin/User Login </header>");
        wr.print("<form action=\"#\">");
        wr.print("<div class=\"field\">");
        wr.print("<span class=\"fa fa-user\"></span>");
        wr.print("<input type=\"text\" required placeholder=\"Email Address\">");
        wr.print("</div>");
        wr.print("<div class=\"field space\">");
        wr.print("<span class=\"fa fa-lock\"></span>");
        wr.print("<input type=\"password\" class=\"pass-key\" required placeholder=\"Password\">");
        wr.print("</div>");
        wr.print("<div class=\"pass\">");
        wr.print("<a href=\"#\">Forgot Password?</a>");
        wr.print("</div>");
        wr.print("<div class=\"field\">");
        wr.print("<input type=\"submit\" value=\"LOGIN\">");
        wr.print("</div>");
        wr.print("</form>");
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