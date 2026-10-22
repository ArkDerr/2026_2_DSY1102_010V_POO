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

    public Persona buscarPorRut(String rut){
        if (rut==null || rut.isEmpty()){
            throw new IllegalArgumentException("El rut no puede ser nulo.");
        }

        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                return persona;
            }
        }
        return null;
    }

    public void actualizar(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula.");
        }

        for (Persona p : personas) {
            if (p.getRut().equals(persona.getRut())) {
                p.setNombre(persona.getNombre());
                p.setApellido(persona.getApellido());
                p.setFechaNacimiento(persona.getFechaNacimiento());
                return;
            }
        }
        throw new IllegalArgumentException("No existe una persona con el rut: " + persona.getRut());
    }

    public void eliminar(String rut) {
        if (rut==null || rut.isEmpty()){
            throw new IllegalArgumentException("El rut no puede ser nulo.");
        }
        Persona personaEliminar = buscarPorRut(rut);

        if (personaEliminar == null) {
            throw new IllegalArgumentException("No existe una persona con el rut: " + rut);
        }
        personas.remove(personaEliminar);
    }

}
