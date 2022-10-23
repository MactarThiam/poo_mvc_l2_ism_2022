package ism.inscription.controllers;




    


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Professeur;
import ism.inscription.entities.core.Fabrique;
import ism.inscription.entities.core.Validator;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;



public class AjouterProfesseurController implements Initializable {
    List<Classe> classes=new ArrayList<>();

  
    @FXML
    TableView<Professeur> tblvProfesseur = new TableView<>();
    @FXML
    TableColumn<Professeur,String> tblcId  = new TableColumn<>();
    @FXML
    TableColumn<Professeur, String> tblcMatricule = new TableColumn<>();
    @FXML
    TableColumn<Professeur, String> tblcNomComplet = new TableColumn<>();
    @FXML
    TableColumn<Professeur, String> tblcTuteur = new TableColumn<>();
    @FXML
    TextField txtMatricule;
    @FXML
    TextField txtNomComplet;
    @FXML
    TextField txtTuteur;

    @FXML
    Text lblErrorNci,lblErrorGrade,lblErrorNomComplet;
    @FXML
    Button btnSaveProfesseur;
   

    SimpleBooleanProperty smpl=new SimpleBooleanProperty(true);

    ObservableList obEtudiants = FXCollections.observableList(Fabrique.getService().listerEtudiant());
    



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       

       
        
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcMatricule.setCellValueFactory(new PropertyValueFactory<>("nci"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        tblvProfesseur.setItems(obEtudiants);
        
       
    
    }
    public void handleCreerProfesseur(){
        String matricule = txtMatricule.getText().trim();
        String nomComplet = txtNomComplet.getText().trim();
        String tuteur = txtTuteur.getText().trim();
        Etudiant etudiant = Fabrique.getService().ajouterEtudiant(new Etudiant(matricule,nomComplet,tuteur));

        //Creer une alerte 
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Inscription");
        alert.setContentText("Un Professeur a été ajouter avec succès");
        alert.show();
        obEtudiants.add(etudiant);
        txtMatricule.clear();
        txtNomComplet.clear();
        txtTuteur.clear();
       
              

   } 
   public void handleRetour() throws IOException {
     App.setRoot("Professeur");
}
   
      
}
    



