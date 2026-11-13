package cl.duoc.aurora.model;

/**
 * Libro disponible en Biblioteca Aurora.
 * Tarifa base: $500 por día; las novedades tienen un recargo del 20 %.
 */
public class Libro extends Material implements Prestamo {

    private static final double TARIFA_DIARIA = 500;
    private static final double RECARGO_NOVEDAD = 0.20;

    private String autor;
    private boolean novedad;

    /** Constructor sin parámetros, necesario para reconstruir objetos desde JSON. */
    public Libro() {
    }

    public Libro(String codigo, String titulo, int dias, String autor, boolean novedad) {
        super(codigo, titulo, dias);
        setAutor(autor);
        setNovedad(novedad);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo ni vacío.");
        }
        this.autor = autor.trim();
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public double calcularTarifa() {
        double base = getDias() * TARIFA_DIARIA;
        if (novedad) {
            return base + base * RECARGO_NOVEDAD;
        }
        return base;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }

    @Override
    public boolean permitePrestamo() {
        return true;
    }
}
