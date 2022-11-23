<%@ page import="com.model.Issue" %>
<%@ page import="com.bean.IssueBean" %>
<%@ page import="com.model.Book" %>
<%@ page import="com.bean.BookBean" %>
<%@ taglib prefix="cht" uri="./WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="WEB-INF/tlds/footer.tld" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ page isELIgnored="false" %>

<cht:Header applicationLabel="${applicationScope.applicationLabel}" />

<h1> Issue </h1>
           <br/>Issues <a href='./issue_add.jsp'>Request Issues</a><br/>
               <div class="col-12">
                    <div class="bg-secondary rounded h-100 p-4">
                        <h6 class="mb-4">Bordered Table</h6>
                           <div class="table table-bordered">
                              <table class="table">
                                 <tr>
                                    <th> Id </th>
                                    <th>Book ID</th>
                                    <th>Book Title</th>
                                    <th>User ID</th>
                                    <th>Period in Days</th>
                                    <th>Options</th>
                                 </tr>
                                   <jc:forEach items="${IssueView.list}" var="issue">
                                      <tr>
                                        <td> ${issue.id} </td>
                                        <td> ${issue.bookId} </td>
                                        <td> ${issue.title} </td>
                                        <td> ${issue.userId} </td>

                                        <td> ${fn:toUpperCase(issue.period)} </td>
                                        <td><a href="./updateIssue.jsp?id=${issue.id}">Edit</a></td>
                                        <td><a href="./deleteIssue?id=${issue.id}"}>Delete</a></td>
                                      </tr>
                                   </jc:forEach>
                              </table>
                           </div>
                    </div>
               </div>

           <br/>View Total Issues <a href='./totalissues.jsp'>View Total Issues</a><br/>
<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>
