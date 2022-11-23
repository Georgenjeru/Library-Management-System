<%@ page import="com.bean.AdminBean" %>
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


<br/>User/Books <a href='./admin.jsp'>User/Books</a><br/>
<h1> Admin </h1>
        <div class="col-sm-12 col-xl-12">
           <div class="bg-secondary rounded h-100 p-4">
                <h6 class="mb-4">Users Table</h6>
                <table class="table table-dark">
                         <tr>
                                <th>User Id</th>
                                <th>User Email</th>
                                <th>User Registration Number</th>
                                <th>User Name</th>
                                <th>Book Id</th>

                         </tr>
                     <jc:forEach items="${adminBean.list}" var="admin">
                            <tr>
                                   <td> ${admin.id} </td>
                                   <td> ${fn:trim(admin.email)} </td>
                                   <td> ${admin.regNo} </td>
                                   <td> ${fn:toLowerCase(admin.name)}  </td>

                             </tr>
                     </jc:forEach>
                </table>
           </div>
        </div>
<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>


