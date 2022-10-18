<!DOCTYPE html>
<html>
      <head>
      </head>
          <h1><%= application.getAttribute("applicationLabel") %></h1>
          <body bgcolor="violet" style= "margin: auto; width: 220px;">
              <form action= "./register" method= "post">
                   <h3 > NEW USER REGISTRATION</h3>
                   <h4> Please Enter your details to continue.....</h3>
                 <table>
                    <br>
                    <label> Firstname </label>
                    <br>
                    <input type= "text" name= "firstname" placeholder= "First Name">
                    <br>
                    <label> Lastname: </label>
                    <br>
                    <input type= "text" name= "lastname" placeholder= "Last Name">
                    <br>
                    <label> UserName: </label>
                    <input type= "text" name= "username" placeholder= "Username">
                    <br>
                    <label> Email:</label>
                    <br> <input type= "email" name= "email" placeholder = "Email"/> <br>
                    <label>
                    <label> Gender :</label>
                    </label><br>
                    <input type= "checkbox" name= "female"/> Female <br>
                    <input type= "checkbox" name= "male"/> Male <br>
                    <br>
                    <label> Password:</label>
                    <br>
                    <input type= "password" name= "password"  placeholder ="Password"> <br>
                    <label> ConfirmPassword:</label>
                    <input type= "password" name= "confirmPassword "  placeholder= "Confirm Password"> <br>
                    <tr> <td> <input type="submit" value="Submit "></tr>
                 </table>
              </form>
               <%
                          String registerError = (String) application.getAttribute("registerError");
                          if (registerError != null && !registerError.equals("")) {
                      %>
                          <span style="color:red"> <%= application.getAttribute("registerError") %> </span><br/>
                      <% }
               %>

          </body>
</html>