package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearController implements Initializable {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;


    @FXML
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Seleccione el Tipo","Alumno","Profesor");
        cmbTipoPersona.getSelectionModel().selectFirst();
    }
}
