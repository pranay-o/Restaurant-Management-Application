/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 * Utility class for performing database operations.
 */
public class DbOperations {
    
    /**
     * Executes an SQL query for data insertion or deletion.
     * @param query
     * @param msg
     */
    public static void setDataOrDelete(String query, String msg) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
            // Execute the query
            st.executeUpdate(query);
            
            // Display success message, if provided
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (Exception e) {
            // Display error message with details
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Executes an SQL query to retrieve data.
     * @param query
     * @return 
     */
    public static ResultSet getData(String query) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            
            // Execute the query and get the result set
            ResultSet rs = st.executeQuery(query);
            
            return rs;
        } catch (Exception e) {
            // Display error message with details
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
