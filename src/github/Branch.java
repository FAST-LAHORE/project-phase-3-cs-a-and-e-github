/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

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

    public String getName() {
        return name;
    }
    
    public void AddNewFilefunc(){
        AddNewFile filenew=new AddNewFile();
        filenew.setVisible(true);
        
    }

    //Check();  
    //History();
    //AddNewFile();
    //FindFile();
    //AddToStage();
    //DeleteFile();  
    //Add();
}
