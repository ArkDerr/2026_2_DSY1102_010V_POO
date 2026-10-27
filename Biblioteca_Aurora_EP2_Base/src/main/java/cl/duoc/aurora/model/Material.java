package cl.duoc.aurora.model;

/**
 * Representa un material de la Biblioteca Aurora.
 * Define los datos comunes y delega en las subclases el cálculo de tarifa.
 */
public abstract class Material {

    private String codigo;
    private String titulo;
    private int dias;

    /** Constructor sin parámetros, necesario para reconstruir objetos desde JSON. */
    protected Material() {
    }

    public Material(String codigo, String titulo, int dias) {
        setCodigo(codigo);
        setTitulo(titulo);
        setDias(dias);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo ni vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo ni vacío.");
        }
        this.titulo = titulo.trim();
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        if (dias < 1 || dias > 60) {
            throw new IllegalArgumentException("Los días deben estar entre 1 y 60.");
        }
        this.dias = dias;
    }

    /** Calcula la tarifa de préstamo según las reglas del tipo de material. */
    public abstract double calcularTarifa();

    /** Entrega el tipo de material para mostrarlo en la tabla. */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Código: " + codigo + " | Título: " + titulo;
    }
}
