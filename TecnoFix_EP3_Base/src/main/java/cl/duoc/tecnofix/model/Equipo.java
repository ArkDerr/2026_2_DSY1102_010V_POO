package cl.duoc.tecnofix.model;

/**
 * Representa cualquier equipo recibido en el Servicio Técnico TecnoFix.
 * Define los datos comunes y delega en cada tipo de equipo el cálculo del
 * costo de revisión.
 * <p>
 * El identificador ({@code id}) permite distinguir a cada equipo registrado,
 * incluso si dos equipos tienen el mismo nombre. Mientras el equipo no ha
 * sido almacenado, su identificador es 0.
 */
public abstract class Equipo {

    private int id;
    private String nombre;
    private int edad;
    private double peso;

    /**
     * Constructor sin parámetros, requerido para reconstruir objetos.
     */
    protected Equipo() {
    }

    public Equipo(String nombre, int edad, double peso) {
        setNombre(nombre);
        setEdad(edad);
        setPeso(peso);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 30) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 30 años.");
        }
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.peso = peso;
    }

    /**
     * Calcula el costo de revisión según las reglas propias de cada tipo de equipo.
     *
     * @return costo de la revisión en pesos
     */
    public abstract double calcularCostoRevision();

    /**
     * Retorna el nombre del tipo de equipo (por ejemplo, "Notebook" o "Monitor").
     *
     * @return tipo de equipo
     */
    public abstract String getTipo();

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " años";
    }
}
