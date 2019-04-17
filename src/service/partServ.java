/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Partenaire;
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
public class partServ implements IService<Partenaire>{
      private database connexion;
    private PreparedStatement pst; 
    private ResultSet rs; 
    private Statement ste;

    public partServ() {
                 connexion= database.getInstance();

    }
    
    

    @Override
    public void insert(Partenaire t) {
       String requete="INSERT INTO Partenaire( nom, adresse,description,image) VALUES (?,?,?,?)";

          try {
              pst =connexion.getCnx().prepareStatement(requete);
             
            pst.setString(1,t.getNom());
            pst.setString(2,t.getAdresse());
            pst.setString(3,t.getDescription());
            pst.setString(4,t.getImage());
            
            pst.executeUpdate(); 
          } catch (SQLException ex) {
              Logger.getLogger(partServ.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public void delete(Partenaire t) {
       String requete="delete from partenaire where id=?";

          try {
              pst = connexion.getCnx().prepareStatement(requete);
              pst.setInt(1, t.getId());
              pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(partServ.class.getName()).log(Level.SEVERE, null, ex);
          }

    }

    @Override
    public void update(Partenaire t) {
        String requete="UPDATE partenaire SET nom=?,adresse=?,description=?,image=? WHERE id=?";
          try {
             
              pst=connexion.getCnx().prepareStatement(requete);
                pst.setString(1,t.getNom());
            pst.setString(2,t.getAdresse());
            pst.setString(3,t.getDescription());
            pst.setString(4,t.getImage());
            pst.setInt(5, t.getId());
            pst.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(partServ.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    @Override
    public List<Partenaire> displayAll() {
         List<Partenaire> list=new ArrayList<>();
              String requete="select * from partenaire";
          try {
             
              ste=connexion.getCnx().createStatement();
               rs=ste.executeQuery(requete);
              while(rs.next()){
               list.add (new Partenaire (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)));
                       }
          } catch (SQLException ex) {
              Logger.getLogger(partServ.class.getName()).log(Level.SEVERE, null, ex);
          }
          return list;
    }
    @Override
    public Partenaire getById(Partenaire t) {
        String requete="select * from partenaire where id=?";
                      Partenaire u1= new Partenaire();

          try {
              
              pst=connexion.getCnx().prepareStatement(requete);
               pst.setInt(1,t.getId());
             rs=pst.executeQuery();
             while(rs.next()){
    
                 u1=new Partenaire (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
             }
          } catch (SQLException ex) {
              Logger.getLogger(partServ.class.getName()).log(Level.SEVERE, null, ex);
          }
          return u1;
    }
}
    
        
    
    

