<%@ page import="com.controllers.AdminBean" %>
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



<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

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
                                <th>User Registration Number</th>
                                <th>User Name</th>
                                <th>Options</th>

                         </tr>
                     <jc:forEach items="${adminBean.list}" var="admin">
                            <tr>
                                   <td> ${fn:trim(admin.email)} </td>
                                   <td> ${admin.regNo} </td>
                                   <td> ${fn:toLowerCase(admin.name)}  </td>
                                   <td><a href="./edit?genre=${book.genre}">Edit</a></td>
                                    <td><a href="./deleteAdmin?Id=${admin.id}"}>Delete</a></td>

                             </tr>
                     </jc:forEach>
                </table>
           </div>
        </div>

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
                </body>
                </html>

