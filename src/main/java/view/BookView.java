package view;

import com.bean.BookBeanI;
import com.model.Book;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("BookView")
public class BookView implements Serializable {

    @EJB
    private BookBeanI bookBean;

    public List<Book> getList() throws Exception {
        return bookBean.getList();
    }

}

