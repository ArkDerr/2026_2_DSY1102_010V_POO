package cl.duoc.aurora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

/**
 * Aplicación JavaFX: carga la vista que el estudiante creará con Scene Builder.
 * No es necesario modificar esta clase.
 */
public class App extends Application {

    /** Ubicación esperada de la vista FXML en src/main/resources. */
    private static final String VISTA_PRINCIPAL = "/cl/duoc/aurora/view/main-view.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        URL vista = App.class.getResource(VISTA_PRINCIPAL);
        if (vista == null) {
            throw new IllegalStateException("No se encontró la vista principal: " + VISTA_PRINCIPAL);
        }
        Parent root = FXMLLoader.load(vista);
        stage.setTitle("Biblioteca Aurora");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
