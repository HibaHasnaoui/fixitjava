/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bazinfo
 */
public class database {
    private  String url="jdbc:mysql://localhost:3306/projet";
    private  String login="root";
    private  String pwd="";
    private  Connection cnx; 
    private static database conn;
     private database() {
        try {
            
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     
     public static database getInstance()
     {
           if(conn== null)
            conn= new database();
        return conn;
     }
          public Connection getCnx(){
        return cnx;
    }
    
}
