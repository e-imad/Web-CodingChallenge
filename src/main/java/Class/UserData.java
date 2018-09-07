package Class;


import Class.User;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imad
 */

// class that handles all the request to the database related to the user:
//   -- login
//   -- Registration
public class UserData {
    public static User findUser(String username)
    {
        try{
        Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();
        ResultSet rs=st.executeQuery("select * from user where Email='"+username+"'");  
        if(rs.next())  
        {
            System.out.println(rs.getString(1)+"  "+rs.getString(2));
            return new User(rs.getString(1), rs.getString(2));
        }  
        con.close();  
        return null;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static ArrayList<User> getUsers() throws SQLException
    {
         Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();
        ResultSet rs=st.executeQuery("select * from user"); 
        ArrayList<User> A=new ArrayList();
        if(rs.next())  
        {
            System.out.println(rs.getString(1)+"  "+rs.getString(2));
            A.add(new User(rs.getString(1), rs.getString(2)));
        }  
        con.close();  
        return A;
    }
    public static boolean AddUser(String username, String password)
    {
        try{
         Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();
        st.execute("insert into user values('"+username+"','"+password+"')"); 
       
      
        con.close(); 
        
        return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

        
    }
    public static boolean updateUser(String username, String password) throws SQLException
    {
        try{
         Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();
        st.execute("UPDATE `user` SET `password` = '"+password+"' WHERE `user`.`Email` = '"+username+"'"); 
       
      
        con.close(); 
        
        return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

        
    }
    public static void main(String[] args ) throws SQLException
    {
        System.out.println(UserData.updateUser("lol@application.com","lol@loli"));
    }
    
}
