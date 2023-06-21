/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 * Provides a connection to the database.
 */
public class ConnectionProvider {
    
    /**
     * Returns a Connection object for the database.
     * @return 
     */
    public static Connection getCon() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false", "root", "Pranay@2006");
            
            return con;
        } catch (Exception e) {
            // Return null in case of an error
            return null;
        }
    }
}
