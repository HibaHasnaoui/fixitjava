package controllers;

import static controllers.ConnexionControlleur.userConnect;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AfficherProfil implements Initializable{

    @FXML
    private Label nomPrenom;

    @FXML
    private ImageView imagee;

    @FXML
    private Label status;

    @FXML
    private Button ajout;

    @FXML
    private Button affiche;

    @FXML
    private Button deconnecter;

    @FXML
    private Button btn_modifier;

    @FXML
    private Button btn_delete;

    @FXML
    void afficherCompte(ActionEvent event) throws IOException {  //partenaire
 Stage primaryStage=new Stage();
         Parent root= FXMLLoader.load(getClass().getResource("AfficherPartenaire.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setTitle("Hello World!");
         primaryStage.setScene(scene);
         primaryStage.show();
    }

    @FXML
    void ajouterCompte(ActionEvent event) throws IOException {  //partenaire
     Stage primaryStage=new Stage();
         Parent root= FXMLLoader.load(getClass().getResource("AjouterPartenaire.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setTitle("Hello World!");
         primaryStage.setScene(scene);
         primaryStage.show();   
    }

    @FXML
    void deconnecter(ActionEvent event) {

    }

    @FXML
    void modifierCompte(ActionEvent event) throws IOException {
        Stage primaryStage=new Stage();
         Parent root= FXMLLoader.load(getClass().getResource("modifierProfil.fxml"));
         Scene scene = new Scene(root);
         primaryStage.setTitle("Hello World!");
         primaryStage.setScene(scene);
         primaryStage.show();  
        
    }

    @FXML
    void supprimerCompte(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomPrenom.setText(userConnect.getNom()+""+userConnect.getPrenom());
        status.setText(userConnect.getStatut());
    }

}
