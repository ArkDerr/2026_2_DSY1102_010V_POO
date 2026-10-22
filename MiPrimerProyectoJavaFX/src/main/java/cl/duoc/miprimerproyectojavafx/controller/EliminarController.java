package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EliminarController implements Initializable {

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
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }

    @FXML
    private void eliminarRegistro() {
        if(persona == null){
            mostrarAlerta(Alert.AlertType.WARNING,"Busqueda","Primero debe buscar por rut.");
            limpiarControles();
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Eliminar registro");
        confirmacion.setHeaderText(null);
        confirmacion.setContentText("¿Realmente desea eliminar el registro: " + txtNombre.getText());
        Optional<ButtonType> respuesta = confirmacion.showAndWait();

        if (respuesta.isPresent() && respuesta.get() == ButtonType.OK){
            repository.eliminar(persona.getRut());
            mostrarAlerta(Alert.AlertType.INFORMATION,"Registro eliminado","Registro eliminado de manera exitosa.");
            limpiarControles();
        }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoPersona.getItems().addAll("Alumno","Profesor");
    }
}
