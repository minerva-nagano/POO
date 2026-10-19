module com.minenana.desglose {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.desglose to javafx.fxml;
    exports com.minenana.desglose;
}
