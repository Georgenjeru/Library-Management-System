<%@ taglib prefix="cht" uri="./WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<%@ page import="com.model.Issue" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page isELIgnored="false" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" ></cht:Header>
             <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
               <h2>Issue Details</h2>
                <form action= "./issue" method= "post">
                  <div class="container-fluid pt-4 px-4">
                      <div class="row g-4">
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-secondary rounded h-100 p-4">
                                  <h6 class="mb-4">Issue Table</h6>
                             <table class="table">
                                   <tr> <td> Book ID: </td> <td> <input type= "text" name="bookId"> </td> </tr>
                                   <tr> <td> Book Title: </td> <td> <input type= "text" name="title"> </td> </tr>
                                   <tr> <td> User ID: </td> <td> <input type= "text" name= "userId"> </td> </tr>
                                   <tr> <td> Period in Days: </td> <td> <input type= "text" name= "period"> </td> </tr>

                                   <tr> <td> <input type= "submit" value= "Submit"></tr>
                             </table>
                            </div>
                        </div>
                      </div>
                  </div>
                </form>
                <%
                    String loginError = (String) application.getAttribute("addIssueError");
                    if (loginError != null && !loginError.equals("")) {
                %>
                    <span style="color:red"> <%= application.getAttribute("addIssueError") %> </span><br/>

                <% } %>

                Home? <a href='./dashboard.jsp'>Home</a><br/>
<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>