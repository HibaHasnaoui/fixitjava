package controllers;
import static controllers.ConnexionControlleur.userConnect;

import entite.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.UserService;


public class UpdateUserControleur implements Initializable {

    @FXML
    private TextField txt_Nom;

    @FXML
    private TextField txt_prenom;

    @FXML
    private TextField txt_login;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_status;

    @FXML
    private Button modifier;

    @FXML
    private PasswordField txt_password;

  
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txt_Nom.setText(userConnect.getNom());
        txt_prenom.setText(userConnect.getPrenom());
        String x=String.valueOf(userConnect.getLogin());
        txt_login.setText(x);
       txt_password.setText(userConnect.getPassword());
       txt_mail.setText(userConnect.getEmail());
       
          txt_status.setText(userConnect.getStatut());
       
                       
          
       
        
    }
      @FXML
    void modifierUser(ActionEvent event) {
       UserService par=new UserService();
     
        
       par.update(new User(userConnect.getId(),txt_Nom.getText(),txt_prenom.getText(),Integer.parseInt(txt_login.getText()),txt_password.getText(),txt_mail.getText(),txt_status.getText()));
          JOptionPane.showMessageDialog(null, "modification effectué avec succes");
          

    }
    

}

      