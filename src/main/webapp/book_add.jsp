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


<h1> BOOKS </h1>
           <br/>Add Books <a href='./book.jsp'>Add Books</a><br/>
               <div class="col-12">
                    <div class="bg-secondary rounded h-100 p-4">
                        <h6 class="mb-4">Bordered Table</h6>
                           <div class="table table-bordered">
                              <table class="table">
                                 <tr>
                                    <th> Id </th>
                                    <th> Book Id </th>
                                    <th>Book Genre</th>
                                    <th>Book Title</th>
                                    <th>Book Author</th>
                                    <th>Options</th>
                                    <th>Book Status</th>
                                 </tr>
                                   <jc:forEach items="${BookView.list}" var="book">
                                      <tr>
                                        <td> ${book.id} </td>
                                        <td> ${book.bookDetail.bookId} </td>
                                        <td> ${fn:length(book.genre)} </td>
                                        <td> ${book.bookDetail.title} </td>
                                        <td> ${fn:toUpperCase(book.author)} </td>
                                        <td><a href="./updateBook.jsp?id=${book.id}">Edit</a> | <a href="./deleteBook?Id=${book.id}"}>Delete</a></td>
                                      </tr>
                                   </jc:forEach>
                              </table>
                           </div>
                    </div>
               </div>

<cft:Footer>&copy; <a href="#">George lms</a>, All Right Reserved. </cft:Footer>