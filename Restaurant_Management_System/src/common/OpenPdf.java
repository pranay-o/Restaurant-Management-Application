/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 * Utility class for opening PDF files.
 */
public class OpenPdf {
    
    /**
     * Opens a PDF file by its id.
     * @param id
     */
    public static void openById(String id) {
        try {
            // Construct the file path based on the provided id
            String filePath = "C:\\Users\\ozapr\\Downloads\\" + id + ".pdf";
            
            // Create a File object for the specified file path
            File file = new File(filePath);
            
            // Check if the file exists
            if (file.exists()) {
                // Open the file using the default PDF viewer
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filePath);
            } else {
                // Display an error message if the file does not exist
                JOptionPane.showMessageDialog(null, "File does not exist");
            }
        } catch (Exception e) {
            // Display any exceptions that occur during the process
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
