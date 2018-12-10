/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ranas
 */
public class Repository {

    List<Comment> comments;
    List<Branch> branches=new ArrayList<Branch>();
    private int id;
    String name;
    public int No_of_Commits;
    public String Address;

    //CreateBranch(String Name);
    //ViewHistory();
    //AddComment();
    public Repository(String n, String ad) {
        comments=null;
        name = n;
        Commit c = new Commit("salman", 12345, "Just Commited",Calendar.getInstance());
        Branch b = new Branch("Master",c);
        branches.add(b);
        id = 1;
        No_of_Commits = 1;
        Address = ad;
    }

    public String getName() {
        return name;
    }

    Branch CreateBranch(String Name) {
        Commit c = new Commit("salman", 12346, "Just Commited",Calendar.getInstance());
        Branch b = new Branch(Name,c);
        branches.add(b);
        return b;
    }
public String FindFile(String fileName) throws IOException{
           String fileSeparator = System.getProperty("file.separator");
           String addr=Address;
           for(Branch b:branches){
               addr=addr+ fileSeparator+b.getName();
               for(Files f:b.files){
                   if(f.getName().equals(fileName)){
                        addr=addr+ fileSeparator+f.getName();
                        return addr;
                   }
               }
               addr.replace(fileSeparator+b.getName(), "");
               for(Branch ChildB:b.branches){
                    addr=addr+ fileSeparator+ChildB.getName();
                    for(Files f:ChildB.files){
                        if(f.getName().equals(fileName)){
                            addr=addr+ fileSeparator+f.getName();
                            return addr;
                        }
                    }
               }
               addr.replace(fileSeparator+b.getName(), "");
          }
           addr="false";
           return addr;
      }
    public static void deleteBranch(File file) throws IOException {
        if (file.isDirectory()) {

            //directory is empty, then delete it
            if (file.list().length == 0) {

                file.delete();
                System.out.println("Directory is deleted : "
                        + file.getAbsolutePath());

            } else {

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    deleteBranch(fileDelete);
                }

                //check the directory again, if empty then delete it
                if (file.list().length == 0) {
                    file.delete();
                    System.out.println("Directory is deleted : "
                            + file.getAbsolutePath());
                }
            }

        } else {
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }

}
