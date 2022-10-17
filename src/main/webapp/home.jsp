<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet\" type= "text/css\" href= "./styles/app.css\"/>
</head>
<body>
<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>
<h2> Welcome: " + session.getAttribute("username") + "  Logged In At: " + session.getAttribute("loggedInTime") + "</h2>
<span style=\"color:green;font-size: 24px;font-weight:bold\">Logged In</span>
<br/>Logout <a href='./student'>Add User</a><br/>
<br/>" + adminGrid(new Admin())
<br/>Logout <a href='./logout'>Logout</a><br/>
</body>
</html>