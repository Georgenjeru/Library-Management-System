package com.bean;


import com.model.Admin;

import java.util.List;

public interface AdminBeanI {

    void add(Admin admin);
    List<Admin> getList() throws Exception;

    void delete(Admin admin);

    void update(Admin admin);

    Admin getAdmin(Long id);

    //List<Admin> executeQuery();

    //void executeQuery1();

    void limit();

    void orderBy();

    List<Admin> list();
}

