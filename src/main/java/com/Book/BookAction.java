package com.Book;

import com.bean.BookBeanI;
import com.model.Book;
import com.model.BookDetail;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/book")
public class BookAction extends HttpServlet {

    @EJB
    BookBeanI bookBean;

    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }


    @SuppressWarnings("unchecked")
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Book book = new Book();

        book.setBookDetail(new BookDetail());


        try {
            BeanUtils.populate(book, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (StringUtils.isBlank(book.getGenre())) {
            servletCtx.setAttribute("addBookError", "Genre is required<br/>");
            res.sendRedirect("./book_add.jsp");
            return;
        }

        if (StringUtils.isBlank(book.getBookDetail().getTitle())) {
            servletCtx.setAttribute("addBookError", "Title is required<br/>");
            res.sendRedirect("./book_add.jsp");
            return;
        }
        if (StringUtils.isBlank(book.getAuthor())) {
            servletCtx.setAttribute("addBookError", "Author is required<br/>");
            res.sendRedirect("./book_add.jsp");
            return;
        }

        bookBean.add(book);

        res.sendRedirect("./dashboard.jsp");


    }
}





