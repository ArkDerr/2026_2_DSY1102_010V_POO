package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CrearController {
    @FXML
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }
}
