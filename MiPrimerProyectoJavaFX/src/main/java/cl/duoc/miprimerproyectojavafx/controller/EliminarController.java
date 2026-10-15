package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class EliminarController {
    @FXML
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }
}
