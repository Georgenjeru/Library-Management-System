package com.eventsListeners;


import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;


@WebListener
public class ContextListener implements ServletContextListener {

    @Resource(lookup = "java:jboss/datasources/library")
    DataSource dataSource;

    public void contextInitialized(ServletContextEvent ctxe){
        System.out.print("Library Application Starting up....initializing default attributes");
        ServletContext ctx = ctxe.getServletContext();
        ctx.setAttribute("applicationLabel", "Online Library Management System");

        try{
            System.out.println("Looking for Connection..");
            Connection connection = (Connection) dataSource.getConnection();
            ctx.setAttribute("dbConnection",connection);
            System.out.println("Connection Found..");


        }
        catch (Exception ex){
            System.out.println("Connection Not Found" +ex.getMessage());
        }

    }

    public void contextDestroyed(ServletContextEvent ctxe) {
       try{
           ServletContext ctx = ctxe.getServletContext();
           Connection connection = (Connection) ctx.getAttribute("dbConnection");
           connection.close();
       }
       catch (Exception ex){
           System.out.println(ex.getMessage());
       }
    }

}
