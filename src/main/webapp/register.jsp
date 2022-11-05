<%@ taglib prefix="cht" uri="./WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

          <body bgcolor="violet" style= "margin: auto; width: 220px;">
              <form action= "./register" method= "post">
                   <h3 > NEW USER REGISTRATION</h3>
                   <h4> Please Enter your details to continue.....</h3>
                 <table>
                    <br>
                    <label> Firstname </label>
                    <br>
                    <input type= "text" name= "firstName" placeholder= "First Name">
                    <br>
                    <label> Lastname: </label>
                    <br>
                    <input type= "text" name= "lastName" placeholder= "Last Name">
                    <br>
                    <label> Email:</label>
                    <br> <input type= "email" name= "email" placeholder = "Email"/> <br>
                    <label>

                    <label> Password:</label>
                    <br>
                    <input type= "password" name= "password"  placeholder ="Password"> <br>
                    <label> ConfirmPassword:</label>
                    <input type= "password" name= "confirmPassword"  placeholder= "Confirm Password"> <br>
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