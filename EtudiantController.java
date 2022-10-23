package ism.inscription.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.core.Fabrique;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EtudiantController implements Initializable {

    public void handleRetourHome() throws IOException {
        App.setRoot("home");
    }

    @FXML
    private ComboBox cbAnnee;

    @FXML
    private ComboBox cbClasse;

    @FXML
    private TableColumn<Etudiant, String> tblcId;

    @FXML
    private TableColumn<Etudiant, String> tblcMatricule;

    @FXML
    private TableColumn<Etudiant, String> tblcNomComplet;

    @FXML
    private TableColumn<Etudiant, String> tblcTuteur;

    @FXML
    private TableView<Etudiant> tblvEtudiant;

    public List<String> genererAnnee(){
        List<String> annees=new ArrayList<>();
        for (int i = 1992; i <=2050; i++) {
            annees.add(""+i);
        }
        return annees;
    }

    public List<String> genererClasse(){
        List<String> classes=new ArrayList<>();
        Fabrique.getService().listerClasse().forEach(cl->classes.add(cl.getLibelle()));
        return classes;
    }
   
    ObservableList etudiants=FXCollections.observableList(Fabrique.getService().listerEtudiant());
    ObservableList<String>classes=FXCollections.observableArrayList(genererClasse());
    ObservableList<String> annees=FXCollections.observableList(genererAnnee());

   


    @FXML
    public void handleFiltrerEtudiantsParAnnee() {
        String annee=cbAnnee.getSelectionModel().getSelectedItem().toString();
        ObservableList etudiantsParAnnee=FXCollections.observableList(Fabrique.getService().listerEtudiantInscritAnnee(annee));
        handleListerEtudiant(etudiantsParAnnee);
    }
    @FXML
    public void handleFiltrerEtudiantsParClasse() {
        String libelle=cbClasse.getSelectionModel().getSelectedItem().toString();
        Classe classe=Fabrique.getService().findClasseByLibelle(libelle);
        ObservableList etudiantsParClasse=FXCollections.observableList(Fabrique.getService().filtrerEtudiantInscritParClasse(classe));
        handleListerEtudiant(etudiantsParClasse);
    }
    

    @FXML
    public void handleInscrireEtudiant() throws IOException {
        App.setRoot("inscription");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
         handleListerEtudiant(etudiants);
         cbClasse.setItems(classes);
         cbAnnee.setItems(annees);
    }

    public void handleListerEtudiant(ObservableList list){
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcMatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
        tblvEtudiant.setItems(list);
    }

    public void handleReinscription() throws IOException{
        App.setRoot("reinscription");
    }


}
