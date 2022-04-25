module com.example.primefinderserver.primefinderserver {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.primefinderserver.primefinderserver to javafx.fxml;
    exports com.example.primefinderserver.primefinderserver;
}