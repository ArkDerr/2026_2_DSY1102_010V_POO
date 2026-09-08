package org.example;

import java.util.List;

public class Operadores {
    public Alumno buscar(int rut, List<Alumno> alumnos){
        for(Alumno objetoAlumno : alumnos){
            if (objetoAlumno.getRut() == rut){
                return objetoAlumno;
            }
        }
        return null;
    }
}
