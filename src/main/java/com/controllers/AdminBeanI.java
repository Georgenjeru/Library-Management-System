package com.controllers;


import com.model.Admin;

import java.util.List;

public interface AdminBeanI {

    void add(Admin admin);
    List<Admin> getList() throws Exception;

    void delete(Admin admin);

    void update(Admin admin);

    Admin getAdmin(Long id);
}

