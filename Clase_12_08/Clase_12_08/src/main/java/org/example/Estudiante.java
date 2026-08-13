package org.example;

public class Estudiante extends Persona {
    private String carrera;
    private boolean gratuidad;

    public Estudiante(String carrera, boolean gratuidad) {
        this.carrera = carrera;
        this.gratuidad = gratuidad;
    }

    public Estudiante(String nombre, String apellido, int edad, String carrera, boolean gratuidad) {
        super(nombre, apellido, edad);
        this.carrera = carrera;
        this.gratuidad = gratuidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public boolean isGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(boolean gratuidad) {
        this.gratuidad = gratuidad;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad + '\'' +
                "carrera='" + carrera + '\'' +
                ", gratuidad=" + gratuidad +
                '}';
    }
}
