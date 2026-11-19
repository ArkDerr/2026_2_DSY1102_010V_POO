package cl.duoc.tecnofix.dao;

import cl.duoc.tecnofix.model.Monitor;
import cl.duoc.tecnofix.model.Equipo;
import cl.duoc.tecnofix.model.Notebook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de {@link EquipoDAO} que almacena la información en archivos
 * JSON ubicados en la carpeta raíz del proyecto:
 * <ul>
 *     <li>notebooks.json: notebooks registrados.</li>
 *     <li>monitores.json: monitores registrados.</li>
 * </ul>
 * El identificador de cada equipo es único entre ambos archivos.
 */
public class EquipoArchivoDAO implements EquipoDAO {

    private static final String ARCHIVO_NOTEBOOKS = "notebooks.json";
    private static final String ARCHIVO_MONITORES = "monitores.json";

    private static final Type TIPO_LISTA_NOTEBOOKS = new TypeToken<List<Notebook>>() { }.getType();
    private static final Type TIPO_LISTA_MONITORES = new TypeToken<List<Monitor>>() { }.getType();

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public List<Equipo> obtenerTodos() {
        List<Equipo> todas = new ArrayList<>();
        todas.addAll(leerNotebooks());
        todas.addAll(leerMonitores());
        return todas;
    }

    @Override
    public void insertar(Equipo equipo) {
        equipo.setId(siguienteId());
        if (equipo instanceof Notebook notebook) {
            List<Notebook> notebooks = leerNotebooks();
            notebooks.add(notebook);
            guardar(ARCHIVO_NOTEBOOKS, notebooks, TIPO_LISTA_NOTEBOOKS);
        } else if (equipo instanceof Monitor monitor) {
            List<Monitor> monitores = leerMonitores();
            monitores.add(monitor);
            guardar(ARCHIVO_MONITORES, monitores, TIPO_LISTA_MONITORES);
        }
    }

    @Override
    public void actualizar(Equipo equipo) {
        if (equipo instanceof Notebook notebook) {
            List<Notebook> notebooks = leerNotebooks();
            notebooks.replaceAll(p -> p.getId() == notebook.getId() ? notebook : p);
            guardar(ARCHIVO_NOTEBOOKS, notebooks, TIPO_LISTA_NOTEBOOKS);
        } else if (equipo instanceof Monitor monitor) {
            List<Monitor> monitores = leerMonitores();
            monitores.replaceAll(g -> g.getId() == monitor.getId() ? monitor : g);
            guardar(ARCHIVO_MONITORES, monitores, TIPO_LISTA_MONITORES);
        }
    }

    @Override
    public void eliminar(int id) {
        List<Notebook> notebooks = leerNotebooks();
        if (notebooks.removeIf(p -> p.getId() == id)) {
            guardar(ARCHIVO_NOTEBOOKS, notebooks, TIPO_LISTA_NOTEBOOKS);
            return;
        }
        List<Monitor> monitores = leerMonitores();
        if (monitores.removeIf(g -> g.getId() == id)) {
            guardar(ARCHIVO_MONITORES, monitores, TIPO_LISTA_MONITORES);
        }
    }

    // ----------------------------------------------------------------------
    // Métodos auxiliares
    // ----------------------------------------------------------------------

    /** Calcula el siguiente identificador libre considerando ambos archivos. */
    private int siguienteId() {
        int mayor = 0;
        for (Equipo m : obtenerTodos()) {
            mayor = Math.max(mayor, m.getId());
        }
        return mayor + 1;
    }

    private List<Notebook> leerNotebooks() {
        return leer(ARCHIVO_NOTEBOOKS, TIPO_LISTA_NOTEBOOKS);
    }

    private List<Monitor> leerMonitores() {
        return leer(ARCHIVO_MONITORES, TIPO_LISTA_MONITORES);
    }

    /** Lee un archivo JSON. Si el archivo no existe, retorna una lista vacía. */
    private <T> List<T> leer(String nombreArchivo, Type tipoLista) {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        try (Reader lector = new FileReader(archivo)) {
            List<T> lista = gson.fromJson(lector, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException | JsonParseException e) {
            throw new PersistenciaException("No fue posible leer el archivo " + nombreArchivo + ".", e);
        }
    }

    /** Escribe la lista completa en el archivo JSON indicado. */
    private <T> void guardar(String nombreArchivo, List<T> lista, Type tipoLista) {
        try (Writer escritor = new FileWriter(nombreArchivo)) {
            gson.toJson(lista, tipoLista, escritor);
        } catch (IOException e) {
            throw new PersistenciaException("No fue posible guardar el archivo " + nombreArchivo + ".", e);
        }
    }
}
