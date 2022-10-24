<!DOCTYPE html>
<html>
<body>
                <%@ page isELIgnored="false" %>
                <jsp:include page = "header.jsp"/>
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
                                               <tr> <td> User ID: </td> <td> <input type= "text" name= "id"> </td> </tr>
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

                Home? <a href='./home.jsp'>Home</a><br/>
                </body>
                </html>