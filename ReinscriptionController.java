package ism.inscription.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.core.Fabrique;
import ism.inscription.entities.Classe;
import ism.inscription.entities.Etat;
import ism.inscription.entities.Etudiant;
import ism.inscription.entities.Inscription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
public class ReinscriptionController implements Initializable {


    @FXML
    private TextField txtAnnee;

    @FXML
    Text lblErrorClasse;

    @FXML
    Text lblErrorEtudiant;

    @FXML
    private TextField txtClasse;

    @FXML
    private TextField txtNomComplet;
    @FXML
    private TextField txtMatricule;

    ObservableList etudiants=FXCollections.observableList(Fabrique.getService().listerEtudiant());


    @FXML
    void handleCreerEtudiant() {

        String annee=txtAnnee.getText().trim();
        String libelle=txtClasse.getText().trim();
        String nomComplet=txtNomComplet.getText().trim();
        String matricule=txtMatricule.getText().trim();
        Inscription inscription=new Inscription(annee, Etat.Inscrit);
        Classe classe = Fabrique.getService().findClasseByLibelle(libelle);
        Etudiant etu =Fabrique.getService().findByName(nomComplet);
        if (classe==null && etu==null) {
            lblErrorClasse.setVisible(true); 
            lblErrorEtudiant.setVisible(true);
        }else if(etu==null){
            lblErrorEtudiant.setVisible(true);
            lblErrorClasse.setVisible(false);
        }else if (classe==null) {
            lblErrorClasse.setVisible(true); 
            lblErrorEtudiant.setVisible(false);
        } else {
            Etudiant etudiant =Fabrique.getService().reinscrireEtudiant(inscription, classe, etu); 
            Alert alert= new Alert(AlertType.INFORMATION);
            alert.setTitle("Gestion Etudiant");
            alert.setContentText("un(e) etudiant(e) à été ajouté(e) avec succés");
            alert.show();
            etudiants.add(etudiant);
            txtAnnee.clear();
            txtClasse.clear();
            txtNomComplet.clear();
           
            try {
                handleGoBack();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
       
    }

    @FXML
    void handleGoBack() throws IOException {
        App.setRoot("etudiant");
       
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblErrorClasse.setVisible(false);
        lblErrorEtudiant.setVisible(false);
        
    }
}

    

