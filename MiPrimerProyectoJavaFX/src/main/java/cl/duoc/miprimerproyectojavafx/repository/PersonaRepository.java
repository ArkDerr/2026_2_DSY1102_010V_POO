package cl.duoc.miprimerproyectojavafx.repository;

import cl.duoc.miprimerproyectojavafx.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private static final PersonaRepository instancia = new PersonaRepository();

    private final List<Persona> personas = new ArrayList<>();

    public PersonaRepository() {
    }

    public static PersonaRepository getInstancia() {
        return instancia;
    }

    public void agregar(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nulo.");
        };

        if (existeRut(persona.getRut())){
            throw new IllegalArgumentException("La persona con ese rut ya existe.");
        }

        personas.add(persona);
    }

    private boolean existeRut(String rut) {
        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                return true;
            }
        }
        return false;
    }

    public List<Persona> listarTodos(){
        return new ArrayList<>(personas);
    }

}
