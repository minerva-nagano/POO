import javax.swing.*;
import java.awt.*;

public class FabulasEesopo extends JFrame {

    private JProgressBar barraLiebre;
    private JProgressBar barraTortuga;
    private JLabel lblEstadoLiebre;
    private JLabel lblEstadoTortuga;
    private JButton btnIniciar;

    public FabulasEesopo() {
        setTitle("Fábulas gráficas de Esopo");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // --- Título ---
        JLabel lblTitulo = new JLabel("La Liebre y la Tortuga", SwingConstants.CENTER);
        lblTitulo.setBounds(100, 20, 250, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblTitulo);

        // --- Botón Iniciar ---
        btnIniciar = new JButton("¡Iniciar Carrera!");
        btnIniciar.setBounds(140, 70, 150, 30);
        add(btnIniciar);

        // --- Sección Liebre ---
        lblEstadoLiebre = new JLabel("La Liebre: Esperando...", SwingConstants.CENTER);
        lblEstadoLiebre.setBounds(100, 130, 250, 25);
        add(lblEstadoLiebre);

        barraLiebre = new JProgressBar(0, 100);
        barraLiebre.setBounds(50, 160, 350, 25);
        barraLiebre.setStringPainted(false);
        add(barraLiebre);

        // --- Sección Tortuga ---
        lblEstadoTortuga = new JLabel("La Tortuga: Esperando...", SwingConstants.CENTER);
        lblEstadoTortuga.setBounds(100, 220, 250, 25);
        add(lblEstadoTortuga);

        barraTortuga = new JProgressBar(0, 100);
        barraTortuga.setBounds(50, 250, 350, 25);
        barraTortuga.setStringPainted(false);
        add(barraTortuga);

        // --- Evento del Botón ---
        btnIniciar.addActionListener(e -> iniciarCarrera());
    }

    private void iniciarCarrera() {
        // 1. Deshabilitar botón y reiniciar barras y textos
        btnIniciar.setEnabled(false);
        barraLiebre.setValue(0);
        barraTortuga.setValue(0);
        lblEstadoLiebre.setText("La Liebre: ¡Lista!");
        lblEstadoTortuga.setText("La Tortuga: ¡Lista!");

        // 2. Hilo de la Tortuga (Lenta pero constante)
        Thread hiloTortuga = new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(150); // Se toma su tiempo (150ms * 100 = 15 seg)
                    final int progreso = i;
                    
                    // Actualizamos la UI de forma segura
                    SwingUtilities.invokeLater(() -> {
                        barraTortuga.setValue(progreso);
                        lblEstadoTortuga.setText("La Tortuga: ¡Está corriendo!");
                    });
                }
                SwingUtilities.invokeLater(() -> lblEstadoTortuga.setText("La Tortuga: ¡Llegó a la meta!"));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        // 3. Hilo de la Liebre (Rápida pero se duerme)
        Thread hiloLiebre = new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    // Se duerme un poco para que la barra se llene visualmente
                    Thread.sleep(50); 
                    final int progreso = i;
                    
                    SwingUtilities.invokeLater(() -> {
                        barraLiebre.setValue(progreso);
                        lblEstadoLiebre.setText("La Liebre: ¡Está corriendo!");
                    });

                    // ¡AQUÍ ESTÁ LA TRAMPA DEL ENUNCIADO!
                    // Si llega al 60%, se duerme por 3 segundos (3000 ms)
                    if (i == 30) {
                        SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Se durmió!"));
                        Thread.sleep(4000); // 4 segundos de siesta
                        SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Despertó y corre!"));
                    }
                     if (i == 60) {
                        SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Se durmió!"));
                        Thread.sleep(4000); // 4 segundos de siesta
                        SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Despertó y corre!"));
                    }
                    if (i == 90) {
                        SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Se durmió!"));
                        Thread.sleep(4000); // 4 segundos de siesta
                        SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Despertó y corre!"));
                    }
                }
                SwingUtilities.invokeLater(() -> lblEstadoLiebre.setText("La Liebre: ¡Llegó a la meta!"));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        // 4. Arrancar ambos hilos
        hiloTortuga.start();
        hiloLiebre.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FabulasEesopo().setVisible(true));
    }
}