public class Estudiante extends Persona{
    private String carrera;
    private String sede;

    public Estudiante(String carrera, String sede) {
        this.carrera = carrera;
        this.sede = sede;
    }

    public Estudiante(String nombrePersona, String apellidoPersona, int edadPersona, String carrera, String sede) {
        super(nombrePersona, apellidoPersona, edadPersona);
        this.carrera = carrera;
        this.sede = sede;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "carrera='" + carrera + '\'' +
                ", sede='" + sede + '\'' +
                '}';
    }
}
