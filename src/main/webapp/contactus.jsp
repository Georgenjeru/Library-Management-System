<%@ page isELIgnored="false" %>
<jsp:include page = "header.jsp"/>
<form action= "./contactus.jsp" method= "post">
                   <h3 > Contact Us</h3>
                 <table>
                    <br>
                    <label> User Email </label>
                    <br>
                    <input type= "text" name= "userEmail" placeholder= "User Email">
                    <br>
                    <label> User Phone Number: </label>
                    <br>
                    <input type= "text" name= "userPhoneNumber" placeholder= "userPhoneNumber">
                    <br>
                    <tr> <td> Message: </td> <td> <textarea type= "textarea" name= "message" rows="3" cols="45" ></textarea> </td> </tr>
                    <tr> <td> <input type="submit" value="Submit "></td></tr>
                 </table>
              </form>
 <h1> Contact Us Message <h1> <br/>
 <jsp:useBean id = "contactUs" class= "com.model.ContactUs" />
 <jsp:setProperty name = "contactUs" property = "*"/>

 <h3>
    User Email: ${contactUs.userEmail} <br/>
    Phone Number: ${contactUs.userPhoneNo} <br/>
    Contact Message: ${contactUs.contactMessage} <br/>


 <h3>
<jsp:include page = "footer.jsp"/>