package com.minenana.desglose;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField txtDinero;
    
    @FXML private TextField txt500, txt200, txt100, txt50, txt20, txt10, txt5, txt2, txt1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handleDesglosar(ActionEvent event) {
        int dinero = Integer.parseInt(txtDinero.getText());

        int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        
        TextField[] camposTexto = {txt500, txt200, txt100, txt50, txt20, txt10, txt5, txt2, txt1};

        for (int i = 0; i < denominaciones.length; i++) {
            int cantidad = dinero / denominaciones[i];
            
            camposTexto[i].setText(String.valueOf(cantidad));
            
            dinero = dinero % denominaciones[i];
        }
    }

    @FXML
    private void handleLimpiar(ActionEvent event) {
        txtDinero.clear();
        
        txt500.clear();
        txt200.clear();
        txt100.clear();
        txt50.clear();
        txt20.clear();
        txt10.clear();
        txt5.clear();
        txt2.clear();
        txt1.clear();
    }
}