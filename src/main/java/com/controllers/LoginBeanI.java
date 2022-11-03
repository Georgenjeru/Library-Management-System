package com.controllers;

import com.model.User;
import com.model.Validate;

public interface LoginBeanI {
    User login(Validate validate)throws Exception;

}