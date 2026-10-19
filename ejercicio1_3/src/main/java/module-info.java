module com.minenana.ejercicio1_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.ejercicio1_3 to javafx.fxml;
    exports com.minenana.ejercicio1_3;
}
