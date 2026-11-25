package cl.duoc.tecnofix.controller;

import cl.duoc.tecnofix.dao.EquipoArchivoDAO;
import cl.duoc.tecnofix.dao.EquipoBDDAO;
import cl.duoc.tecnofix.dao.EquipoDAO;
import cl.duoc.tecnofix.dao.PersistenciaException;
import cl.duoc.tecnofix.model.Monitor;
import cl.duoc.tecnofix.model.Equipo;
import cl.duoc.tecnofix.model.Notebook;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Controlador de la ventana principal de la aplicación.
 * <p>
 * Gestiona el formulario, la tabla y el área de mensajes. Para leer y guardar
 * la información trabaja únicamente con la interfaz {@link EquipoDAO}; no
 * conoce el mecanismo de almacenamiento que hay detrás.
 */
public class MainController {

    private static final String TIPO_NOTEBOOK = "Notebook";
    private static final String TIPO_MONITOR = "Monitor";
    private static final String TEXTO_REGISTRAR = "Registrar";
    private static final String TEXTO_GUARDAR = "Guardar cambios";

    // --- Formulario ---
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    @FXML private TextField txtPeso;
    @FXML private TextField txtMarca;
    @FXML private CheckBox chkDiagnosticado;
    @FXML private CheckBox chkReventa;
    @FXML private CheckBox chkIntensivo;
    @FXML private Button btnRegistrar;
    @FXML private Button btnCancelar;

    // --- Tabla ---
    @FXML private TableView<Equipo> tablaEquipos;
    @FXML private TableColumn<Equipo, Number> colId;
    @FXML private TableColumn<Equipo, String> colTipo;
    @FXML private TableColumn<Equipo, String> colNombre;
    @FXML private TableColumn<Equipo, Number> colEdad;
    @FXML private TableColumn<Equipo, Number> colPeso;
    @FXML private TableColumn<Equipo, Number> colCosto;

    // --- Área de mensajes ---
    @FXML private Label lblMensaje;

    /** Equipos que muestra la tabla. */
    private final ObservableList<Equipo> equipos = FXCollections.observableArrayList();

    /** Implementación de almacenamiento que utiliza la aplicación. */
    private final EquipoDAO dao = new EquipoArchivoDAO();
    private final EquipoDAO daoBD = new EquipoBDDAO();

    /** Equipo que se está editando; null cuando el formulario está en modo registro. */
    private Equipo equipoEnEdicion;

    @FXML
    private void initialize() {
        cmbTipo.setItems(FXCollections.observableArrayList(TIPO_NOTEBOOK, TIPO_MONITOR));
        cmbTipo.valueProperty().addListener((obs, anterior, actual) -> actualizarCamposPorTipo());

        configurarTabla();
        actualizarCamposPorTipo();
        btnCancelar.setDisable(true);

        cargarEquipos();
    }

