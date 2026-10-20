package cl.duoc.miprimerproyectojavafx.controller;

import cl.duoc.miprimerproyectojavafx.model.Persona;
import cl.duoc.miprimerproyectojavafx.repository.PersonaRepository;
import cl.duoc.miprimerproyectojavafx.util.Navegacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ListarController implements Initializable {

    @FXML private TableView<Persona> tblPersonas;
    @FXML private TableColumn<Persona, String> colRut;
    @FXML private TableColumn<Persona, String> colNombre;
    @FXML private TableColumn<Persona, String> colApellido;
    @FXML private TableColumn<Persona, LocalDate> colFechaNacimiento;
    @FXML private TableColumn<Persona, String> colTipo;

    private final PersonaRepository repository = PersonaRepository.getInstancia();

    private final ObservableList<Persona> datosTabla = FXCollections.observableArrayList();

    @FXML
    private void onVolverButtonClick(ActionEvent event) throws IOException {
        Navegacion.cambiarVista(event,"menu-view.fxml","Menu");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRut.setCellValueFactory(new PropertyValueFactory<>("rut"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tblPersonas.setItems(datosTabla);
        cargarPersonas();
    }

    private void cargarPersonas() {
        datosTabla.setAll(repository.listarTodos());
    }
}
