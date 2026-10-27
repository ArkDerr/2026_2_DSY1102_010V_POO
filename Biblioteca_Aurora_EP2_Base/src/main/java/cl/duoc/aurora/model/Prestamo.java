package cl.duoc.aurora.model;

/** Contrato para materiales que se pueden entregar en préstamo. */
public interface Prestamo {

    /** Retorna true si el material puede ser prestado. */
    boolean permitePrestamo();
}
