package com.minenana.edad;

import java.time.LocalDate;
import java.time.Period;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML private DatePicker dateNacimiento;
    @FXML private Label lbResultado;

    @FXML
    private void CalcularFecha() {
        LocalDate fechaNacimiento = dateNacimiento.getValue();
        if (fechaNacimiento == null) {
            lbResultado.setText("Por favor, selecciona una fecha.");
            return;
        }
        
        LocalDate hoy = LocalDate.now();
        
        if(fechaNacimiento.isAfter(hoy)){
            lbResultado.setText("La fecha no puede ser futura.");
            return;
        }
        
        int anios = Period.between(fechaNacimiento, hoy).getYears();
        lbResultado.setText("Tiene " + anios + " años.");
    }
    @FXML private void LimpiarFecha(){
        dateNacimiento.setValue(null);
    }
}