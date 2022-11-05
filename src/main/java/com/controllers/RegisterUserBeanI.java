package com.controllers;

import com.model.User;

public interface RegisterUserBeanI {
    User register(User user) throws Exception;
}
