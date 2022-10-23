package ism.inscription.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.Classe;
import ism.inscription.entities.core.Fabrique;
import ism.inscription.entities.core.Validator;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class ClasseController implements Initializable {

    public void handleRetourHome() throws IOException {
        App.setRoot("home");
    }
    @FXML
    TableView<Classe> tblvClasse = new TableView<>();
    @FXML
    TableColumn<Classe,String> tblcId  = new TableColumn<>();
    @FXML
    TableColumn<Classe, String> tblcLibelle = new TableColumn<>();
    @FXML
    TextField txtLibelle;
    @FXML
    Text lblErrorLibelle;
    @FXML
    Button btnEnregistrerLibelle;
    SimpleBooleanProperty smpl=new SimpleBooleanProperty(true);
    ObservableList obClasses = FXCollections.observableList(Fabrique.getService().listerClasse());



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        txtLibelle.textProperty().addListener((obv, old, newV) ->{
            if(newV.isEmpty()){
                lblErrorLibelle.setVisible(true);
            }else{
                smpl.set(Validator.isLibelle(txtLibelle.getText()));
                lblErrorLibelle.setVisible(false);
            }
           } );
           btnEnregistrerLibelle.disableProperty().bind(smpl);
            
        
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        tblvClasse.setItems(obClasses);
        
    }
    public void handleCreerClasse(){
        String libelle = txtLibelle.getText().trim();
        Classe classe = Fabrique.getService().creerClasse(new Classe(libelle));

        //Creer une alerte 
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Inscription");
        alert.setContentText("Une Classe a été ajouté avec succès");
        alert.show();
        obClasses.add(classe);
        txtLibelle.clear();
              
     
   }
   
      
}
