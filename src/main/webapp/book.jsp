<%@ page import="com.model.Book" %>
<%@ page import="com.model.BookStatus" %>
<%@ page import="com.bean.BookBean" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="cht" uri="WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<%@ page isELIgnored="false" %>

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
                                   <tr> <td> Id: </td> <td> <input type= "text" name="id"> </td> </tr>
                                   <tr> <td> Book Id: </td> <td> <input type= "text" name="bookId"> </td> </tr>
                                   <tr> <td> Book Genre: </td> <td> <input type= "text" name="genre"> </td> </tr>
                                   <tr> <td> Book Title: </td> <td> <input type= "text" name= "bookDetail.title"> </td> </tr>
                                   <tr> <td> Book Author: </td> <td> <input type= "text" name= "author"> </td> </tr>
                                   <tr> <td> Book Status: </td> <td> <input type= "text" name= "status"> </td> </tr>
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
<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>