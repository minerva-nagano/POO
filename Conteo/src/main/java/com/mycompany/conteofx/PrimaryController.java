package com.mycompany.conteofx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtConteo;
    @FXML
    private Button btnContar;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button btnEsperar;

    private int contador = 0;

    @FXML
    private void handleContarAction() {
        contador++;
        txtConteo.setText(String.valueOf(contador));
    }

    @FXML
    private void handleEsperarAction() {
        // 1. Preparar la UI (Deshabilitar botón, reiniciar barra)
        btnEsperar.setDisable(true);
        progressBar.setProgress(0);

        // 2. Crear el hilo secundario (El "cocinero")
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Este código corre en un hilo secundario (NO congela la ventana)
                    for (int i = 0; i <= 100; i++) {
                        Thread.sleep(100); // 100 ms * 100 = 10 segundos
                        
                        // 3. La "campanilla" para actualizar la UI de forma segura
                        final double progreso = i / 100.0; // JavaFX usa de 0.0 a 1.0
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setProgress(progreso);
                            }
                        });
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    // 4. Al terminar, habilitar el botón de nuevo
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            btnEsperar.setDisable(false);
                        }
                    });
                }
            }
        });

        // 5. Encender el hilo (start, NO run)
        hilo.setDaemon(true); // Para que muera si cierras la ventana
        hilo.start();
    }
}