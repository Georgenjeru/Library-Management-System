<%@ page import="com.controllers.AdminController" %>
<%@ page import="com.controllers.BookController" %>
<%@ page import="com.model.Admin" %>
<%@ page import="com.model.Book" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mysql.jdbc.Connection" %>
<%! AdminController adminController = new AdminController(); %>
<%! BookController bookController = new BookController(); %>



<!DOCTYPE html>
<html>
<head>
<link rel= "stylesheet" type= "text/css" href= "./styles/app.css"/>
</head>
<body>
<h1><%= application.getAttribute("applicationLabel") %></h1>
<h2> Welcome: <%= session.getAttribute("username") %> Logged In At: <%= session.getAttribute("loggedInTime") %></h2>
<span style= "color:green;font-size: 24px;font-weight:bold">Logged In</span>
<br/>Add User <a href='./admin_add.jsp'>Add User</a><br/>
<h1> Admin </h1>
<table>
<tr>
    <th>User Email</th>
    <th>User Identification Number</th>
    <th>User Name</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
<%
    List<Admin> admins = adminController.list((Connection) application.getAttribute("dbConnection"), new Admin());
    for (Admin admin : admins) {
%>
    <tr>
                 <td><%=  admin.getEmail()  %></td>
                 <td><%=  admin.getId()  %></td>
                 <td><%=  admin.getName()  %></td>
                 <td><a href= "./edit?prevUserId=" +  admin.getId()+ "\">Edit</a></td>
                 <td><a href= "./delete?id=" +  admin.getId()+ "\">Delete</a></td>
    </tr>

<% } %>

</table>

<h1> BOOKS </h1>
<br/>Add Books <a href='./book_add.jsp'>Add Books</a><br/>
<table>
<tr>
    <th>Book Genre</th>
    <th>Book Title</th>
    <th>Book Author</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
<%
    List<Book> books = bookController.list((Connection) application.getAttribute("dbConnection"), new Book());
    for (Book book : books) {
%>
    <tr>
                 <td><%=  book.getGenre()  %></td>
                 <td><%=  book.getTitle()  %></td>
                 <td><%=  book.getAuthor()  %></td>
                 <td><a href= "./edit?prevUserId=" +  admin.getId()+ "\">Edit</a></td>
                 <td><a href= "./delete?id=" +  admin.getId()+ "\">Delete</a></td>
    </tr>

<% } %>

</table>
<br/>Logout <a href='./logout'>Logout</a><br/>
</body>
</html>