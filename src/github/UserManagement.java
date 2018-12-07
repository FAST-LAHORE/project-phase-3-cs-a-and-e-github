/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ranas
 */
public class UserManagement {
    
    List<User> users;
    
    //Registration();
    //login();
    //VerifiesCredentials();
    //CheckUser();

   
    Connection conn= null;
    Statement st= null;
    ResultSet rs = null;
    public UserManagement() {
    }
    
    public boolean login(String usrname,String passwrd) throws SQLException{
        boolean flag=false;
        try
        {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/gitDB", "Abdurrehman", "010203");
            st = conn.createStatement();
            rs=st.executeQuery("Select Username,Password from Abdurrehman.Users");//where username.equals(username) && password.equals(password)
            while(rs.next())
            {
                String name=rs.getString("Username");
                String pass=rs.getString("Password");
                if (name.equals(usrname) && pass.equals(passwrd))
                {
                    //System.out.println(name +"\t"+ pass);
                   flag=true;
                }
            }
            
        }
        catch (SQLException e)
        {
           e.printStackTrace();
        }
        return flag;
     
    }
    
}
