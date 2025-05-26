/*
* File: MainController.java
* Author: Pók László
* Copyright: 2025, Pók László
* Group: Szoft I/N
* Date: 2025-05-26
* Github: https://github.com/poklaszlo/
* Licenc: MIT
*/
package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainController {

    @FXML
    private TableColumn<?, ?> AreaCol;

    @FXML
    private TableColumn<?, ?> AreaCol1;

    @FXML
    private TableColumn<?, ?> heiCol;

    @FXML
    private TextField height_Field;

    @FXML
    private TableColumn<?, ?> radCol;

    @FXML
    private TextField radius_Field;

    @FXML
    private TableView<String> resultTable;

    @FXML
    void onClick_calcButton(ActionEvent event) {
        Double rad = radius_Field.getText().isEmpty() ? 0 : Double.parseDouble(radius_Field.getText());
        Double hei = height_Field.getText().isEmpty() ? 0 : Double.parseDouble(height_Field.getText());
        Double surface = 2*Math.PI*rad*(rad+hei);
        surface = Math.round(surface * 100.0) / 100.0;

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Eredmény");
        alert.setHeaderText("Felület");
        alert.setContentText("Az adott henger felülete: "+String.valueOf(surface)+" cm^2");
        alert.show();

        clearFields();        
    }
    private void clearFields() {
        radius_Field.setText("");
        height_Field.setText("");
    }

}
