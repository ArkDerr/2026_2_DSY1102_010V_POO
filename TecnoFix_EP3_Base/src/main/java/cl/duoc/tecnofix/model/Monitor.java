package cl.duoc.tecnofix.model;

/**
 * Monitor recibido en el servicio técnico.
 * Costo de revisión: base $12.000; si tiene uso intensivo, recargo del 15%.
 */
public class Monitor extends Equipo {

    private static final double COSTO_BASE = 12000;
    private static final double RECARGO_INTENSIVO = 0.15;

    private boolean intensivo;

    /**
     * Constructor sin parámetros, requerido para reconstruir objetos.
     */
    public Monitor() {
    }

    public Monitor(String nombre, int edad, double peso, boolean intensivo) {
        super(nombre, edad, peso);
        setIntensivo(intensivo);
    }

    public boolean isIntensivo() {
        return intensivo;
    }

    public void setIntensivo(boolean intensivo) {
        this.intensivo = intensivo;
    }

    @Override
    public double calcularCostoRevision() {
        if (intensivo) {
            return COSTO_BASE + COSTO_BASE * RECARGO_INTENSIVO;
        }
        return COSTO_BASE;
    }

    @Override
    public String getTipo() {
        return "Monitor";
    }
}
