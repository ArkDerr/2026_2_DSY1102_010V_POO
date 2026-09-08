package org.example;

public class Alumno {
    private int rut;
    private String nombre;

    public Alumno(int rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "rut=" + rut +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
