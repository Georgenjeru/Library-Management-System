<!DOCTYPE html>
<html>
<body>
                <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
                <h2> Add Book</h2>
                <form action= "./book" method= "post">
                <table>
                <tr> <td> Book Genre: </td> <td> <input type= "text" name="genre"> </td> </tr>
                <tr> <td> Book Title: </td> <td> <input type= "text" name= "title"> </td> </tr>
                <tr> <td> Book Author: </td> <td> <input type= "text" name= "author"> </td> </tr>
                <tr> <td> <input type= "submit" value= "Submit"></tr>
                </table>
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