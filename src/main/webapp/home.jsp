<!----------------

<%@ page import="com.model.Admin" %>
<%@ page import="com.model.Book" %>
<%@ page import="com.model.Issue" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>



<cht:Header applicationLabel="${applicationScope.applicationLabel}" />



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
                     List<Admin> admins = adminController.list(new Admin());
                        pageContext.setAttribute("admins", admins);

                  %>
                     <jc:forEach items="${admins}" var="admin">
                            <tr>
                                   <td> ${fn:trim(admin.email)} </td>
                                   <td> ${admin.id} </td>
                                   <td> ${fn:toLowerCase(admin.name)}  </td>
                                   <td><a href="./edit?genre=${book.genre}">Edit</a></td>
                                    <td><a href="./delete?adminId=${admin.id}"}>Delete</a></td>

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
                                    <th>Options</th>
                                 </tr>
                                  <%
                                     List<Book> books = bookController.list(new Book());
                                       pageContext.setAttribute("books", books);

                                  %>
                                   <jc:forEach items="${books}" var="book">
                                      <tr>
                                        <td> ${fn:length(book.genre)} </td>
                                        <td> ${book.title} </td>
                                        <td> ${fn:toUpperCase(book.author)} </td>
                                        <td><a href="./edit?genre=${book.genre}">Edit</a>  | <a href="./delete">Delete</a></td>
                                      </tr>
                                   </jc:forEach>
                              </table>
                           </div>
                    </div>
               </div>

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
                                  <th>Options</th>
                                </tr>
                                  <%
                                    List<Issue> issues = issueController.list(new Issue());
                                        pageContext.setAttribute("issues", issues);

                                  %>
                                   <jc:forEach items="${issues}" var="issue">
                                      <tr>
                                        <td> ${issue.bookId} </td>
                                        <td> ${issue.userId} </td>
                                        <td> ${issue.period} </td>
                                        <td><a href="./edit?genre=${book.genre}">Edit</a>  | <a href="./delete">Delete</a></td>
                                      </tr>
                                   </jc:forEach>
                            </table>
                          </div>
                     </div>
           </div>

<br/>Logout <a href='./logout'>Logout</a><br/>
 <cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved.  </cft:Footer>

 ---------------->
