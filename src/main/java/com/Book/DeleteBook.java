package com.Book;

import com.controllers.BookController;
import com.model.Book;

import javax.inject.Inject;
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
    @Inject
    BookController bookController;

    static ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

        this.setBookController(bookController);

    }
    @Inject
    private void setBookController(BookController bookController){
        this.bookController = bookController;
    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Book book = new Book();
        book.setTitle(req.getParameter("Title"));

        bookController.delete(book);
        res.sendRedirect("./book_add.jsp");
    }



}
