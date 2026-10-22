package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Alumno;
import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.model.Profesor;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditarController {

    @FXML private TextField txtRut;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private DatePicker dpFechaNacimiento;
    @FXML private ComboBox<String> cmbTipoPersona;

    private final PersonaRepository repository = PersonaRepository.getInstancia();

    private Persona persona;

    @FXML
    private void buscarRegistro(){
        try {
            persona = repository.buscarPorRut(txtRut.getText());

            if(persona == null){
                mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","No existe un registro con el Rut: " + txtRut.getText());
                limpiarControles();
                return;
            }

            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            dpFechaNacimiento.setValue(persona.getFechaNacimiento());
            cmbTipoPersona.setValue(persona.getTipo());

        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR,"Error de Busqueda","Error: " + e.getMessage());
        }
    }

    @FXML
    private void actualizarRegistro(){
        if(persona == null){
            mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","Primero debe buscar por rut.");
            limpiarControles();
            return;
        }

        try {
            Persona personaActualiza;
            if("Profesor".equals(cmbTipoPersona.getSelectionModel().getSelectedItem())){
                personaActualiza = new Profesor(txtRut.getText(),txtNombre.getText(),txtApellido.getText(),dpFechaNacimiento.getValue());
            } else {
                personaActualiza= new Alumno(txtRut.getText(),txtNombre.getText(),txtApellido.getText(),dpFechaNacimiento.getValue());
            }

            repository.actualizar(personaActualiza);
            mostrarAlerta(Alert.AlertType.INFORMATION,"Registro Actualizado","Registro actualizado con exito.");
            limpiarControles();

        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR,"Error de Actualización","Error: " + e.getMessage());
        }
    }

    @FXML
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarControles(){
        txtRut.clear();
        txtNombre.clear();
        txtApellido.clear();
        dpFechaNacimiento.setValue(null);
        cmbTipoPersona.getSelectionModel().selectFirst();
        txtRut.requestFocus();
    }
}
