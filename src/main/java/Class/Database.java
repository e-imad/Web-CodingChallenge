package Class;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author imad
 */
public class Database {

    public static Connection Database() 
    {
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/codingchallenge","root","");   
           return con;
            }catch(Exception e){ System.out.println(e); return null;}  
    }  
}
    
    
