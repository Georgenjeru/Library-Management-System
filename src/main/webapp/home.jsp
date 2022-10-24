<%@ page import="com.controllers.AdminController" %>
<%@ page import="com.controllers.BookController" %>
<%@ page import="com.controllers.IssueController" %>
<%@ page import="com.model.Admin" %>
<%@ page import="com.model.Book" %>
<%@ page import="com.model.Issue" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mysql.jdbc.Connection" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>


<jsp:useBean id = "adminController" class = "com.controllers.AdminController"/>
<jsp:useBean id = "bookController" class = "com.controllers.BookController"/>
<jsp:useBean id = "issueController" class = "com.controllers.IssueController"/>


<jsp:include page = "header.jsp"/>
<%@ page isELIgnored="false" %>
<jsp:include page = "dashboard.jsp"/>


<body>
<h3> Welcome: ${sessionScope.username} Logged In At: ${sessionScope.loggedInTime}</h3>
<span style= "color:green;font-size: 24px;font-weight:bold">Logged In</span>

<br/>Add User <a href='./admin_add.jsp'>Add User</a><br/>
<h1> Admin </h1>
        <div class="col-sm-12 col-xl-12">
           <div class="bg-secondary rounded h-100 p-4">
                <h6 class="mb-4">Users Table</h6>
                <table class="table table-dark">
                               <tr>
                                <th>User Email</th>
                                <th>User Identification Number</th>
                                <th>User Name</th>
                                <th>Options</th>

                               </tr>

                  <%
                    List<Admin> admins = adminController.list((Connection) application.getAttribute("dbConnection"), new Admin());
                    pageContext.setAttribute("admins", admins);
                  %>
                     <jc:forEach items="${admins}" var="admins">
                            <tr>
                                   <td> ${admin.email} </td>
                                   <td> ${admin.Id} </td>
                                   <td> ${admin.name}  </td>
                                   <td><a href="./edit?genre=${book.genre}">Edit</a>  | <a href="./delete">Delete</a></td>

                             </tr>
                     </jc:forEach>
                </table>
           </div>
        </div>

<h1> BOOKS </h1>
<br/>Add Books <a href='./book_add.jsp'>Add Books</a><br/>
<div class="col-12">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">Bordered Table</h6>
                            <div class="table table-bordered">
                                <table class="table">
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
                 <td><a href="./edit?genre=${book.genre}">Edit</a>  | <a href="./delete">Delete</a></td>


    </tr>

<% } %>
</table>

<h1> ISSUE </h1>
<br/>Add Issue details <a href='./issue.jsp'>Issue Details</a><br/>
<div class="col-12">
                        <div class="bg-secondary rounded h-100 p-4">
                            <h6 class="mb-4">Bordered Table</h6>
                            <div class="table table-dark">
                                <table class="table">
<tr>
    <th>Book Id</th>
    <th>User Id</th>
    <th>Period</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>
<%
    List<Issue> issues = issueController.list((Connection) application.getAttribute("dbConnection"), new Issue());
       for (Issue issue : issues) {
%>
    <tr>
                 <td><%=  issue.getBookId()  %></td>
                 <td><%=  issue.getUserId()  %></td>
                 <td><%=  issue.getPeriod()  %></td>
                 <td><a href="./edit?bookId=${issue.bookId}">Edit</a>  | <a href="./delete">Delete</a></td>
    </tr>

<% } %>
</table>

<br/>Logout <a href='./logout'>Logout</a><br/>
</body>
</html>