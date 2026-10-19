package com.minenana.gastos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txtAlimentacion;
    @FXML private TextField txtRefrigerios;
    @FXML private TextField txtTransporte;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtOtros;
    @FXML private TextField txtTotal;
    @FXML private TextField txtGastoMasAlto;

    @FXML
    private void handleCalcular(ActionEvent event) {
        double al = Double.parseDouble(txtAlimentacion.getText());
        double re = Double.parseDouble(txtRefrigerios.getText());
        double tr = Double.parseDouble(txtTransporte.getText());
        double te = Double.parseDouble(txtTelefono.getText());
        double ot = Double.parseDouble(txtOtros.getText());

        double total = al + re + tr + te + ot;
        txtTotal.setText(String.valueOf(total));

        double[] gastos = {al, re, tr, te, ot};
        String[] categorias = {"Alimentación", "Refrigerios", "Transporte", "Teléfono", "Otros"};
        
        double mayor = gastos[0];
        String catMayor = categorias[0];

        for (int i = 1; i < gastos.length; i++) {
            if (gastos[i] > mayor) {
                mayor = gastos[i];
                catMayor = categorias[i];
            }
        }

        txtGastoMasAlto.setText(catMayor);
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtAlimentacion.clear();
        txtRefrigerios.clear();
        txtTransporte.clear();
        txtTelefono.clear();
        txtOtros.clear();
        txtTotal.clear();
        txtGastoMasAlto.clear();
    }
}