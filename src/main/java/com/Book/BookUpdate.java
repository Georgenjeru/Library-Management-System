package com.Book;

import com.bean.BookBeanI;
import com.model.Book;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/updateBook")
public class BookUpdate extends HttpServlet {
    @EJB
    BookBeanI bookBean;
    ServletContext servletCtx = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        servletCtx = config.getServletContext();

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();;
        resp.sendRedirect("./updateBook.jsp");
    }

    @SuppressWarnings("unchecked")
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        try {
            BeanUtils.populate(book, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        if (StringUtils.isBlank(book.getId().toString())) {
            servletCtx.setAttribute("addError", "Id is required");
            resp.sendRedirect("./book_add.jsp");
            return;
        }
        if (StringUtils.isBlank(book.getAuthor())) {
            servletCtx.setAttribute("addError", "Book author is required");
            resp.sendRedirect("./book_add.jsp");
            return;
        }

        if (StringUtils.isBlank(book.getGenre())) {
            servletCtx.setAttribute("addError", "Book genre is required");
            resp.sendRedirect("./book_add.jsp");
            return;
        }
        if (StringUtils.isBlank(book.getBookId())) {
            servletCtx.setAttribute("addError", "Book Id is required");
            resp.sendRedirect("./book_add.jsp");
            return;
        }
        if (StringUtils.isBlank(book.getBookDetail().getTitle())) {
            servletCtx.setAttribute("addError", "Book Title is required");
            resp.sendRedirect("./book_add.jsp");
            return;

        }
        bookBean.add(book);
        resp.sendRedirect("./book_add.jsp");
    }
}


