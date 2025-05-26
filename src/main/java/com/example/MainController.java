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

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class MainController {

    @FXML
    private ListView<Double> result_Listview;

    @FXML
    void initialize(){
       ArrayList<Cylinder> cylinders = Storage.readFile();
       for (Cylinder cylinder : cylinders) {
           result_Listview.getItems().addAll(cylinder.getSurface());
       }
    }

    @FXML
    private TextField height_Field;

    @FXML
    private TextField radius_Field;


    @FXML
    void onClick_calcButton(ActionEvent event) {
        startClick();
    }
    private void startClick(){
        if(radius_Field.getText().isEmpty() || height_Field.getText().isEmpty()){
            warning("Nem lehet üres az adat");
            clearFields();
            return;
        }
        if(!radius_Field.getText().matches("[0-9]+") || !height_Field.getText().matches("[0-9]+")){
            warning("Csak számok lehetnek");
            clearFields();
            return;
        }

        Double rad = Double.parseDouble(radius_Field.getText());
        Double hei = Double.parseDouble(height_Field.getText());
        Double surface = 2*Math.PI*rad*(rad+hei);
        surface = Math.round(surface * 100.0) / 100.0;

        String message = "Az adott henger felülete: "+String.valueOf(surface)+" cm^2";
        information("Eredmény", "Henger felülete", message);
        
        ArrayList<Cylinder> cylinders = new ArrayList<>();
        cylinders.add(new Cylinder(rad, hei, surface));

        Storage.writer(cylinders);

        for (Cylinder cylinder : cylinders) {
            result_Listview.getItems().addAll(cylinder.getSurface());
        }

        clearFields();
    }
    private void clearFields() {
        radius_Field.setText("");
        height_Field.setText("");
    }
    private void warning(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Figyelmeztetes");
        alert.setHeaderText("Figyelmeztetes");
        alert.setContentText(message);
        alert.show();
    }
    private void information(String title,String header,String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }

}
