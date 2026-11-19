package cl.duoc.tecnofix.dao;

import cl.duoc.tecnofix.model.Equipo;

import java.util.List;

/**
 * Contrato de acceso a datos de los equipos del servicio técnico.
 * <p>
 * Define qué operaciones de almacenamiento necesita la aplicación, sin indicar
 * dónde ni cómo se guarda la información. Cada forma de almacenamiento
 * corresponde a una clase que implementa esta interfaz.
 * <p>
 * Si una operación no puede completarse, la implementación debe lanzar una
 * {@link PersistenciaException} con un mensaje que explique el problema.
 * <p>
 * Esta interfaz no debe modificarse.
 */
public interface EquipoDAO {

    /**
     * Obtiene todos los equipos almacenados. Cada equipo se entrega como
     * objeto de su tipo real (Notebook o Monitor), con todos sus datos y su
     * identificador.
     *
     * @return lista de equipos; vacía si no hay registros
     * @throws PersistenciaException si no es posible leer la información
     */
    List<Equipo> obtenerTodos();

    /**
     * Almacena un equipo nuevo con todos sus datos. El identificador del
     * equipo lo genera el almacenamiento.
     *
     * @param equipo equipo a almacenar
     * @throws PersistenciaException si no es posible almacenar el equipo
     */
    void insertar(Equipo equipo);

    /**
     * Reemplaza los datos almacenados del equipo cuyo identificador
     * coincide con el del equipo recibido.
     *
     * @param equipo equipo con los datos actualizados
     * @throws PersistenciaException si no es posible actualizar el equipo
     */
    void actualizar(Equipo equipo);

    /**
     * Elimina el equipo que tiene el identificador indicado.
     *
     * @param id identificador del equipo a eliminar
     * @throws PersistenciaException si no es posible eliminar el equipo
     */
    void eliminar(int id);
}
