<%@ page import="com.bean.AdminBean" %>
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
<%@ page isELIgnored="false" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" ></cht:Header>
                <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
                <h2> Add User</h2>

                  <form action= "./student" method= "post">
                     <div class="container-fluid pt-4 px-4">
                                  <div class="row g-4">
                                      <div class="col-sm-12 col-xl-6">
                                          <div class="bg-secondary rounded h-100 p-4">
                                              <h6 class="mb-4">User Table</h6>
                                            <table class="table">
                                               <tr> <td> User Id: </td> <td> <input type= "text" name="id"> </td> </tr>
                                               <tr> <td> User Email: </td> <td> <input type= "text" name="email"> </td> </tr>
                                               <tr> <td> User Registration No: </td> <td> <input type= "text" name= "regNo"> </td> </tr>
                                               <tr> <td> User Name: </td> <td> <input type= "text" name= "name"> </td> </tr>
                                               <tr> <td> <input type= "submit" value= "Submit"></tr>
                                            </table>
                                          </div>
                                      </div>
                                  </div>
                     </div>

                  </form>

                <%
                    String loginError = (String) application.getAttribute("addAdminError");
                    if (loginError != null && !loginError.equals("")) {
                %>
                    <span style="color:red"> ${applicationScope.loginError} </span><br/>

                <% } %>

                Home? <a href='./dashboard.jsp'>Home</a><br/>
<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>