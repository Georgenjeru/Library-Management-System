package com.library.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class can be used to initialize the database connection
public class DatabaseConnection {
    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://127.0.0.1:3306/";
        // Database name to access
        String dbName = "admin";
        String dbUsername = "root";
        String dbPassword = "George@23";
        //Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1.3306/admin", "root", "George@23");
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
}


