package com.minenana.ejercicio1_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtNumero;
    
    @FXML
    private TextArea txtResultado;

    @FXML
    private void handleCalcular(ActionEvent event) {
        int numero = Integer.parseInt(txtNumero.getText());
        StringBuilder tabla = new StringBuilder();
        
        for (int i = 1; i <= 10; i++) {
            tabla.append(numero).append("x").append(i).append(" = ").append(numero * i).append("\n");
        }
        
        txtResultado.setText(tabla.toString());
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtNumero.clear();
        txtResultado.clear();
    }
}