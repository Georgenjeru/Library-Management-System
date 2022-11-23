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
                                    <th>Book ID</th>
                                    <th>Book Title</th>
                                    <th>User ID</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Period in Days</th>
                                    <th>Options</th>
                                 </tr>
                                   <jc:forEach items="${issueBean.getIssueByBookId()}" var="issue">
                                      <tr>
                                        <td> ${issue.id} </td>
                                        <td> ${issue.bookId} </td>
                                        <td> ${issue.bookDetail.title} </td>
                                        <td> ${issue.userId} </td>
                                        <td> ${issue.startDate} </td>
                                        <td> ${issue.endDate} </td>
                                        <td> ${fn:toUpperCase(issue.period)} </td>
                                      </tr>
                                   </jc:forEach>
                              </table>
                           </div>
                    </div>
               </div>
<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>
