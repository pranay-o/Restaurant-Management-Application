/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Receipt;

/**
 * Data Access Object (DAO) for managing Receipt data in the database.
 */
public class ReceiptDao {
    
    /**
     * Retrieves the next available id for a receipt.
     * @return 
     */
    public static String getId(){
        int id = 1;
        try{
            // Retrieve the maximum id from the receipt table
            ResultSet rs = DbOperations.getData("SELECT MAX(id) FROM receipt");
            if(rs.next()){
                // Increment the id to get the next available id
                id = rs.getInt(1);
                id = id + 1;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    /**
     * Saves the receipt details to the database.
     * @param receipt
     */
    public static void save(Receipt receipt){
        String query = "INSERT INTO receipt VALUES('"+receipt.getId()+"','"+receipt.getName()+"','"+receipt.getPhoneNumber()+"','"+receipt.getEmail()+"','"+receipt.getDate()+"','"+receipt.getTotal()+"','"+receipt.getCreatedBy()+"')";
        DbOperations.setDataOrDelete(query, "Receipt Details Added Successfully");
    }
    
    /**
     * Retrieves all records from the receipt table that match a specific date in ascending order.
     * @param date
     * @return 
     */
    public static ArrayList<Receipt> getAllRecordsByInc(String date) {
        ArrayList<Receipt> arrayList = new ArrayList<>();
        try {
            // Retrieve all receipts matching the specified date in ascending order
            ResultSet rs = DbOperations.getData("SELECT * FROM receipt WHERE date LIKE '%"+date+"%'");
            while (rs.next()) {
                Receipt receipt = new Receipt();
                receipt.setId(rs.getInt("id"));
                receipt.setName(rs.getString("name"));
                receipt.setPhoneNumber(rs.getString("phoneNumber"));
                receipt.setEmail(rs.getString("email"));
                receipt.setDate(rs.getString("date"));
                receipt.setTotal(rs.getString("total"));
                receipt.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(receipt);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
               
    /**
     * Retrieves all records from the receipt table that match a specific date in descending order.
     * @param date
     * @return 
     */
    public static ArrayList<Receipt> getAllRecordsByDesc(String date) {
        ArrayList<Receipt> arrayList = new ArrayList<>();
        try {
            // Retrieve all receipts matching the specified date in descending order
            ResultSet rs = DbOperations.getData("SELECT * FROM receipt WHERE date LIKE '%"+date+"%' ORDER BY id DESC");
            while (rs.next()) {
                Receipt receipt = new Receipt();
                receipt.setId(rs.getInt("id"));
                receipt.setName(rs.getString("name"));
                receipt.setPhoneNumber(rs.getString("phoneNumber"));
                receipt.setEmail(rs.getString("email"));
                receipt.setDate(rs.getString("date"));
                receipt.setTotal(rs.getString("total"));
                receipt.setCreatedBy(rs.getString("createdBy"));
                arrayList.add(receipt);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
