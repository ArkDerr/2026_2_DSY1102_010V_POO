package cl.duoc.miprimerproyectojavafx.util;

import cl.duoc.miprimerproyectojavafx.MantenedorApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navegacion {
    public static void cambiarVista(ActionEvent event, String archivoFxml, String titulo) throws IOException {
        Parent root = FXMLLoader.load(MantenedorApplication.class.getResource("/cl/duoc/miprimerproyectojavafx/view/" + archivoFxml));
        Stage stage = (Stage) ((Node) event.getSource())
                .getScene()
                .getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(titulo);
        stage.show();
    }
}
