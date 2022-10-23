module ism.inscription {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;
    requires com.fasterxml.jackson.databind;

    opens ism.inscription.controllers to javafx.fxml;
    exports ism.inscription;
    exports ism.inscription.entities;
}
