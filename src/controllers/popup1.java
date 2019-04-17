/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entite.Partenaire;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.partServ;

/**
 *
 * @author bazinfo
 */
public class popup1 {
      public static void display(Partenaire t){
       Stage popupwindow =new Stage();
       popupwindow.initModality(Modality.APPLICATION_MODAL);
       popupwindow.setTitle("update a test");
     //  Label label1=new Label("popup window now displayed");
       //Label label2= new Label();
       //label2.setText(t.getTitre());
     
       
       Label partenaire=new Label("Partenaire");
       Label lb=new Label("nom Partenaire");
       TextField nom = new TextField();
       nom.setText(t.getNom());
       Label label4= new Label("adresse");
         TextField adresse=new TextField();
       adresse.setText(t.getAdresse());
       Label label5= new Label("description");
       TextField descriptipn = new TextField();
       descriptipn.setText(t.getDescription());
        
        Label label6= new Label("image");
        TextField image = new TextField();
        image.setText(t.getImage());
        
    
        
 
                
   
  
       
       
       Button button1=new Button("close");
        Button button2=new Button("update Partenaire");
    
        
       button1.setOnAction(e->popupwindow.close());
       
       button2.setOnAction(e->
       {
           
         
           
        
        
          
         
           partServ tsv = new partServ();
           tsv.update(new Partenaire(t.getId(),nom.getText(),adresse.getText(),descriptipn.getText(),image.getText()));
           System.out.println("c bonnnnnn"); 
            JOptionPane.showMessageDialog(null, "modification effectuée", null, JOptionPane.DEFAULT_OPTION);
       });
       
       
       VBox layout=new VBox(10);
       layout.getChildren().addAll(lb,nom,label4,adresse,label5,descriptipn,label6,image,button1,button2);
       layout.setAlignment(Pos.CENTER);
       Scene scene1=new Scene(layout,500,600);
       popupwindow.setScene(scene1);
       popupwindow.showAndWait();
    
}
}