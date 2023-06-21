/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant_management;

import dao.UserDao;
import model.User;

/**
 *
 * @author ozapr
 */
public class ChangeSecurityQuestion extends javax.swing.JFrame {

    public String userEmail; // Stores the user's email

    /**
     * Creates new form ChangeSecurityQuestion
     */
    public ChangeSecurityQuestion() {
        initComponents();
    }

    /**
     * Creates new form ChangeSecurityQuestion with the specified email
     */
    public ChangeSecurityQuestion(String email) {
        initComponents();
        userEmail = email;
        txtOldSecurityQuestion.setEditable(false);
        btnUpdate.setEnabled(false);
    }

    /**
     * Validates the fields and enables or disables the update button
     * accordingly
     */
    public void validateField() {
        String password = txtPassword.getText();
        String securityQuestion = txtNewSecurityQuestion.getText();
        String answer = txtNewAnswer.getText();

        if (!password.equals("") && !securityQuestion.equals("") && !answer.equals("")) {
            // If password, securityQuestion, and answer are not empty, enable the update button
            btnUpdate.setEnabled(true);
        } else {
            // Otherwise, disable the update button
            btnUpdate.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtOldSecurityQuestion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNewSecurityQuestion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNewAnswer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 134));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change Security Question.png"))); // NOI18N
        jLabel1.setText("Change Security Question");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Old Security Question");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 30));

        txtOldSecurityQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtOldSecurityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 300, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("New Security Question");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, 30));

        txtNewSecurityQuestion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNewSecurityQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewSecurityQuestionActionPerformed(evt);
            }
        });
        txtNewSecurityQuestion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewSecurityQuestionKeyReleased(evt);
            }
        });
        getContentPane().add(txtNewSecurityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 300, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("New Answer");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 30));

        txtNewAnswer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNewAnswer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewAnswerKeyReleased(evt);
            }
        });
        getContentPane().add(txtNewAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 300, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, 30));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 110, -1));

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 300, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(219, 77, 77));
        jTextField1.setAutoscrolls(false);
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 40, 400));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background large plain.png"))); // NOI18N
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(219, 77, 77), 3, true));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNewSecurityQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewSecurityQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewSecurityQuestionActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        User user = UserDao.getSecurityQuestion(userEmail);
        txtOldSecurityQuestion.setText(user.getSecurityQuestion());
    }//GEN-LAST:event_formComponentShown

    private void txtNewSecurityQuestionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewSecurityQuestionKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtNewSecurityQuestionKeyReleased

    private void txtNewAnswerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewAnswerKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtNewAnswerKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String password = txtPassword.getText(); 
        String securityQuestion = txtNewSecurityQuestion.getText(); 
        String answer = txtNewAnswer.getText(); 
        UserDao.changeSecurityQuestion(userEmail, password, securityQuestion, answer); // Call the UserDao's changeSecurityQuestion method 
        setVisible(false); 
        new ChangeSecurityQuestion(userEmail).setVisible(true); // Create a new ChangeSecurityQuestion frame and make it visible
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ChangeSecurityQuestion(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeSecurityQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeSecurityQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtNewAnswer;
    private javax.swing.JTextField txtNewSecurityQuestion;
    private javax.swing.JTextField txtOldSecurityQuestion;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
