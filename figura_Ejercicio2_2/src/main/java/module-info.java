module com.minenana.figura_ejercicio2_2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.figura_ejercicio2_2 to javafx.fxml;
    exports com.minenana.figura_ejercicio2_2;
}
