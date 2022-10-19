<!DOCTYPE html>
<html>
<body>
                <%@ page isELIgnored="false" %>
                <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
                <h2> Add User</h2>
                <form action= "./student" method= "post">
                <table>
                <tr> <td> User Email: </td> <td> <input type= "text" name="email"> </td> </tr>
                <tr> <td> User ID: </td> <td> <input type= "text" name= "id"> </td> </tr>
                <tr> <td> User Name: </td> <td> <input type= "text" name= "name"> </td> </tr>
                <tr> <td> <input type= "submit" value= "Submit"></tr>
                </table>
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