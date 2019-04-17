package controllers;

import entite.Partenaire;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import service.partServ;

public class AffichPartController implements Initializable{
    boolean verif=false;

    @FXML
    private Button ajouter;

    @FXML
    private TableView<Partenaire> tableview;

    @FXML

    private TableColumn<Partenaire, String> name;

    @FXML
    private TableColumn<Partenaire, String> adress;

    @FXML
    private TableColumn<Partenaire, String> descr;
        @FXML
    private MenuItem update;

    @FXML
    void modifierPart(ActionEvent event) {
       Partenaire partenair = tableview.getSelectionModel().getSelectedItem();
       popup1.display(partenair);
       partServ pr= new partServ();
       ArrayList <Partenaire> list= (ArrayList<Partenaire>) pr.displayAll();
       ObservableList <Partenaire> obslit=FXCollections.observableArrayList(list);
       tableview.setItems(obslit);
       
               

    }

    @FXML
    private TableColumn<Partenaire, String> imag;

    @FXML
    void supprimerPart(ActionEvent event) {
        int reply=JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete project", JOptionPane.YES_NO_OPTION);
            if(reply==JOptionPane.YES_OPTION){
            
            
         Partenaire p=new Partenaire();
            p= tableview.getSelectionModel().getSelectedItem();
            System.out.println(p);
            int x=p.getId();
            partServ pservice=new partServ();
            pservice.delete(p);
            System.out.println("c bonnnnnnnn");  
            verif=true;
            if(verif==true){
                tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItem());
     }
            }  }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        partServ parte = new partServ();
        ArrayList <Partenaire> list = (ArrayList <Partenaire> ) parte.displayAll();
        ObservableList <Partenaire> obslist=  FXCollections.observableArrayList(list);
        name.setCellValueFactory(new PropertyValueFactory <>("nom"));
        adress.setCellValueFactory(new PropertyValueFactory <>("adresse"));
        descr.setCellValueFactory(new PropertyValueFactory <>("description"));
        imag.setCellValueFactory(new PropertyValueFactory <>("image"));
        tableview.setItems(obslist);
        
        
        
        
    }

}
