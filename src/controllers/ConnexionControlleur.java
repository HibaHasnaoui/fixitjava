package controllers;

import entite.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projet.database;
import service.UserService;

public class ConnexionControlleur {

    @FXML
    private TextField txt_mail;

    @FXML
    private Button ajouter;

    @FXML
    private PasswordField txt_password;
     @FXML
     private Label IsConnected;
     static User userConnect;
    

    @FXML
    void authentifier(ActionEvent event) throws SQLException, IOException {
        String pswd;
        String mail;
        mail = txt_mail.getText();
        pswd = txt_password.getText();
        Connection connexion=database.getInstance().getCnx();
        Statement statement = connexion.createStatement();
        ResultSet rsl =statement.executeQuery("select * from user where email = '" + mail + "' and password = '" + pswd + "'");
        System.out.println("valiide");
        UserService us = new UserService();
        userConnect = us.getByEmail(mail);
        System.out.println("User is ===> " + userConnect.getNom());
         Stage primaryStage=new Stage();
         Parent root= FXMLLoader.load(getClass().getResource("AfficherProfil.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setTitle("Hello World!");
         primaryStage.setScene(scene);
         primaryStage.show();
    }

}
