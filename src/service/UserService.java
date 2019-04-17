/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.database;

/**
 *
 * @author bazinfo
 */
public class UserService implements IService<User>{ 
    
    private database connexion;
    private PreparedStatement pst; 
    private ResultSet rs; 
    private Statement ste;
  
    
      public UserService() {
         connexion= database.getInstance();
    }
   

    @Override
    public void insert(User t) {
        String requete="INSERT INTO user( nom, prenom,login,password,email,statut) VALUES (?,?,?,?,?,?)";
        try {
            pst =connexion.getCnx().prepareStatement(requete);
            pst.setString(1,t.getNom());
            pst.setString(2,t.getPrenom());
            pst.setInt(3,t.getLogin());
            pst.setString(4,t.getPassword());
            pst.setString(5,t.getEmail());
            pst.setString(6,t.getStatut());
            pst.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User t) {
           String requete="DELETE FROM user WHERE id=?";
        try {
            pst = connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,t.getId());
             pst.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }

    @Override
    public void update(User t) {
        String requete="UPDATE user SET nom=?,prenom=?,login=?,password=?,email=?,statut=? WHERE id=?";
        try {
            pst=connexion.getCnx().prepareStatement(requete);
           
            pst.setString(1,t.getNom());
            pst.setString(2,t.getPrenom());
            pst.setInt(3,t.getLogin());
            pst.setString(4,t.getPassword());
            pst.setString(5,t.getEmail());
            pst.setString(6,t.getStatut());
            pst.setInt(7,t.getId());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> displayAll() {
         List<User> list=new ArrayList<>();
         String requete="select * from user";
        try {
            ste=connexion.getCnx().createStatement();
            rs=ste.executeQuery(requete);
              while(rs.next()){
               list.add (new User (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7)));
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User getById(User t) {
         String requete="select * from user where id=?";
         User u1= new User();
        try {
            pst=connexion.getCnx().prepareStatement(requete);
             pst.setInt(1,t.getId());
             rs=pst.executeQuery();
              while(rs.next()){
               u1=new User (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
                 
             }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u1;
        
    }
    public User getByEmail(String mail) {
        String requete="select * from user where email=?";
        User u1= new User();
        //Boolean x =false;
        try {
            pst=connexion.getCnx().prepareStatement(requete);
            pst.setString(1,mail);
            rs=pst.executeQuery();
            while(rs.next()){
                u1= new User(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5), rs.getString(6),rs.getString(7));
                //x = true; 
              }
        } catch (SQLException ex) {
          Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u1;
        
    }



    
    
}
    
    

