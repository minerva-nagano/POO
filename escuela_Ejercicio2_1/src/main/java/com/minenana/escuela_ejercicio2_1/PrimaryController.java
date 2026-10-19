package com.minenana.escuela_ejercicio2_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class PrimaryController {

    @FXML
    private TextArea salida;

    @FXML
    private void handleEjecutar(ActionEvent event) {
        StringBuilder sb = new StringBuilder();

        Alumno a = new Alumno();
        Profesor p = new Profesor(10008000);

        sb.append("Se crea Alumno...\n");
        sb.append(a.toString()).append("\n");
        sb.append(p.toString()).append("\n");

        salida.setText(sb.toString());
    }
}