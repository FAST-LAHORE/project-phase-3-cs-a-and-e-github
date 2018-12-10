/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import static github.UnStaged.files;
import static github.UnStaged.watch;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ranas
 */
public class StagingArea extends javax.swing.JFrame {

    public MyThread t=null;
  
    /**
     * Creates new form UnStageArea
     */
    public StagingArea() {
        initComponents();      
        t= new MyThread("D:\\TestStage",true);
        t.start();
    }

    public class MyThread extends Thread
    {
      public String address;
      public boolean watch;
      public MyThread(String Add, boolean w)
      {
          this.address=Add;
          this.watch=w;
      }
    @Override
    public void run()
    {
       try{
             //StagingArea stgArea=new StagingArea();
             //stgArea.setVisible(true);
                WatchService watchService = FileSystems.getDefault().newWatchService();		
		Path directory = Paths.get(address);
                files=new ArrayList<String>();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		
                int count=0;
                
		WatchKey watchKey = directory.register(watchService, 
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		
		while (watch==true) {
                   // System.out.println("Checking...");
                   // watchKey = watchService.poll(10, TimeUnit.MINUTES);
                   
			for (WatchEvent<?> event : watchKey.pollEvents()) {
				System.out.println(event.kind());
				Path file = directory.resolve((Path) event.context());
                                System.out.println(file + " was last modified at " + sdf.format(file.toFile().lastModified()));
                                if(event.kind().toString().equals("ENTRY_CREATE"))
                                {
                                    files.add(event.kind()+" -> "+file.toString()+" "+sdf.format(file.toFile().lastModified())); 
                                    count++;
                                    break;                              
                                }     
                                if(event.kind().toString().equals("ENTRY_DELETE"))
                                {
                                    files.add(event.kind()+" -> "+file.toString());                                     
                                    break;
                              
                                }     
                                 if(event.kind().toString().equals("ENTRY_MODIFY")&& count==0)
                                {
                                    files.add(event.kind()+" -> "+file.toString()+" "+sdf.format(file.toFile().lastModified()));                                 
                                    break;                    
                                }    
                                 count=0;
			}
                       // watchKey.reset();
                       Thread.sleep(500);
                        StagingArea.UnstageArea.setText(null);
                        for(String s: files)
                        {
                            StagingArea.UnstageArea.append(s +"\n");
                            //u.stageArea.append(s +"\n");
                        }
		}
                StagingArea.UnstageArea.setText(null);
                        for(String s: files)
                        {
                            //u.UnstageArea.append(s +"\n");
                            StagingArea.stageArea.append(s +"\n");
                        }
   
}       
        catch (Exception e)
        {
            System.out.println("Something Went Wrong");
        }     
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

        MainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UnstageArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stageArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        stageBtn = new javax.swing.JButton();
        btnCommit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(0, 0, 0));
        MainPanel.setForeground(new java.awt.Color(255, 255, 255));

        UnstageArea.setEditable(false);
        UnstageArea.setBackground(new java.awt.Color(153, 153, 153));
        UnstageArea.setColumns(20);
        UnstageArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        UnstageArea.setRows(5);
        jScrollPane1.setViewportView(UnstageArea);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UnStaged Changes");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stage Changes (Will Commit)");

        stageArea.setEditable(false);
        stageArea.setBackground(new java.awt.Color(153, 153, 153));
        stageArea.setColumns(20);
        stageArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        stageArea.setRows(5);
        jScrollPane2.setViewportView(stageArea);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        stageBtn.setBackground(new java.awt.Color(0, 0, 0));
        stageBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stageBtn.setForeground(new java.awt.Color(255, 255, 255));
        stageBtn.setText("Stage Change");
        stageBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        stageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stageBtnActionPerformed(evt);
            }
        });

        btnCommit.setBackground(new java.awt.Color(0, 0, 0));
        btnCommit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCommit.setForeground(new java.awt.Color(255, 255, 255));
        btnCommit.setText("Commit");
        btnCommit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        btnCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCommit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(stageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stageBtnActionPerformed
 
        t.watch=false;
    }//GEN-LAST:event_stageBtnActionPerformed

    private void btnCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCommitActionPerformed

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
            java.util.logging.Logger.getLogger(StagingArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StagingArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StagingArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StagingArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StagingArea().setVisible(true);
           }
        
        });
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    public static javax.swing.JTextArea UnstageArea;
    private javax.swing.JButton btnCommit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea stageArea;
    public static javax.swing.JButton stageBtn;
    // End of variables declaration//GEN-END:variables
}
