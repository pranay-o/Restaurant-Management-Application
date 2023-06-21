/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import java.sql.*;

/**
 * Data Access Object (DAO) for managing Product data in the database.
 */
public class ProductDao {
    
    /**
     * Saves a product to the database.
     * @param product
     */
    public static void save(Product product) {
        String query = "INSERT INTO product (name, category, price) VALUES ('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperations.setDataOrDelete(query, "Product Added Successfully");
    }
    
    /**
     * Retrieves all records from the product table.
     * @return 
     */
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    /**
     * Updates a product in the database.
     * @param product
     */
    public static void update(Product product){
        String query = "UPDATE product SET name = '"+product.getName()+"', category = '"+product.getCategory()+"', price = '"+product.getPrice()+"' WHERE id ='"+product.getId()+"'";
        DbOperations.setDataOrDelete(query, "Product Updated Successfully");
    }
    
    /**
     * Deletes a product from the database based on its id.
     * @param id
     */
    public static void delete(String id){
        String query = "DELETE FROM product WHERE id = '"+id+"'";
        DbOperations.setDataOrDelete(query, "Product Deleted Successfully");
    }
    
    /**
     * Retrieves all products from the database that belong to a specific category.
     * @param category
     * @return 
     */
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE category = '"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    /**
     * Filters products by name and category.
     * @param name
     * @param category
     * @return 
     */
    public static ArrayList<Product> filterProductByname(String name, String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name LIKE '%"+name+"%' AND category ='"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    /**
     * Retrieves a product from the database based on its name.
     * @param name
     * @return 
     */
    public static Product getProductByname(String name){
        Product product = new Product();
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM product WHERE name='"+name+"'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
