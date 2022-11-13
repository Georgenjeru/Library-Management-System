<%@ page import="com.bean.IssueBean" %>
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



<cht:Header applicationLabel="${applicationScope.applicationLabel}" ></cht:Header>

<% Long a = Long.valueOf(Integer.parseInt(request.getParameter("id")));
 pageContext.setAttribute("id", a);
%>
<jc:set var="issue" value = "${issueBean.getIssue(id)}" />



                <h1> <h1><%= application.getAttribute("applicationLabel") %></h1></h1>
                <h2> Update User</h2>

                  <form action= "./updateIssue" method= "post">
                     <div class="container-fluid pt-4 px-4">
                                  <div class="row g-4">
                                      <div class="col-sm-12 col-xl-6">
                                          <div class="bg-secondary rounded h-100 p-4">
                                              <h6 class="mb-4">Issue Table</h6>

                                            <table class="table">
                                               <tr> <td> Book Id: </td> <td> <input type= "text" name="bookId" value="${issue.bookDetail.id}"/> </td> </tr>
                                               <tr> <td> Book Title: </td> <td> <input type= "text" name="title" value="${issue.bookDetail.title}"/> </td> </tr>
                                               <tr> <td> User Id: </td> <td> <input type= "text" name= "userId" value="${issue.userId}"/>  </td> </tr>
                                               <tr> <td> User Name: </td> <td> <input type= "text" name= "period" value="${issue.period}" /> </td> </tr>
                                               <tr> <td> <input type= "submit" value= "Submit"></tr>
                                            </table>
                                          </div>
                                      </div>
                                  </div>
                     </div>

                  </form>

                <%
                    String loginError = (String) application.getAttribute("updateIssueError");
                    if (loginError != null && !loginError.equals("")) {
                %>
                    <span style="color:red"> ${applicationScope.loginError} </span><br/>

                <% } %>