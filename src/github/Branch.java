/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ranas
 */
public class Branch {
    
    private String name;
    private int No_of_Files;
    List<Branch> branches;
    List<Files> files;
    UnStaged unstaged;
    Staged staged;
    List<Commit> commits;
  

    public void showUnstage() throws IOException, InterruptedException
    {
        unstaged= new UnStaged();
        //u.setVisible(true);
        unstaged.watch=true;
        unstaged.stageChange("D:\\TestStage");   
  
    }
   
    //Check();  
    //History();
    //AddNewFile();
    //FindFile();
    //AddToStage();
    //DeleteFile();  
    //Add();
}
