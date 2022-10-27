package com.archives;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;


public class HttpResponseSample extends HttpServlet {

    ServletConfig config = null;

    /*public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }*/


    @Override
    public void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        String action = servletRequest.getParameter("action");

        String name = servletRequest.getParameter("name");
        System.out.println(name);

        Enumeration<String> enumHeader = servletRequest.getHeaderNames();

        while (enumHeader.hasMoreElements()) {
            String nameHeader = (String) enumHeader.nextElement();
            String valueHeader = servletRequest.getHeader(nameHeader);
            System.out.println("Header Name" + nameHeader + " :" + "and it's value is" + valueHeader);
        }

        int status = servletResponse.getStatus();
        System.out.println("status" + status);
        System.out.println("the header name of the response");

        servletResponse.setIntHeader("Refresh", 15);

         //HttpResponse Methods.
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        System.out.println("committed : " + servletResponse.isCommitted());
        System.out.println("locale : " + servletResponse.getLocale());
        System.out.println("outputStream " + servletResponse.getOutputStream());
        System.out.println("character encoding " + servletResponse.getCharacterEncoding());
        System.out.println("content type  " + servletResponse.getContentType());
        System.out.println("BufferSize ==" + servletResponse.getBufferSize());

        PrintWriter wr = servletResponse.getWriter();

        if (action != null && action.equalsIgnoreCase("register"))
            wr.print(this.register(null));

