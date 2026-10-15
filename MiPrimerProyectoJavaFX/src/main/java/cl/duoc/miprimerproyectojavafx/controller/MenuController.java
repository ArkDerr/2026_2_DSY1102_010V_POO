package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {
    @FXML
    private void onSalirButtonClick() {
        Platform.exit();
    }

    @FXML
    private void onCrearButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"crear-view.fxml","Formulario Persona");
    }

    @FXML
    private void onBuscarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"buscar-view.fxml","Buscar Persona");
    }

    @FXML
    private void onEditarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"editar-view.fxml","Editar Persona");
    }

    @FXML
    private void onEliminarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"eliminar-view.fxml","Eliminar Persona");
    }

    @FXML
    private void onListarButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"listar-view.fxml","Listar Persona");
    }

}
