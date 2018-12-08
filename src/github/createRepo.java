/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author m.salmanghazi
 */
public class createRepo extends javax.swing.JFrame {

    /**
     * Creates new form createRepo
     */
    List<String> str = new ArrayList<String>();
    List<Repository> repss = new ArrayList<Repository>();
    public User currUseru;
    public String currUser = "salman";
    public String addr = null;
    //public String 
    Connection con = null;
    Statement stat = null;
    ResultSet res = null;

    public createRepo() {

        initComponents();
    }

    public createRepo(List<Repository> rr, User uuu) {
        initComponents();
        repss = rr;
        currUseru = uuu;
        user.setText(currUser);
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/repositories", "salman", "salman");
        } catch (SQLException ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        user = new javax.swing.JLabel();
        repoName = new javax.swing.JTextField();
        finallycreate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pth = new javax.swing.JTextField();
        canc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        user.setText("User");

        repoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repoNameActionPerformed(evt);
            }
        });

        finallycreate.setForeground(new java.awt.Color(255, 0, 0));
        finallycreate.setText("Create Repository");
        finallycreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finallycreateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setText("Create a new repository");

        jLabel1.setText("A repository contains all the files for your project, including the revision history.  ");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jLabel3.setText("Owner");

        jLabel4.setText("Great repository names are short and memorable. Need inspiration? How about");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 100, 0));
        jLabel5.setText(" super-duper-engine.");

        jLabel6.setText("PATH");

        canc.setText("Cancel");
        canc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Repository Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(51, 51, 51)
                                .addComponent(pth, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(repoName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(finallycreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canc)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user)
                    .addComponent(repoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(finallycreate)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(canc)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        

    private void finallycreateActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:

        if ((repoName.getText()).isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "PLEASE give the name of repository", "Repository name?", HEIGHT);
        } else if ((pth.getText()).isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "PLEASE give the path of the repository or browse it", "Path", HEIGHT);
        } else {
            addr = pth.getText() + "/" + repoName.getText();

            File f = new File(pth.getText() + "/" + repoName.getText());
            f.mkdir();
            Repository re = new Repository(repoName.getText(), pth.getText());
            repss.add(re);
            Statement st = null;
            try {
                st = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(createRepo.class.getName()).log(Level.SEVERE, null, ex);
            }

            String query = "SELECT * FROM SALMAN.REP WHERE USER_NAME='" + currUser + "'and REPOSITORY_NAME='" + repoName.getText() + "'";
            //  String query = "SELECT * FROM Users WHERE Name='"+name+ "'and Email='"+email+"'";
            ResultSet rs = null;
            try {
                rs = st.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(createRepo.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // System.out.println(rs);
                //String firstName = rs.getString("first_name");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(rootPane, "Repository Already Exists", "Error ", HEIGHT);
                    //uname.setText("                                  ");
                    //uemail.setText("                                  ");
                    //upassword.setText("                                  ");
                    //JOptionPane.showMessageDialog(rootPane, "YourAccount has been successfuly created", "Successful", HEIGHT);
                } else {
                    // JOptionPane.showMessageDialog(rootPane, "no User found", "Error ", HEIGHT);
                    JOptionPane.showMessageDialog(rootPane, "Repository created on the Path", "Successful", HEIGHT);
                    Insertdata();
                    /*String query2 = "SELECT REPOSITORY_NAME FROM SALMAN.REP WHERE REPOSITORY_NAME='" + currUser + "'";
                    //str.add();
                    ResultSet rs1 = null;
                    try {
                        rs1 = st.executeQuery(query);
                        System.out.println(rs1.getArray("REPOSITORY_NAME"));
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(createRepo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    */
                    this.setVisible(false);
                    MainPage mp = new MainPage(repss, currUseru);
                    mp.setVisible(true);

                }
            } catch (SQLException ex) {
                Logger.getLogger(createRepo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }                                             

    void getcurrRepo() {

    }
    private void cancActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();

    }                                    

    private void repoNameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        //repoName.setText(pathof);

    }                                        

    public void Insertdata() {
        try {
            String name = repoName.getText();
            // addr=pth.getText();
            //paswrd=upassword.getText();
            //email=uemail.getText();
            //JOptionPane.showMessageDialog(rootPane, "Entered indata base", "Error Occurs", HEIGHT);
            PreparedStatement sts = con.prepareStatement("insert into REP(USER_NAME,REPOSITORY_NAME,ADDRESS) values(?,?,?)");
            sts.setString(1, currUser);
            sts.setString(2, name);
            sts.setString(3, addr);

            sts.executeUpdate();
            // JOptionPane.showMessageDialog(rootPane, "Entered indata base", "Error Occurs", HEIGHT);

        } catch (SQLException ex) {
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
            java.util.logging.Logger.getLogger(createRepo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createRepo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createRepo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createRepo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createRepo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton canc;
    private javax.swing.JButton finallycreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField pth;
    private javax.swing.JTextField repoName;
    private javax.swing.JLabel user;
    // End of variables declaration                   
}
