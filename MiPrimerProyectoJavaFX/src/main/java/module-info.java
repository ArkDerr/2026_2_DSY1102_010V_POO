module cl.duoc.miprimerproyectojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens cl.duoc.miprimerproyectojavafx to javafx.fxml;
    opens cl.duoc.miprimerproyectojavafx.controller to javafx.fxml;
    exports cl.duoc.miprimerproyectojavafx;
    exports cl.duoc.miprimerproyectojavafx.util;
    opens cl.duoc.miprimerproyectojavafx.util to javafx.fxml;

    opens cl.duoc.miprimerproyectojavafx.model to javafx.base;
}