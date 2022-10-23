package ism.inscription.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ism.inscription.App;
import ism.inscription.entities.User;
import ism.inscription.entities.core.Fabrique;
import ism.inscription.entities.core.Validator;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;

public class ConnexionController implements Initializable {

    
    @FXML
    Text lblError,lblErrorLogin,lblErrorPassword;
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField txtPassword;
    @FXML
    Button btnConnexion;
   /*  @FXML
    private ImageView ismImageView; */
     

    SimpleBooleanProperty smpl=new SimpleBooleanProperty(true);


    
    public static User user;
    @Override
    public void initialize(URL location, ResourceBundle ressources) {
        /* File pxFile = new File("px/ism1.jpg");
        Image pxImage = new Image(pxFile.toURI().toString());
        ismImageView.setImage(pxImage);
  */
       
    lblError.setVisible(false);
    lblErrorLogin.setVisible(false);
    lblErrorPassword.setVisible(false);
    txtLogin.textProperty().addListener((obV, old, newV) -> {
        if(newV.isEmpty()){
            lblErrorLogin.setVisible(true);
        }else{
            if(!Validator.isEmail(newV)){
                lblErrorLogin.setText("Veuillez saisir un email");
                lblErrorLogin.setVisible(true);
            }else{
                smpl.set(txtPassword.getText().isEmpty());
                lblErrorLogin.setVisible(false);
            }
        }
    });
       txtPassword.textProperty().addListener((obv, old, newV) ->{
        if(newV.isEmpty()){
            lblErrorPassword.setVisible(true);
        }else{
            smpl.set(Validator.isEmail(txtLogin.getText()));
            lblErrorPassword.setVisible(false);
        }
       } );
       btnConnexion.disableProperty().bind(smpl);
        
    }
    public void handleConnexion() throws IOException{
       String login =txtLogin.getText().trim();
       String password =txtPassword.getText().trim();
       user=Fabrique.getService().seConnecter(login, password);
       if(user==null){
        lblError.setVisible(true);
       }else{
        App.setRoot("debut");
       }
    }
    
} 
    
