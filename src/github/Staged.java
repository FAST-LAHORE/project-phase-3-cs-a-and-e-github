/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranas
 */
public class Staged {
    
    Branch branch;
    List<String> files=new ArrayList<String>();
    //Commit();
    //CurrentStatus();

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public Branch getBranch() {
        return branch;
    }

    public List<String> getFiles() {
        return files;
    }
}
