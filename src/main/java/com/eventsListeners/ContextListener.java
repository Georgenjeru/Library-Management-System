package com.eventsListeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent ctxe){
        System.out.print("Library Application Starting up....initializing default attributes");
        ServletContext ctx = ctxe.getServletContext();
        ctx.setAttribute("applicationLabel", "Online Library Management System");

    }

    public void contextDestroyed(ServletContextEvent ctxe) {
        System.out.print("Library Application stopped.");
    }

}
