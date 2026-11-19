package cl.duoc.tecnofix.dao;

/**
 * Indica que una operación de almacenamiento no pudo completarse.
 * <p>
 * Las clases de acceso a datos la lanzan para informar el problema sin que la
 * interfaz gráfica dependa del mecanismo de almacenamiento utilizado. La
 * ventana principal captura esta excepción y muestra su mensaje al usuario.
 */
public class PersistenciaException extends RuntimeException {

    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    public PersistenciaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
