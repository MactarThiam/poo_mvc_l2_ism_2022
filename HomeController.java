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


    

    public class HomeController implements Initializable{
        @FXML
        AnchorPane anchorContent;
        @FXML
        Button  btnMenuClasse, btnMenuProfesseur,btnMenuEtudiant;
        
    
        public void handleDeconnexion() throws IOException{
            App.setRoot("connexion");
            
        }
        public void handleHome() throws IOException{
            App.setRoot("debut");
        }
        
        public void handleLoadViewClasse() throws IOException{
            this.loadView("classe");
        }
        
        public void handleLoadViewProfesseur() throws IOException {
            this.loadView("professeur");
        }
        public void handleLoadViewEtudiant() throws IOException {
            this.loadView("etudiant");
        }
    
        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
    
            try {
                if(ConnexionController.user.getRole()==Role.RP){
                  isRP();
                  this.loadView("classe");}else{
                  isAC();
                  this.loadView("etudiant");}
                
               
            } catch (IOException e) {
                
                e.printStackTrace();
            }
            
        }
    
        private void loadView(String fxml) throws IOException{
            AnchorPane root = (AnchorPane) App.loadFXML(fxml);  
            anchorContent.getChildren().clear();
            anchorContent.getChildren().add(root);
        }

        private void isRP(){
            btnMenuProfesseur.setDisable(false);
            btnMenuClasse.setDisable(false);
        }
        private void isAC(){
            btnMenuEtudiant.setDisable(false);
        }
        
    
}



