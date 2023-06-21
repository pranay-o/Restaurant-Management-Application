/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 * Utility class for creating database tables.
 */
public class tables {
    
    public static void main(String[] args){
        try{
            // Create user table
            String userTable = "CREATE TABLE user (id int AUTO_INCREMENT PRIMARY KEY, name varchar(200), email varchar(200), phoneNumber varchar(10), address varchar(200), password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20), UNIQUE (email))";
            
            // Insert admin details
            String adminDetails = "INSERT INTO user (name, email, phoneNumber, address, password, securityQuestion, answer, status) VALUES ('Admin', 'admin@gmail.com', '1234567890', '123 Lane', 'password', 'What is your name?', 'Admin', 'true')";
            
            // Create category table
            String categoryTable = "CREATE TABLE category (id int AUTO_INCREMENT PRIMARY KEY, name varchar(200))";
            
            // Create product table
            String productTable = "CREATE TABLE product (id int AUTO_INCREMENT PRIMARY KEY, name varchar(200), category varchar(200), price varchar(200))";
            
            // Create receipt table
            String receiptTable = "CREATE TABLE receipt (id int PRIMARY KEY, name varchar(200), phoneNumber varchar(200), email varchar(200), date varchar(50), total varchar(200), createdBy varchar(200))";
            
            // Execute SQL statements
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
            DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
            DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully");
            DbOperations.setDataOrDelete(receiptTable, "Receipt Table Created Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
