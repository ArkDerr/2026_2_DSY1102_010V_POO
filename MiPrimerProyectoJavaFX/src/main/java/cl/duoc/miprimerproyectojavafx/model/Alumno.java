package cl.duoc.miprimerproyectojavafx.model;

import java.time.LocalDate;

public class Alumno extends Persona {

    public Alumno(String rut, String nombre, String apellido, LocalDate fechaNacimiento) {
        super(rut, nombre, apellido, fechaNacimiento);
    }

    @Override
    public String getTipo() {
        return "Alumno";
    }

}
