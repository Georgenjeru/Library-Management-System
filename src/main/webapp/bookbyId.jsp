<%@ page import="com.model.Book" %>
<%@ page import="com.bean.BookBean" %>
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


<h1>Books by Id </h1>
               <div class="col-12">
                    <div class="bg-secondary rounded h-100 p-4">
                        <h6 class="mb-4">Books Table</h6>
                           <div class="table table-bordered">
                              <table class="table">
                                 <tr>
                                    <th> Id </th>
                                    <th> Book Id </th>
                                    <th>Book Genre</th>
                                    <th>Book Title</th>
                                    <th>Book Author</th>
                                 </tr>
                                   <jc:forEach items="${issueBean.getIssueByBookId}" var="book">
                                      <tr>
                                        <td> ${book.id} </td>
                                        <td> ${book.bookId} </td>
                                        <td> ${fn:length(book.genre)} </td>
                                        <td> ${book.bookDetail.title} </td>
                                        <td> ${fn:toUpperCase(book.author)} </td>
                                      </tr>
                                   </jc:forEach>
                              </table>
                           </div>
                    </div>
               </div>

           Home? <a href='./dashboard.jsp'>Home</a><br/>

<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>