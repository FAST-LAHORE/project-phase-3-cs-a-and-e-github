/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

/**
 *
 * @author ranas
 */
public class Commit {
    
    private String Author;
    private int CommitID;
    private String CommitMessage;
    
    Branch branch;
    public Commit(String s,int a,String c)
    {
        Author=s;
        CommitID=a;
        CommitMessage=c;
    }
    //CommitHistory();
    
}
