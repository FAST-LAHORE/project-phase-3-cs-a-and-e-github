/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author ranas
 */
public class Commit {
    
    private String Author;
    private int CommitID;
    private String CommitMessage;
    private Calendar commdate;
    String changes=null;
    
    //Branch branch;
    public Commit(String s,int a,String c,Calendar d)
    {
        Author=s;
        CommitID=a;
        CommitMessage=c;
        commdate=d;
    }
    //CommitHistory();

    public void setChanges(String changes) {
        this.changes = changes;
    }
    
}
