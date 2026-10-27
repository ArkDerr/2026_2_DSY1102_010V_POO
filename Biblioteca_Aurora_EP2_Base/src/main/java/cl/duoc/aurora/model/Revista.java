package cl.duoc.aurora.model;

/**
 * Revista disponible en Biblioteca Aurora.
 * Tarifa base: $300 por día; las ediciones especiales tienen recargo del 15 %.
 */
public class Revista extends Material implements Prestamo {

    private static final double TARIFA_DIARIA = 300;
    private static final double RECARGO_ESPECIAL = 0.15;

    private boolean especial;

    /** Constructor sin parámetros, necesario para reconstruir objetos desde JSON. */
    public Revista() {
    }

    public Revista(String codigo, String titulo, int dias, boolean especial) {
        super(codigo, titulo, dias);
        setEspecial(especial);
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    @Override
    public double calcularTarifa() {
        double base = getDias() * TARIFA_DIARIA;
        if (especial) {
            return base + base * RECARGO_ESPECIAL;
        }
        return base;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public boolean permitePrestamo() {
        return true;
    }
}
