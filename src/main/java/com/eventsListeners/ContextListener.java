package com.eventsListeners;

import com.mysql.jdbc.Connection;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.DriverManager;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent ctxe){
        System.out.print("Library Application Starting up....initializing default attributes");
        ServletContext ctx = ctxe.getServletContext();
        ctx.setAttribute("applicationLabel", "Online Library Management System");

        try{
            System.out.println("Looking for Connection..");
            /*BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/admin");
            dataSource.setUsername("root");
            dataSource.setPassword("George@23");
            Connection connection = (Connection) dataSource.getConnection();
            ctx.setAttribute("dbConnection",connection);*/
            System.out.println("Connection Found..");

            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/admin", "root", "George@23");
            ctx.setAttribute("dbConnection", connection);

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
