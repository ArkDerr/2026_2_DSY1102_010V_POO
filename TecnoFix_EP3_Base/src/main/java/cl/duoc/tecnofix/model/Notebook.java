package cl.duoc.tecnofix.model;

/**
 * Notebook recibido en el servicio técnico. Participa en el programa de reventa.
 * Costo de revisión: base $15.000; si no está diagnosticado, recargo del 30%.
 */
public class Notebook extends Equipo implements Revendible {

    private static final double COSTO_BASE = 15000;
    private static final double RECARGO_NO_DIAGNOSTICADO = 0.30;

    private String marca;
    private boolean diagnosticado;
    private boolean disponibleReventa;

    /**
     * Constructor sin parámetros, requerido para reconstruir objetos.
     */
    public Notebook() {
    }

    public Notebook(String nombre, int edad, double peso, String marca, boolean diagnosticado) {
        super(nombre, edad, peso);
        setMarca(marca);
        setDiagnosticado(diagnosticado);
        this.disponibleReventa = false;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDiagnosticado() {
        return diagnosticado;
    }

    public void setDiagnosticado(boolean diagnosticado) {
        this.diagnosticado = diagnosticado;
    }

    @Override
    public boolean estaDisponibleParaReventa() {
        return disponibleReventa;
    }

    @Override
    public void marcarDisponibleParaReventa() {
        this.disponibleReventa = true;
    }

    @Override
    public double calcularCostoRevision() {
        if (diagnosticado) {
            return COSTO_BASE;
        }
        return COSTO_BASE + COSTO_BASE * RECARGO_NO_DIAGNOSTICADO;
    }

    @Override
    public String getTipo() {
        return "Notebook";
    }
}
