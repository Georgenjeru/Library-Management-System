<%@ page import="com.controllers.BookController" %>
<%@ page import="com.model.Book" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<%@ page isELIgnored="false" %>



<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

<jsp:useBean id = "bookController" class = "com.controllers.BookController"/>

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
                                   <jc:forEach items="${bookController.list}" var="book">
                                      <tr>
                                        <td> ${fn:length(book.genre)} </td>
                                        <td> ${book.title} </td>
                                        <td> ${fn:toUpperCase(book.author)} </td>
                                        <td><a href="./edit?genre=${book.genre}">Edit</a></td>
                                        <td><a href="./deleteBook?Title=${book.title}"}>Delete</a></td>
                                      </tr>
                                   </jc:forEach>
                              </table>
                           </div>
                    </div>
               </div>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" ></cht:Header>
               <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
               <h2> Add Book</h2>
                <form action= "./book" method= "post">
                  <div class="container-fluid pt-4 px-4">
                      <div class="row g-4">
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-secondary rounded h-100 p-4">
                                  <h6 class="mb-4">Books Table</h6>
                             <table class="table">
                                   <tr> <td> Book Genre: </td> <td> <input type= "text" name="genre"> </td> </tr>
                                   <tr> <td> Book Title: </td> <td> <input type= "text" name= "title"> </td> </tr>
                                   <tr> <td> Book Author: </td> <td> <input type= "text" name= "author"> </td> </tr>
                                   <tr> <td> <input type= "submit" value= "Submit"></tr>
                             </table>
                            </div>
                        </div>
                      </div>
                  </div>
                </form>
                <%
                    String loginError = (String) application.getAttribute("addBookError");
                    if (loginError != null && !loginError.equals("")) {
                %>
                    <span style="color:red"> <%= application.getAttribute("addBookError") %> </span><br/>

                <% } %>

                Home? <a href='./dashboard.jsp'>Home</a><br/>
    </body>
</html>