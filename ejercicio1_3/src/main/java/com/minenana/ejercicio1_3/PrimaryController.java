package com.minenana.ejercicio1_3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txtNumero;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtSumaImpares;
    @FXML private TextField txtSumaPares;
    @FXML private TextField txtSumaTotal;
    @FXML private TextField txtMayor;
    @FXML private TextField txtMenor;
    @FXML private ListView<Integer> listDivisores;

    @FXML
    private void handleAnalizar(ActionEvent event) {
        int numero = Integer.parseInt(txtNumero.getText());
        String numStr = String.valueOf(numero);
        
        int cantidad = numStr.length();
        int sumaImpares = 0;
        int sumaPares = 0;
        int sumaTotal = 0;
        int mayor = 0;
        int menor = 9;

        for (int i = 0; i < numStr.length(); i++) {
            int digito = Character.getNumericValue(numStr.charAt(i));
            sumaTotal += digito;
            
            if (digito % 2 == 0) {
                sumaPares += digito;
            } else {
                sumaImpares += digito;
            }
            
            if (digito > mayor) {
                mayor = digito;
            }
            if (digito < menor) {
                menor = digito;
            }
        }

        ObservableList<Integer> divisores = FXCollections.observableArrayList();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }

        txtCantidad.setText(String.valueOf(cantidad));
        txtSumaImpares.setText(String.valueOf(sumaImpares));
        txtSumaPares.setText(String.valueOf(sumaPares));
        txtSumaTotal.setText(String.valueOf(sumaTotal));
        txtMayor.setText(String.valueOf(mayor));
        txtMenor.setText(String.valueOf(menor));
        
        listDivisores.setItems(divisores);
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtNumero.clear();
        txtCantidad.clear();
        txtSumaImpares.clear();
        txtSumaPares.clear();
        txtSumaTotal.clear();
        txtMayor.clear();
        txtMenor.clear();
        listDivisores.getItems().clear();
    }
}