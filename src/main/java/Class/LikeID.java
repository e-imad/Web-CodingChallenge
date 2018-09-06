/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imad
 */
public class LikeID {
    public static boolean AddLike(String username, String Ref)
    {
        try{
         Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();
        st.execute("insert into liked values('"+username+"','"+Ref+"')"); 
       
      
        con.close(); 
        
        return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

        
    }
    public static boolean RemoveLike(String username, String Ref)
    {
        try{
         Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();        
        System.err.println("Delete FROM liked WHERE user = '"+username+"' AND LocationId = '"+Ref+"' ");
        st.execute("Delete FROM liked WHERE user = '"+username+"' AND LocationId = '"+Ref+"' "); 
            
       
      
        con.close(); 
        
        return true;
        } catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }

        
    }
     public static boolean AddDisLike(String username, String Ref) 
    {
        try{
         Connection con=Database.Database();
        Statement st=(Statement) con.createStatement();
        st.execute("insert into disliked(user,LocationId) values('"+username+"','"+Ref+"')"); 
       
      
        con.close(); 
        
        return true;
        } catch(Exception e)
        {
          e.printStackTrace();
          return false;
        }

        
    }
     public static ArrayList<String> getLikes(String username)
    {
        try {
            Connection con=Database.Database();
            Statement st=(Statement) con.createStatement();
            ResultSet rs=st.executeQuery("select * from liked where user='"+username+"'");
            ArrayList<String> A=new ArrayList();
            while(rs.next())
            {
                A.add(rs.getString(2));
            }
            con.close();
            return A;
        } catch (SQLException ex) {
            Logger.getLogger(LikeID.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
      public static ArrayList<String> getDisLikes(String username)
    {
        try {
            Connection con=Database.Database();
            Statement st=(Statement) con.createStatement();
            ResultSet rs=st.executeQuery("select * from disliked where user='"+username+"' and time =DATE_SUB(NOW( ),INTERVAL 2 HOUR)");
            ArrayList<String> A=new ArrayList();
            while(rs.next())
            {
                A.add(rs.getString(2));
            }
            con.close();
            return A;
        } catch (SQLException ex) {
            Logger.getLogger(LikeID.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public static void main(String[] args)
      {
          LikeID.RemoveLike("imad@imad.com","ChIJ3TE16cSTnQ0RCNlB9UliunI" );
      }
        
    }
    

