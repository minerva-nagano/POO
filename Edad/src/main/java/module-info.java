module com.minenana.edad {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.edad to javafx.fxml;
    exports com.minenana.edad;
}
