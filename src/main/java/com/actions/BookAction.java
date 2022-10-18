package com.actions;

import com.controllers.BookController;
import com.model.Book;
import com.mysql.jdbc.Connection;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book")
public class BookAction extends HttpServlet {
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }


    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();

        Book book = new Book();


        try {
            BeanUtils.populate(book, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (StringUtils.isBlank(book.getGenre())) {
            servletCtx.setAttribute("addBookError", "Genre is required<br/>");
            res.sendRedirect("./admin_add.jsp");
            return;
        }

        if (StringUtils.isBlank(book.getTitle())) {
            servletCtx.setAttribute("addBookError", "Title is required<br/>");
            res.sendRedirect("./admin_add.jsp");
            return;
        }
        if (StringUtils.isBlank(book.getAuthor())) {
            servletCtx.setAttribute("addBookError", "Author is required<br/>");
            res.sendRedirect("./admin_add.jsp");
            return;
        }

        BookController bookController = new BookController();
        bookController.add((Connection) servletCtx.getAttribute("dbConnection"), book);

        res.sendRedirect("./home.jsp");


    }
}






