public class Animal {

    private String nombre;
    private String continente;
    private int cantidad;

    public Animal() {
    }

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public Animal(int cantidad, String continente, String nombre) {
        this.cantidad = cantidad;
        this.continente = continente;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", continente='" + continente + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
