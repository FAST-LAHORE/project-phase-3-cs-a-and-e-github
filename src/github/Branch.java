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
 * @author maria
 */
public class Branch {
    
    private String name;
    private int No_of_Files;
    List<Branch> branches;
    List<Files> files;
    UnStaged unstaged;
    Staged staged;
    List<Commit> commits;
<<<<<<< HEAD
  
=======

    public String getName() {
        return name;
    }
    
    public void AddNewFilefunc(){
        AddNewFile filenew=new AddNewFile();
        filenew.setVisible(true);
        
    }
    public void DeleteFilefunc(){
        DeleteFile delfile=new DeleteFile();
        delfile.setVisible(true);
    }
>>>>>>> 9f57ce9a62535c15fa90a8e7a312c8389244813b

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
