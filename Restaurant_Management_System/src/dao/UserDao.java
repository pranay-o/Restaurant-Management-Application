/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 * Data Access Object (DAO) for working with the User model.
 */
public class UserDao {

    /**
     * Saves a user to the database.
     * @param user
     */
    public static void save(User user) {
        String query = "INSERT INTO user (name, email, phoneNumber, address, password, securityQuestion, answer, status) VALUES ('" + user.getName() + "','" + user.getEmail() + "','" + user.getPhoneNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully! Please wait for Admin Approval!");
    }

    /**
     * Performs user login by checking the email and password in the database.
     * @param email
     * @param password
     * @return 
     */
    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    /**
     * Retrieves the security question and answer for a user based on their email.
     * @param email
     * @return    
     */
    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email = '"+email+"'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    /**
     * Updates a user's password in the database.
     * @param email
     * @param newPassword
     */
    public static void update(String email, String newPassword) {
        String query = "UPDATE user SET password = '" + newPassword + "' WHERE email = '" + email + "'";
        DbOperations.setDataOrDelete(query, "Password Changed Successfully");
    }
    
    /**
     * Retrieves all user records from the database based on email.
     * @param email
     * @return 
     */
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email LIKE '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    /**
     * Changes the status of a user in the database.
     * @param email
     * @param status
     */
    public static void changeStatus(String email, String status){
        String query = "UPDATE user SET status ='"+status+"' WHERE email ='"+email+"'";
        DbOperations.setDataOrDelete(query, "Status Changed Successfully");
    }
    
    /**
     * Changes the password of a user in the database.
     * @param email
     * @param oldPassword
     * @param newPassword
     */
    public static void changePassword(String email, String oldPassword, String newPassword) {
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='"+email+"' AND password='"+oldPassword+"'");
            if (rs.next()) {
                update(email, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old Password is Wrong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * Changes the security question and answer of a user in the database.
     * @param email
     * @param password
     * @param securityQuestion
     * @param answer
     */
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM user WHERE email='"+email+"' AND password='"+password+"'");
            if (rs.next()) {
                update(email, securityQuestion, answer);
            } else {
                JOptionPane.showMessageDialog(null, "Password is wrong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * Updates the security question and answer of a user in the database.
     * @param email
     * @param securityQuestion
     * @param answer
     */
    public static void update(String email, String securityQuestion, String answer) {
        String query = "UPDATE user SET securityQuestion='"+securityQuestion+"',answer='"+answer+"' WHERE email='"+email+"'";
        DbOperations.setDataOrDelete(query, "Security Question Changed Successfully");
    }
}
