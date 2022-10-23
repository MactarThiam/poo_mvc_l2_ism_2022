package ism.inscription.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.Classe;
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



public class ProfesseurController implements Initializable {
    List<Classe> classes=new ArrayList<>();
    public void handleRetourHome() throws IOException {
        App.setRoot("home");
    }

  
    @FXML
    TableView<Professeur> tblvProfesseur = new TableView<>();
    @FXML
    TableColumn<Professeur,String> tblcId  = new TableColumn<>();
    @FXML
    TableColumn<Professeur, String> tblcNci = new TableColumn<>();
    @FXML
    TableColumn<Professeur, String> tblcNomComplet = new TableColumn<>();
    @FXML
    TableColumn<Professeur, String> tblcGrade = new TableColumn<>();
    @FXML
    TextField txtNci;
    @FXML
    TextField txtNomComplet;
    @FXML
    TextField txtGrade;
    @FXML
    Text lblErrorNci,lblErrorGrade,lblErrorNomComplet;
    @FXML
    Button btnSaveProfesseur;


    @FXML 
    TableView<Classe> tblvClasse = new TableView<>();
    @FXML
    TableColumn<Classe,String> tblcIdClasse  = new TableColumn<>();
    @FXML
    TableColumn<Classe, String> tblcLibelleClasse = new TableColumn<>();
    @FXML
    ComboBox<Classe> cbxClasseAffecter = new ComboBox<>();

    SimpleBooleanProperty smpl=new SimpleBooleanProperty(true);

    ObservableList obProfesseurs = FXCollections.observableList(Fabrique.getService().listerProfesseur());
    ObservableList obClasse=  FXCollections.observableList(Fabrique.getService().listerProfesseur());



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
         
        txtNci.textProperty().addListener((obv, old, newV) ->{
            if(newV.isEmpty()){
                lblErrorNci.setVisible(true);
            }else{
                smpl.set(Validator.isProf(txtNci.getText()));
                lblErrorNci.setVisible(false);
            }
           } );
           txtGrade.textProperty().addListener((obv, old, newV) ->{
            if(newV.isEmpty()){
                lblErrorGrade.setVisible(true);
            }else{
                smpl.set(Validator.isProf(txtGrade.getText()));
                lblErrorGrade.setVisible(false);
            }
           } );
           txtNomComplet.textProperty().addListener((obv, old, newV) ->{
            if(newV.isEmpty()){
                lblErrorNomComplet.setVisible(true);
            }else{
                smpl.set(Validator.isNomComplet(txtNomComplet.getText()));
                lblErrorNomComplet.setVisible(false);
            }
           } );
           btnSaveProfesseur.disableProperty().bind(smpl); 
        
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNci.setCellValueFactory(new PropertyValueFactory<>("nci"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        
        tblvProfesseur.setItems(obProfesseurs);

       cbxClasseAffecter.setItems(FXCollections.observableList(Fabrique.getService().listerClasse()));
    }

       public void handleFiltrerClasseProfesseur(){

        Professeur professeur = tblvProfesseur.getSelectionModel().getSelectedItem();

        if(professeur!=null){
           obClasse=FXCollections.observableList(Fabrique.getService().listerClasseProfesseur(professeur)); 
        
           tblcIdClasse.setCellValueFactory(new PropertyValueFactory<>("id"));
           tblcLibelleClasse.setCellValueFactory(new PropertyValueFactory<>("libelle"));

           tblvClasse.setItems(obClasse);
        }

       }
       public void handleCreerProfesseur(){
        String nci = txtNci.getText().trim();
        String nomComplet = txtNomComplet.getText().trim();
        String grade = txtGrade.getText().trim();
        Professeur professeur = Fabrique.getService().ajouterProfesseur(new Professeur(nci,nomComplet,grade));

        //Creer une alerte 
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Inscription");
        alert.setContentText("Un Professeur a été ajouter avec succès");
        alert.show();
        obProfesseurs.add(professeur);
        txtNci.clear();
        txtNomComplet.clear();
        txtGrade.clear();
       }

       public void handleAffecterClasseProfesseur(){

        Classe classe= cbxClasseAffecter.getSelectionModel().getSelectedItem();
        Professeur professeur= tblvProfesseur.getSelectionModel().getSelectedItem();

        if(classe!=null & professeur!=null){

            Fabrique.getService().affecterClasseProfesseur(professeur, classe);

            Alert alert =new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Inscription");
            alert.setContentText("un professeur a bien été affecté");
            alert.show();
        }
       }
        
        
        
       
    
    
     

        

   
   public void handleCreer() throws IOException {
     App.setRoot("AjouterProfesseur");
}
}
   
      

    

