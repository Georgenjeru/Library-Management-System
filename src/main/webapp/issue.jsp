<!DOCTYPE html>
<html>
    <body>
              <%@ page isELIgnored="false" %>
              <jsp:include page = "header.jsp"/>
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

                Home? <a href='./home.jsp'>Home</a><br/>
    </body>
</html>