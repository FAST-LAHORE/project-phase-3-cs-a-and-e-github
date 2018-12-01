/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ranas
 */
public class Repository {
    
    
    List<Comment> comments;
    List<Branch> branches;
    private int id;
    private String name;
    private int No_of_Commits;
    public String Address;
    
    //CreateBranch(String Name);
    //ViewHistory();
    //AddComment();
    
      public static void deleteBranch(File file)
    	throws IOException{
 
    	if(file.isDirectory()){
 
    		//directory is empty, then delete it
    		if(file.list().length==0){
    			
    		   file.delete();
    		   System.out.println("Directory is deleted : " 
                                                 + file.getAbsolutePath());
    			
    		}else{
    			
    		   //list all the directory contents
        	   String files[] = file.list();
     
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
        		 
        	      //recursive delete
        	     deleteBranch(fileDelete);
        	   }
        		
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
        	     System.out.println("Directory is deleted : " 
                                                  + file.getAbsolutePath());
        	   }
    		}
    		
    	}else{
    		//if file, then delete it
    		file.delete();
    		System.out.println("File is deleted : " + file.getAbsolutePath());
    	}
    }
    
}
