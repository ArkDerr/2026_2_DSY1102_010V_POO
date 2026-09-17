package org.gestionpersonal;

public abstract class Empleado {

    //Atributos
    private String id;
    private String nombre;
    private int edad;
    private double sueldoBase;

    //Constructor
    public Empleado(String id, String nombre, int edad, double sueldoBase) {
        this.id = id;
        //this.nombre = nombre;
        //this.edad = edad;
        this.sueldoBase = sueldoBase;
        setEdad(edad);
        setNombre(nombre);

    }

    //Get y Set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException(
                    "La nombre no puede esta vacio."
            );
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 18 || edad > 70) {
            throw new IllegalArgumentException(
                    "La edad debe estar entre 18 y 70 años."
            );
        }
        this.edad = edad;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    //Metodos
    public abstract double calcularSueldoFinal();

    public abstract void mostrarDetalle();

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sueldoBase=" + sueldoBase +
                '}';
    }
}
