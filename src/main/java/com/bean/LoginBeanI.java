package com.bean;

import com.model.User;
import com.model.Validate;

public interface LoginBeanI {
    User login(Validate validate)throws Exception;

    boolean validateMd5(String md5Hash);

}