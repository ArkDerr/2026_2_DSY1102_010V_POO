module cl.duoc.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens cl.duoc.demo1 to javafx.fxml;
    exports cl.duoc.demo1;
}