        else if (action != null && action.equalsIgnoreCase("login"))
            wr.print(this.login(null));
        else if (action != null && action.equalsIgnoreCase("contactus"))
            wr.println(this.contactUs(null));
        else
            wr.print(this.home());

    }


    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

        System.out.println("the parameters are");

        int status = res.getStatus();
        System.out.println("and their status are" + status);
        Enumeration<String>  namesForm = req.getParameterNames();
        while (namesForm.hasMoreElements()){
            String field = namesForm.nextElement();
            System.out.println("Field name :" + field +" the value is : " + req.getParameterValues(field)[0] );

        }
        Map<String, String[]> stringMap = req.getParameterMap();
        for (Map.Entry<String,String[]> map : stringMap.entrySet()){
            if (map.getValue() != null && map.getValue().length > 0)
                System.out.println(map.getKey() + "--" + map.getValue()[0]);
        }

        PrintWriter wr = res.getWriter();
        String action = req.getParameter("action");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("lastName");
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String contactusMessage = req.getParameter("contactusMessage");
        String password = req.getParameter("Password");
        String confirmPassword = req.getParameter("ConfirmPassword");

        boolean register = action != null && action.equalsIgnoreCase("register");
        boolean login = action != null && action.equalsIgnoreCase("login");
        boolean contactus = action != null && action.equalsIgnoreCase("contactUs");
        boolean messageSent = action != null && action.equalsIgnoreCase("messageSent");


        Cookie cookie = new Cookie("cookieSample",userName);
        cookie.setMaxAge(365 * 24 * 60 * 60); // an year
        res.addCookie(cookie);


        String actionError = "";

        if (register){
            System.out.println("First Name: " + firstName);
            System.out.println("Second Name: " + secondName);
            System.out.println("User Name: " + userName);
            System.out.println("Email: " + email);
            System.out.println("Gender:" + gender);
            System.out.println("Password: " + password);
            System.out.println("Confirm Password: " + confirmPassword);

            this.login(actionError);

            if (email == null || email.equalsIgnoreCase(""))
                actionError = "Email is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
                actionError += "Confirm password is required<br/>";

            if (password != null && confirmPassword != null && !password.equals(confirmPassword))
                actionError += "Password & confirm password do not match<br/>";

            if (actionError.equals(""))
                wr.print(this.home());
            else
                wr.print(this.register(actionError));
        } else if (login) {
            System.out.println("userName: " + userName);
            System.out.println("Password: " + password);

            if (userName == null || userName.equalsIgnoreCase(""))
                actionError = "Username is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (password != null && !password.equals("12345"))
                actionError += "Invalid password<br/>";

            if (actionError.equals(""))
                wr.print(this.loggedIn());
            else
                wr.print(this.login(actionError));

        } else if (contactus) {
            System.out.println("contactusMessage " + contactusMessage);
            if (contactusMessage == null || contactusMessage.equalsIgnoreCase(""))
                actionError += "Enter message.<br/>";

            else
                wr.print(this.contactUs(actionError));

        } else if (messageSent) {
            System.out.println("message received.");

        }

    }



    public String home() {
        return "<!DOCTYPE html>"
                + "<html> "
                //+ "<script type=\"text/javascript\" src=\"./js/sample.js\"></script>"
                + "<head> "
                + "<h1> Online Library Management system</h1>"
                + "</head>"
                + "<body>"
                + " To Register <a href='./welcome?action=register'>Register</a><br/>"
                + " To Logging <a href='./welcome?action=login'>Login</a><br/>"
                + " For Help <a href='./welcome?action=contactus'>ContactUs</a><br/>"
                + "</body>"
                + "</html>";

    }

    public String register(String actionError) {
        return "<!DOCTYPE html>"
                + " <html>"
                + "<head>"
                //+"<h0> Registration Page</h0> "
                //+" <title>"
                //+" Registration Page"
                + "<style>"
                //+" h1 {text-align: center;}"
                + "</style>"
                //+"</title>"
                + "</head>"
                + "<body bgcolor=\"violet\" style=\"margin: auto; width: 220px;\">"
                + "<form action=\"./welcome\" method=\"post\">"
                + "<h3 > NEW USER REGISTRATION</h3>"
                + "<h4> Please Enter your details to continue.....</h3> "
                + "<table>"
                + "<label> Action:</label>  "
                + "<input type=\"text\" name=\"action\" value=\"register\">"
                //+"<input type=\\\"text\\\" name=\\\"action\\\" value=\\\"register\\\">>"
                + "<br>"
                + "  <label> Firstname </label>"
                + "<br>"
                + "<input type=\"text\" name=\"firstname\" placeholder=\"First Name\">"
                + "<br>"
                + "<label> Lastname: </label>"
                + "<br>"
                + "<input type=\"text\" name=\"lastname\" placeholder=\"Last Name\">"
                + "<br>"
                + "<label> UserName: </label>"
                + "<input type=\"text\" name=\"username\" placeholder=\"Username\">"
                + "<br>"
                + "Email:"
                + "<br> <input type=\"email\" name=\"email\" placeholder =\"Email\"/> <br>"
                + "<label>"
                + " Gender :"
                + "</label><br>"
                + "<input type=\"checkbox\" name=\"female\"/> Female <br>"
                + "<input type=\"checkbox\" name=\"male\"/> Male <br>"
                + "<br>"
                + " Password:"
                + "<br> \"<input type=\"password\" name=\"password\"  placeholder=\"Password\"> <br>"
                + "ConfirmPassword:"
                + "<input type=\"password\" name=\"confirmPassword\"  placeholder=\"Confirm Password\"> <br>"
                + "<tr> <td> <input type=\"submit\" value=\"Submit\"></tr> "
                //+"<input type=\"button\" value=\"Submit\"/><br>"
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null ? actionError : "") + "</span>"
                + "</body>"
                + "</html>";
                /*"<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<h1> Registration</h1>"
                + "</head>"
                + "<body>"
                + "<form action=\"./welcome\" method=\"post\">"
                + "<table> "
                + "<tr> <td> Action: </td> <td> <input type=\"text\" name=\"action\" value=\"register\"> </td> </tr> "
                + "<tr> <td> Email: </td> <td> <input type=\"text\" name=\"email\"> </td> </tr> "
                + "<tr> <td> Password: </td> <td> <input type=\"Password\" name=\"password\"> </td> </tr> "
                + "<tr> <td> Confirm Password: </td> <td> <input type=\"Password\" name=\"confirmPassword\"> </td> </tr> "
                + "<tr> <td> <input type=\"submit\" value=\"Submit\"></tr> "
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null? actionError : "") + "</span>"
                + "</body>"
                + "</html>";*/
    }

    public String login(String actionError) {
        return "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Login Page</title>"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"/>"
                + "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"/>"
                + "</head>"
                + "<style>"
                + "h2{text-align:center}"
                + "h5{text-align:center}"
                + "import url('https://fonts.googleapis.com/css2?family=Architects+Daughter&family=Chakra+Petch&family=Dongle:wght@300&family=Josefin+Sans:wght@200&family=Luxurious+Roman&family=Mochiy+Pop+P+One&family=Roboto:ital,wght@0,300;1,100;1,300&family=Yanone+Kaffeesatz:wght@300&display=swap');"
                + "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"
                + ".bg-img{background: url('library.jpg');height: 100vh;background-size: cover;background-position: center;}"
                + ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #fcba03;}"
                + ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"
                + ".content header{color: black;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"
                + ".field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}"
                + ".field span{ color: #777;width: 50px;line-height: 45px;}"
                + ".field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}"
                + ".space{margin-top: 16px;}"
                + ".show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}"
                + ".pass-key:valid ~ .show{display: block;}"
                + ".pass{text-align: left;margin: 10px 0;}"
                + ".pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}"
                + ".pass:hover a{text-decoration: underline;}"
                + ".field input[type=\"submit\"]{background: #3498db;border: 1px solid #2691d9;color: white;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}"
                + ".field input[type=\"submit\"]:hover{background: #2691d9;}"
                + ".login{color: red;margin: 20px 0;font-family: 'Poppins',sans-serif;}"
                + ".links{display: flex;cursor: pointer;color: red;margin: 0 0 20px 0;}"
                + ".links i{font-size: 17px;}"
                + "i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}"
                + "</style>"

                + "<body>"
                + "<form action=\"./welcome\" method=\"post\">"
                + "<div class=\"bg-img\">"
                + "<div class=\"content\">"
                + "<header>Library Management System</header>"
                + "<header>Admin/User Login </header>"
                + "<form action=\"#\">"
                + "<div class=\"field\">"
                + "<span class=\"fa fa-user\"></span>"
                + "<input type=\"text\" name=\"username\" placeholder=\"Username/Email\">"
                + "</div>"
                + "<div class=\"field space\">"
                + "<span class=\"fa fa-lock\"></span>"
                + "<input type=\"Password\" name=\"password\" placeholder=\"Password\">"
                + "</div>"
                + "<div class=\"pass\">"
                + "<a href=\"#\">Forgot Password?</a>"
                + "</div>"
                + "<div class=\"field\">"
                + "<input type=\"submit\" value=\"LOGIN\">"
                + "</div>"
                + "</form>"
                + "</div>"
                + "</div>"
                + "<span style=\"color:red\">" + (actionError != null ? actionError : "") + "</span>"
                + "</body>"
                + "</html>";
    }

    public String contactUs(String actionError) {
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<title>Help Page</title>"
                + "</head>"
                + "<style>"
                + "*{color:#ececec; background-color: #142d4c}"
                + "h2{text-align:center}"
                + "h5{text-align:center}"
                + "import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');"
                + "*{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}"
                + ".bg-img{background: url('bg.jpg');height: 100vh;background-size: cover;background-position: center;}"
                + ".bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #FFFF00;}"
                + ".content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}"
                + "tt,.content header{color: white;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}"+
                ".field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}"
                + ".field span{ color: #222;width: 40px;line-height: 45px;}"
                + ".field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}"+
                ".space{margin-top: 16px;}"
                + ".show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}"+
                ".pass-key:valid ~ .show{display: block;}"
                + ".pass{text-align: left;margin: 10px 0;}"
                + ".pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}"
                + ".pass:hover a{text-decoration: underline;}"
                + ".field input[type=\"submit\"]{background: #3498db;border: 1px solid #2691d9;color: grey;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}"
                + ".field input[type=\"submit\"]:hover{background: #2691d9;}"
                + ".login{color: white;margin: 20px 0;font-family: 'Poppins',sans-serif;}"
                + ".links{display: flex;cursor: pointer;color: white;margin: 0 0 20px 0;}"+
                ".links i{font-size: 17px;}"+
                "i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}"+
                "</style>"
                + "<body>"
                +"<div class=\"bg-img\">"
                +"<div class=\"content\">"
                +"<header>Library Help Page</header>"
                + "<form action=\"./project\" method=\"post\">"
                +"<div class=\"field\">"
                +"<input type=\"text\" name=\"action\" value=\"inquiry\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"firstname\" required placeholder=\"First Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"username\" required placeholder=\"User Name\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"email\" required placeholder=\"Email\">"
                +"</div>"
                +"<div class=\"field space\">"
                + "<input type=\"text\" name=\"contactusMessage\" placeholder=\"contactusMessage\">"
                +"</div>"

                +"<div class=\"field space\">"
                + "<tr> <td> <input type=\"submit\" value=\"Send \"></tr> "
                +"</div>"
                + "</form>"
                + "<span style=\"color:yellow\">" + (actionError != null? actionError : "") + "</span>"
                +"</div>"
                +"</div>"
                + "</body>"
                + "</html>";
    }

    public String loggedIn(){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                //+ "<h1> Logged In User: " + username + "</h1>"
                + "</head>"
                + "<body>"
                + "<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>"
                + "</body>"
                + "</html>";
    }
}


