/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.io.IOException;
import java.util.ArrayList;
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
    List<Commit> commits=new ArrayList<Commit>();

    public Branch(String str,Commit c) {
        name = str;
        //commits.add(c);
        No_of_Files=1;
        files=null;
        branches=null;
        staged=null;
        unstaged=null;
        commits.add(c);
        
    }
    public Branch()
    {
        
    }
    
    public String getName() {
        return name;
    }

    public void AddNewFilefunc() {
        AddNewFile filenew = new AddNewFile();
        filenew.setVisible(true);

    }

    public void DeleteFilefunc() {
        DeleteFile delfile = new DeleteFile();
        delfile.setVisible(true);
    }

    public void showUnstage() throws IOException, InterruptedException {
        unstaged = new UnStaged();
        //u.setVisible(true);
        unstaged.watch = true;
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
