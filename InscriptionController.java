package ism.inscription.controllers;

import java.io.IOException;

import ism.inscription.App;
import ism.inscription.entities.core.Fabrique;
import ism.inscription.entities.Etat;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class InscriptionController  {

    @FXML
    private TextField txtAnnee;
    @FXML
    private TextField txtClasse;

    
    @FXML
    private TextField txtMatricule;

    @FXML
    private TextField txtNomComplet;

    @FXML
    private TextField txtTuteur;


    ObservableList etudiants=FXCollections.observableList(Fabrique.getService().listerEtudiant());
    
    @FXML
    void handleCreerEtudiant() {

        String annee=txtAnnee.getText().trim();
        String libelle=txtClasse.getText().trim();

        String matricule=txtMatricule.getText().trim();
        String nomComplet=txtNomComplet.getText().trim();
        String tuteur=txtTuteur.getText().trim();
        Etudiant etudiant =Fabrique.getService().inscrireEtudiant(new Inscription(annee, Etat.Inscrit), 
                                                           Fabrique.getService().findClasseByLibelle(libelle), 
                                                                new Etudiant(matricule,nomComplet, tuteur));
                                                                 
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Gestion Etudiant");
        alert.setContentText("un(e) etudiant(e) à été inscrit(e) avec succés");
        alert.show();
        etudiants.add(etudiant);
        txtAnnee.clear();
        txtNomComplet.clear();
        txtTuteur.clear();
        try {
            handleGoBack();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

   

    @FXML
    void handleGoBack() throws IOException {
        App.setRoot("etudiant");
       
    }

   

}
