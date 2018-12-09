/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author m.salmanghazi
 */
public class createBr extends javax.swing.JFrame {

    /**
     * Creates new form createBr
     */
    Repository crr = null;
    Connection con = null;
    Statement stat = null;
    ResultSet res = null;

    public createBr(Repository r) {
        initComponents();
        dir.setText(r.name);
        crr = r;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/repositories", "salman", "salman");
        } catch (SQLException ex) {
        }
    }

    public createBr() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Current Repository");

        dir.setFont(new java.awt.Font("Verdana", 3, 15)); // NOI18N

        jLabel2.setText("Branch:");

        jLabel3.setText("Great Branch names are short and memorable. Need inspiration? How about");

        jLabel4.setForeground(new java.awt.Color(0, 100, 0));
        jLabel4.setText("Unicorn");

        ok.setText("Create Branch");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(bname, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(ok)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ok)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void okActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        File f = new File(crr.Address + "/" + bname.getText());
        f.mkdir();
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(createRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        String query = "SELECT * FROM SALMAN.Branches WHERE NAME='" + bname.getText() + "'and REPO_NAME='" + crr.name + "'";
        //  String query = "SELECT * FROM Users WHERE Name='"+name+ "'and Email='"+email+"'";
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(createRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (rs.next()) {
                JOptionPane.showMessageDialog(rootPane, "Branch Already Exists", "Error ", HEIGHT);
                //uname.setText("                                  ");
                //uemail.setText("                                  ");
                //upassword.setText("                                  ");
                //JOptionPane.showMessageDialog(rootPane, "YourAccount has been successfuly created", "Successful", HEIGHT);
            } else {
                // JOptionPane.showMessageDialog(rootPane, "no User found", "Error ", HEIGHT);
                JOptionPane.showMessageDialog(rootPane, "Branch created in the Repository", "Successful", HEIGHT);
                Insertdata();
            }
        } catch (Exception ex) {
            // Logger.getLogger(createBr.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*for (int i = 0; i < crr.branches.size(); i++) {
            //String n=crr.branches.get(i);
            Branch bb=crr.branches.get(i);
            if(bb.getName()==bname.getText())
            {
                 JOptionPane.showMessageDialog(rootPane, "Branch already exist", "Error", HEIGHT);
            }
        }*/
        String ss=crr.Address;//+File.separator+crr.name;
        File f1 = new File(ss + File.separator + bname.getText() + File.separator + "ReadMe");
        try {
            f1.getParentFile().mkdirs();
            boolean result = f1.createNewFile();
            
            if (result) {
               // JOptionPane.showMessageDialog(rootPane, "Branch has been successfuly created", "Successful", HEIGHT);
                this.setVisible(false);
            } else {

                JOptionPane.showMessageDialog(rootPane, "Enter another name. A file has already this name", "Error", HEIGHT);
            }
        } catch (IOException ex) {
            Logger.getLogger(createBr.class.getName()).log(Level.SEVERE, null, ex);
        }
       Branch b=crr.CreateBranch(bname.getText());//this creates the current branch
       
        //Branch b=new Branch(bname.getText());
    }                                  
    public void Insertdata() {
        try {
            PreparedStatement sts = con.prepareStatement("insert into BRANCHES(NAME,ADDRESS,REPO_NAME) values(?,?,?)");
            sts.setString(1, bname.getText());
            sts.setString(2, crr.Address);
            sts.setString(3, crr.name);

            sts.executeUpdate();
           
        } catch (SQLException ex) {
        }

    }

    /**
     * @param args the command line arguments
     */

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
            java.util.logging.Logger.getLogger(createBr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createBr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createBr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createBr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createBr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField bname;
    private javax.swing.JLabel dir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton ok;
    // End of variables declaration                   
}
