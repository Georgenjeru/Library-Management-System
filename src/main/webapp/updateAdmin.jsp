<%@ page import="com.controllers.AdminBean" %>
<%@ page import="com.model.Admin" %>
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

<% Long a = Long.valueOf(Integer.parseInt(request.getParameter("id")));
 pageContext.setAttribute("id", a);
%>
<jc:set var="admin" value = "${adminBean.getAdmin(id)}" />



                <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
                <h2> Update User</h2>

                  <form action= "./updateAdmin" method= "post">
                     <div class="container-fluid pt-4 px-4">
                                  <div class="row g-4">
                                      <div class="col-sm-12 col-xl-6">
                                          <div class="bg-secondary rounded h-100 p-4">
                                              <h6 class="mb-4">User Table</h6>

                                            <table class="table">
                                               <tr> <td> User Id: </td> <td> <input type= "text" name="id" value="${admin.id}"/> </td> </tr>
                                               <tr> <td> User Email: </td> <td> <input type= "text" name="email" value="${admin.email}"/> </td> </tr>
                                               <tr> <td> User Registration No: </td> <td> <input type= "text" name= "regNo" value="${admin.regNo}"/>  </td> </tr>
                                               <tr> <td> User Name: </td> <td> <input type= "text" name= "name" value="${admin.name}" /> </td> </tr>
                                               <tr> <td> <input type= "submit" value= "Submit"></tr>
                                            </table>
                                          </div>
                                      </div>
                                  </div>
                     </div>

                  </form>

                <%
                    String loginError = (String) application.getAttribute("updateAdminError");
                    if (loginError != null && !loginError.equals("")) {
                %>
                    <span style="color:red"> ${applicationScope.loginError} </span><br/>

                <% } %>