package com.Book;

import com.bean.BookBeanI;
import com.model.Book;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
    @EJB
    BookBeanI bookBean;

    static ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Book book = new Book();
        book.setId(Long.valueOf(req.getParameter("Id")));

        bookBean.delete(book);
        res.sendRedirect("./book_add.jsp");
    }


}