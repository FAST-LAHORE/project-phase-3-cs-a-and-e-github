/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author ranas
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public String currRepository = null;
    public String currBranch = null;
    List<Repository> repss = new ArrayList<Repository>();
    Repository currrep = null;
    public User currUserr;
    public String currAddress;
    String currUser = "salman";
    Connection con = null;

    
       
    public MainPage() {
        initComponents();
        JFrame.setDefaultLookAndFeelDecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width - 15, screenSize.height - 45);
        //mainpagelabel.setSize(screenSize.width-15, screenSize.height-45);
        // mainpagelabel.setBounds(0,0,screenSize.width-15, screenSize.height-45);
        // homepagepic.setSize(screenSize.width, screenSize.height);
        // homepagepic.setBounds(0,0,screenSize.width, screenSize.height);
        // this.setVisible(true);
    }

    public MainPage(Repository rr, User uuu) throws SQLException {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/repositories", "salman", "salman");
        } catch (Exception e) {
        }
        retrieve();
        JFrame.setDefaultLookAndFeelDecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width - 15, screenSize.height - 45);
        repss.add(rr);
        currRepository=rr.Address;
        List<Branch> b=rr.branches;
        currBranch=rr.branches.get((rr.branches.size()-1)).getName();//4209
        //currrep=rr;
        Repository curr =rr;//current repository ye le mustufa
        
        
        
        
        // loc.setListData(data);
        //currAddress = curr.Address;*/
        //System.out.println(curr.name);
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        createB = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Git");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1130, 16);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 10, 130, 40);

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Start a Project");
        jButton1.setBorder(null);
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 60, 310, 70);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jMenu1.setText("Repository");

        jMenuItem1.setText("Create Repository");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Create New Branch");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Add Comments");
        jMenu1.add(jMenuItem3);

        jMenuItem18.setText("Show All Repositories");
        jMenu1.add(jMenuItem18);

        jMenuItem4.setText("Clone Repository");
        jMenu1.add(jMenuItem4);

        jMenuItem13.setText("Delete Branch");
        jMenu1.add(jMenuItem13);

        jMenuItem14.setText("Find File");
        jMenu1.add(jMenuItem14);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Branch");

        createB.setText("Create Branch");
        createB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBActionPerformed(evt);
            }
        });
        jMenu2.add(createB);

        jMenuItem5.setText("View Branch History");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem16.setText("Monitor Branch");
        jMenu2.add(jMenuItem16);

        jMenuItem6.setText("Add New File");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Delete File");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Pull Branch");
        jMenu2.add(jMenuItem8);

        jMenuItem15.setText("Push Branch");
        jMenu2.add(jMenuItem15);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("User");

        jMenuItem11.setText("Log Out");
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        createRepo cr = new createRepo(repss, currUserr);

        cr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void createBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBActionPerformed
        // TODO add your handling code here:
        int i = (repss.size() - 1);
        createBr cb = new createBr(repss.get(i));
        this.setVisible(false);
        cb.setVisible(true);
    }//GEN-LAST:event_createBActionPerformed
    public void retrieve() throws SQLException {
        //Connection con = null;
        //Statement stat = null;
        //ResultSet res = null;
        ResultSet rs1 = null;
        String query2 = "SELECT REPOSITORY_NAME,ADDRESS FROM SALMAN.REP WHERE USER_NAME=?";
        PreparedStatement ptmt = con.prepareStatement(query2);
        ptmt.setString(1, currUser);
        rs1 = ptmt.executeQuery();
        List<String> lis = new ArrayList<String>();
        while (rs1.next()) {
            String temp = rs1.getString("repository_name");
            String temp2 = rs1.getString("address");
            lis.add(temp);
            repss.add(new Repository(temp, temp2));
        }
    }

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem createB;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables
}
