module com.stackoverflow.displaydemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.stackoverflow.displaydemo to javafx.fxml;
    exports com.stackoverflow.displaydemo;
}