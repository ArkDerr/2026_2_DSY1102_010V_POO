package cl.duoc.tecnofix.model;

/**
 * Contrato que cumplen los equipos que participan en el programa de
 * reventa del servicio técnico.
 */
public interface Revendible {

    /**
     * Indica si el equipo se encuentra disponible para ser revendido.
     *
     * @return true si está disponible para reventa
     */
    boolean estaDisponibleParaReventa();

    /**
     * Registra que el equipo está disponible para reventa.
     */
    void marcarDisponibleParaReventa();
}
