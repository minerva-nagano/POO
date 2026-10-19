module com.minenana.gastos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.minenana.gastos to javafx.fxml;
    exports com.minenana.gastos;
}
