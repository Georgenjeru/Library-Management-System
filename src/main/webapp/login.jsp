<!DOCTYPE html>
<html>
    <head>
     <title>Login Page</title>
        <link rel= "stylesheet" type= "text/css" href= "style.css"/>
        <link rel= "stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    </head>
    <style>
         h4 {text-align: center;}
         h6 {text-align: center;}
         import url('https://fonts.googleapis.com/css2?family=Architects+Daughter&family=Chakra+Petch&family=Dongle:wght@300&family=Josefin+Sans:wght@200&family=Luxurious+Roman&family=Mochiy+Pop+P+One&family=Roboto:ital,wght@0,300;1,100;1,300&family=Yanone+Kaffeesatz:wght@300&display=swap');}
         *{margin: 0;padding: 0;box-sizing: border-box;user-select: none;}
         .bg-img{background: url('library.jpg');height: 100vh;background-size: cover;background-position: center;}
         .bg-img:after{position: absolute;content: '';top: 0;left: 0;height: 100%;width: 100%;background-color: #fcba03;}
         .content{position: absolute;top: 50%;left: 50%; z-index: 999; text-align: center; padding: 60px 32px;width: 370px;transform: translate(-50%,-50%); background: rgba(255,255,255,0.04);box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);}
         .content header{color: black;font-size: 33px;font-weight: 600;margin: 0 0 35px 0;font-family: 'Montserrat',sans-serif;}
         .field{position: relative;height: 45px;width: 100%;display: flex;background: rgba(255,255,255,0.94);}
         .field span{ color: #777;width: 50px;line-height: 45px;}
         .field input{height: 100%; width: 100%;background: transparent; border: none;outline: none; color: #222;font-size: 16px; font-family: 'Poppins',sans-serif;}
         .space{margin-top: 16px;}
         .show{position: absolute;right: 13px;font-size: 13px;font-weight: 700;color: #222;display: none;cursor: pointer;font-family: 'Montserrat',sans-serif;}
         .pass-key:valid ~ .show{display: block;}
         .pass{text-align: left;margin: 10px 0;}
         .pass a{color: white;text-decoration: none;font-family: 'Poppins',sans-serif;}
         .pass:hover a{text-decoration: underline;}
         .field input[type= "submit"]{background: #3498db;border: 1px solid #2691d9;color: white;font-size: 18px;letter-spacing: 1px;font-weight: 600;cursor: pointer;font-family: 'Montserrat',sans-serif;}
         .field input[type= "submit"]:hover{background: #2691d9;}
         .login{color: red;margin: 20px 0;font-family: 'Poppins',sans-serif;}
         .links{display: flex;cursor: pointer;color: red;margin: 0 0 20px 0;}
         .links i{font-size: 17px;}
         i span{margin-left: 8px;font-weight: 500;letter-spacing: 1px;font-size: 16px;font-family: 'Poppins',sans-serif;}
    </style>

    <body>
           <h1><%= application.getAttribute("applicationLabel") %></h1>
        <form action= "./login" method= "post">
            <div class= "bg-img">
            <div class= "content">
            <header>Library Management System</header>
            <header>Admin/User Login </header>
            <form action= "#">
            <div class= "field">
            <span class= "fa fa-user"></span>
            <input type= "text" name= "username" placeholder= "Username/Email">
            </div>
            <div class= "field space">
            <span class= "fa fa-lock"></span>
            <input type= "Password" name= "password" placeholder= "Password">
            </div>
            <div class= "pass">
            <a href= "#">Forgot Password?</a>
            </div>
            <div class= "field">
            <input type= "submit" value= "LOGIN">
            </div>
        </form>
        <%
               String loginError = (String) application.getAttribute("loginError");
               if (loginError != null && !loginError.equals("")) {
        %>
               <span style="color:red"> <%= application.getAttribute("loginError") %> </span><br/>

        <% } %>
         </div>
         </div>
         Register? <a href='./register.jsp'>Register</a><br/>
    </body>
</html>