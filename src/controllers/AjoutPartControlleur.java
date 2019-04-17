package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import service.partServ;
import entite.Partenaire;
import javax.swing.JOptionPane;

public class AjoutPartControlleur {

    @FXML
    private TextField txt_NomP;

    @FXML
    private TextField txt_Adresse;

    @FXML
    private TextField txt_Desc;

    @FXML
    private Button ajoutPart;

    @FXML
    private PasswordField txt_image;

    @FXML
    void ajouterPartenaire(ActionEvent event) {
        partServ par = new partServ();
        par.insert(new Partenaire(txt_NomP.getText(),txt_Adresse.getText(),txt_Desc.getText(),txt_image.getText()));
        JOptionPane.showMessageDialog(null, "partenaire ajouté avec succes");

    }

}
