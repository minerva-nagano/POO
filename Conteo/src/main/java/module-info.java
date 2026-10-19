module com.mycompany.conteofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.conteofx to javafx.fxml;
    exports com.mycompany.conteofx;
}
