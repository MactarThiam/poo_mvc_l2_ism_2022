package ism.inscription.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.Role;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class DebutController implements Initializable {

    @FXML
    Button btnMenuClasse,  btnMenuProfesseur,btnMenuEtudiant;
 @FXML
AnchorPane anchorContent;


public void handleDeconnexion() throws IOException{
    App.setRoot("connexion");
    
}

    public void handleLoadViewClasse() throws IOException{
        App.setRoot ("classe");
    }

    public void handleLoadViewProfesseur() throws IOException {
        App.setRoot("professeur");
    }
    public void handleLoadViewEtudiant() throws IOException {
        App.setRoot("etudiant");
    }
    public void handleLoadViewHome() throws IOException {
        App.setRoot("home");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        try {
            if(ConnexionController.user.getRole()==Role.RP){
              isRP();
            }
            App.setRoot("etudiant");
            if(ConnexionController.user.getRole()==Role.AC){
                isAC();
            }
            App.setRoot("classe");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
    private void isRP(){
        btnMenuProfesseur.setDisable(false);
        btnMenuClasse.setDisable(false);
    }
    private void isAC(){
        btnMenuEtudiant.setDisable(false);
    }
    
    }
    

