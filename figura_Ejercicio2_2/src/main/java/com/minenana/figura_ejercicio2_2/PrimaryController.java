package com.minenana.figura_ejercicio2_2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private TextArea txtSalida;

    @FXML
    private void handleEjecutar(ActionEvent event) {
        StringBuilder sb = new StringBuilder();

        Figuras2D f = new TrianguloRecto(3, 4);
        sb.append(f.imprimeFigura()).append("\n\n");

        f = new Circulo(3);
        sb.append(f.imprimeFigura()).append("\n");

        txtSalida.setText(sb.toString());
    }
}