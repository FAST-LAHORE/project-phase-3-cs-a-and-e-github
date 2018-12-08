/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ranas
 */
public class Comment {
    
    private String comment;
    Repository repository;
    
    //ViewComment();
    Connection conn= null;
    Statement st= null;
    PreparedStatement ps = null;
    ResultSet rs = null;
     Comment()
    {
	this.comment=null;
    }
    public void Add(String c,String repositoryName)
    {
	//this.comment=comment;
        try
        {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gitDB", "Abdurrehman", "010203");
            st = conn.createStatement();
            rs=st.executeQuery("Select c_id from Abdurrehman.CommentHistory");
            int id=1;
            int i=0;
            while(rs.next())
            {
                id=rs.getInt("c_id");
                //System.out.println("c_id    "+id);
                i++;
                id=id+1;
            }
            if (i==0)
            {
                id=1;
            }
            //int id=1;
            ps=conn.prepareStatement("Insert into CommentHistory(c_id,com,repname) values(?,?,?)"); 
            ps.setInt(1,id);
            ps.setString(2,c);
            ps.setString(3,repositoryName);
            int executeUpdate = ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    public void ViewComment(String repositoryName)
    {
        try
        {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gitDB", "Abdurrehman", "010203");
            ps=conn.prepareStatement("Select com from Abdurrehman.CommentHistory where repname=?");
            ps.setString(1,repositoryName);
            rs=ps.executeQuery();
//            st = conn.createStatement();
//            rs=st.executeQuery("Select com from Abdurrehman.CommentHistory where repname='git'");
         // System.out.println("success");
            while(rs.next())
            {     
                System.out.println("Comment on "+repositoryName+"\t     "+rs.getString("com"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