    private void configurarTabla() {
        colId.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getId()));
        colTipo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getTipo()));
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNombre()));
        colEdad.setCellValueFactory(d -> new SimpleIntegerProperty(d.getValue().getEdad()));
        colPeso.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().getPeso()));
        colCosto.setCellValueFactory(d -> new SimpleDoubleProperty(d.getValue().calcularCostoRevision()));

        NumberFormat formatoPesos = NumberFormat.getIntegerInstance(Locale.forLanguageTag("es-CL"));
        colCosto.setCellFactory(columna -> new TableCell<>() {
            @Override
            protected void updateItem(Number valor, boolean vacia) {
                super.updateItem(valor, vacia);
                setText(vacia || valor == null ? null : "$" + formatoPesos.format(valor.doubleValue()));
            }
        });

        tablaEquipos.setItems(equipos);
    }

    // ----------------------------------------------------------------------
    // Acciones de los botones
    // ----------------------------------------------------------------------

    /** Registra un equipo nuevo o guarda los cambios del equipo en edición. */
    @FXML
    private void onRegistrar() {
        Equipo equipo;
        try {
            equipo = crearEquipoDesdeFormulario();
        } catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage());
            return;
        }

        try {
            if (equipoEnEdicion == null) {
                //dao.insertar(equipo);
                daoBD.insertar(equipo);
                mostrarMensaje(equipo.getNombre() + " (" + equipo.getTipo() + ") registrado correctamente.");
            } else {
                equipo.setId(equipoEnEdicion.getId());
                //dao.actualizar(equipo);
                daoBD.actualizar(equipo);
                mostrarMensaje(equipo.getNombre() + " (" + equipo.getTipo() + ") actualizado correctamente.");
            }
        } catch (PersistenciaException e) {
            mostrarMensaje("Error al guardar la información: " + e.getMessage());
            return;
        }

        recargarTabla();
        limpiarFormulario();
    }

    /** Carga en el formulario el equipo seleccionado para modificar sus datos. */
    @FXML
    private void onEditar() {
        Equipo seleccionado = tablaEquipos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensaje("Debe seleccionar un equipo de la tabla para editarlo.");
            return;
        }

        equipoEnEdicion = seleccionado;
        cmbTipo.setValue(seleccionado.getTipo());
        cmbTipo.setDisable(true);
        txtNombre.setText(seleccionado.getNombre());
        txtEdad.setText(String.valueOf(seleccionado.getEdad()));
        txtPeso.setText(String.valueOf(seleccionado.getPeso()));
        if (seleccionado instanceof Notebook notebook) {
            txtMarca.setText(notebook.getMarca());
            chkDiagnosticado.setSelected(notebook.isDiagnosticado());
            chkReventa.setSelected(notebook.estaDisponibleParaReventa());
        } else if (seleccionado instanceof Monitor monitor) {
            chkIntensivo.setSelected(monitor.isIntensivo());
        }

        btnRegistrar.setText(TEXTO_GUARDAR);
        btnCancelar.setDisable(false);
        mostrarMensaje("Editando a " + seleccionado.getNombre() + " (" + seleccionado.getTipo()
                + "). Modifica los datos y presiona " + TEXTO_GUARDAR + ".");
    }

    /** Descarta la edición en curso y vuelve el formulario al modo registro. */
    @FXML
    private void onCancelar() {
        limpiarFormulario();
        mostrarMensaje("Edición cancelada.");
    }

    /** Elimina el equipo seleccionado en la tabla. */
    @FXML
    private void onEliminar() {
        Equipo seleccionado = tablaEquipos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarMensaje("Debe seleccionar un equipo de la tabla para eliminarlo.");
            return;
        }

        try {
            //dao.eliminar(seleccionado.getId());
            daoBD.eliminar(seleccionado.getId());
        } catch (PersistenciaException e) {
            mostrarMensaje("Error al eliminar la información: " + e.getMessage());
            return;
        }

        if (seleccionado == equipoEnEdicion) {
            limpiarFormulario();
        }
        recargarTabla();
        mostrarMensaje(seleccionado.getNombre() + " (" + seleccionado.getTipo() + ") eliminado.");
    }

    // ----------------------------------------------------------------------
    // Carga de datos
    // ----------------------------------------------------------------------

    /** Carga la información almacenada al iniciar la aplicación. */
    private void cargarEquipos() {
        if (recargarTabla()) {
            mostrarMensaje(equipos.isEmpty()
                    ? "No hay equipos registrados."
                    : equipos.size() + " equipo(s) cargado(s).");
        }
    }

    /**
     * Vuelve a leer la información almacenada y la muestra en la tabla.
     *
     * @return true si la lectura fue exitosa
     */
    private boolean recargarTabla() {
        try {
            //equipos.setAll(dao.obtenerTodos());
            equipos.setAll(daoBD.obtenerTodos());
            return true;
        } catch (PersistenciaException e) {
            equipos.clear();
            mostrarMensaje("Error al leer la información: " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // Formulario
    // ----------------------------------------------------------------------

    /**
     * Valida los datos del formulario y construye el equipo correspondiente.
     *
     * @throws IllegalArgumentException si algún dato no es válido
     */
    private Equipo crearEquipoDesdeFormulario() {
        String tipo = cmbTipo.getValue();
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo: debe seleccionar Notebook o Monitor.");
        }
        if (txtNombre.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre: no puede estar vacío.");
        }
        String nombre = txtNombre.getText().trim();
        int edad = leerEdad();
        double peso = leerPeso();

        if (TIPO_NOTEBOOK.equals(tipo)) {
            String marca = txtMarca.getText().trim();
            if (marca.isEmpty()) {
                throw new IllegalArgumentException("Marca: no puede estar vacía.");
            }
            Notebook notebook = new Notebook(nombre, edad, peso, marca, chkDiagnosticado.isSelected());
            if (chkReventa.isSelected()) {
                notebook.marcarDisponibleParaReventa();
            }
            return notebook;
        }
        return new Monitor(nombre, edad, peso, chkIntensivo.isSelected());
    }

    private int leerEdad() {
        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Edad: debe ser un número entero entre 0 y 30.");
        }
        if (edad < 0 || edad > 30) {
            throw new IllegalArgumentException("Edad: debe estar entre 0 y 30 años.");
        }
        return edad;
    }

    private double leerPeso() {
        double peso;
        try {
            peso = Double.parseDouble(txtPeso.getText().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Peso: debe ser un número mayor que cero.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso: debe ser mayor que cero.");
        }
        return peso;
    }

    /** Habilita solo los campos propios del tipo seleccionado. */
    private void actualizarCamposPorTipo() {
        boolean esNotebook = TIPO_NOTEBOOK.equals(cmbTipo.getValue());
        boolean esMonitor = TIPO_MONITOR.equals(cmbTipo.getValue());
        txtMarca.setDisable(!esNotebook);
        chkDiagnosticado.setDisable(!esNotebook);
        chkReventa.setDisable(!esNotebook);
        chkIntensivo.setDisable(!esMonitor);
    }

    /** Deja el formulario vacío y en modo registro. */
    private void limpiarFormulario() {
        equipoEnEdicion = null;
        cmbTipo.setDisable(false);
        cmbTipo.setValue(null);
        txtNombre.clear();
        txtEdad.clear();
        txtPeso.clear();
        txtMarca.clear();
        chkDiagnosticado.setSelected(false);
        chkReventa.setSelected(false);
        chkIntensivo.setSelected(false);
        btnRegistrar.setText(TEXTO_REGISTRAR);
        btnCancelar.setDisable(true);
        tablaEquipos.getSelectionModel().clearSelection();
    }

    private void mostrarMensaje(String mensaje) {
        lblMensaje.setText(mensaje);
    }
}
