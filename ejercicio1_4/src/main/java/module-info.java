module com.minenana.ejercicio1_4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.ejercicio1_4 to javafx.fxml;
    exports com.minenana.ejercicio1_4;
}
