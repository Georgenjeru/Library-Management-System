package view;

import com.bean.AdminBeanI;
import com.model.Admin;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named("AdminView")
public class AdminView implements Serializable {

    @EJB
    private AdminBeanI adminBean;

    public List<Admin> getList(){
        return adminBean.list();
    }

}
