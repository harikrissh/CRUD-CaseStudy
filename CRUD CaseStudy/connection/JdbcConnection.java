package com.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection con;

    public static Connection getConnection() throws ClassNotFoundException {
    	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "12345");
        } catch (SQLException ex) {
        	System.out.println("Failed to create the database connection."); 
        }
        return con;
    }
}