package com.eventsListeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class HttpServletSessionListenerSample implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("----HttpSessionListener----sessionCreated invoked----");
        HttpSession session = se.getSession();
        System.out.println("session id: " + session.getId());
        session.setMaxInactiveInterval(5);//in seconds
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("-----HttpSessionListener----sessionDestroyed invoked----");
    }
}

