module com.minenana.escuela_ejercicio2_1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.escuela_ejercicio2_1 to javafx.fxml;
    exports com.minenana.escuela_ejercicio2_1;
}
