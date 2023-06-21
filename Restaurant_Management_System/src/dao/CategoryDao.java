/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import model.Category;

/**
 * Data Access Object (DAO) for working with the Category model.
 */
public class CategoryDao {
    
    /**
     * Saves a category to the database.
     * @param category
     */
    public static void save(Category category) {
        String query = "INSERT INTO category (name) VALUES ('"+category.getName()+"')";
        DbOperations.setDataOrDelete(query, "Category Added Successfully");
    }
    
    /**
     * Retrieves all records from the category table.
     * @return 
     */
    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM category");
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    /**
     * Deletes a category from the database based on its id.
     * @param id
     */
    public static void delete(String id) {
        String query = "DELETE FROM category WHERE id = '"+id+"'";
        DbOperations.setDataOrDelete(query, "Category Deleted Successfully");
    }
}
