package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Alumno;
import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.model.Profesor;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    private final PersonaRepository repository = PersonaRepository.getInstancia();


    @FXML
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Alumno","Profesor");
        cmbTipoPersona.getSelectionModel().selectFirst();
    }

    @FXML
    private void onGuardarButtonClick(ActionEvent event) throws IOException {
        try{
            Persona nuevaPersona;
            if ("Alumno".equals(cmbTipoPersona.getSelectionModel().getSelectedItem())){
                nuevaPersona = new Alumno(
                    txtRut.getText(),
                    txtNombre.getText(),
                    txtApellido.getText(),
                    dpFechaNacimiento.getValue()
                );
            } else {
                nuevaPersona = new Profesor(
                        txtRut.getText(),
                        txtNombre.getText(),
                        txtApellido.getText(),
                        dpFechaNacimiento.getValue()
                );
            }

            repository.agregar(nuevaPersona);

            mostrarAlerta(Alert.AlertType.INFORMATION,"Registro Creado","Registro creado de manera exitosa");

            limpiarControles();

        } catch (IllegalArgumentException ex) {
            mostrarAlerta(Alert.AlertType.ERROR,"Error de registro","No se puede registrar el objeto");
        }
    }

    @FXML
    private void onLimpiarButtonClick(ActionEvent event) throws IOException {
        limpiarControles();
    }


    private void limpiarControles(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        cmbTipoPersona.getSelectionModel().selectFirst();
        txtRut.requestFocus();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
