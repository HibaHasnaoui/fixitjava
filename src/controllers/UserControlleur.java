package controllers;

import entite.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.UserService;

public class UserControlleur {

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
    private Button ajouter;

    @FXML
    private PasswordField txt_password;

    @FXML
    void ajouterUser(ActionEvent event) {
        UserService u=new UserService();
        int x=Integer.parseInt(txt_login.getText());
        u.insert(new User(txt_Nom.getText(),txt_prenom.getText(),x,txt_password.getText(),txt_mail.getText(),txt_status.getText()));
        JOptionPane.showMessageDialog(null, "user added");

    }

}



    


