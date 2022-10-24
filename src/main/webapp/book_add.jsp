<!DOCTYPE html>
<html>
    <body>
              <%@ page isELIgnored="false" %>
              <jsp:include page = "header.jsp"/>
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

                Home? <a href='./home.jsp'>Home</a><br/>
    </body>
</html>