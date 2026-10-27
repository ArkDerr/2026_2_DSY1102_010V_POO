package cl.duoc.aurora.repository;

import cl.duoc.aurora.dao.LibroDAO;
import cl.duoc.aurora.dao.RevistaDAO;
import cl.duoc.aurora.model.Libro;
import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.model.Revista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaterialRepository {

    private final LibroDAO libroDAO = new LibroDAO();
    private final RevistaDAO revistaDAO = new RevistaDAO();

    private List<Libro> libros = new ArrayList<Libro>();
    private List<Revista> revistas = new ArrayList<Revista>();

    public void cargar() throws IOException {
        libros = libroDAO.leer();
        revistas = revistaDAO.leer();
    }

    public List<Material> listar() throws IOException{
        List<Material> todos = new ArrayList<>(libros);
        todos.addAll(revistas);
        return todos;
    }

    public void registrar(Material material) throws IOException{
        if (material instanceof Libro libro){
            if(libros.stream().anyMatch(x -> libro.getCodigo().equals(x.getCodigo())))
                throw new IllegalArgumentException("Libro existente");

            libros.add(libro);
            try{
                libroDAO.guardar(libros);
            } catch(Exception e){
                libros.remove(libro); throw e;
            }

        } else if(material instanceof Revista revista){
            if(revistas.stream().anyMatch(x -> revista.getCodigo().equals(x.getCodigo())))
                throw new IllegalArgumentException("Revista existente");

            revistas.add(revista);
            try{
                revistaDAO.guardar(revistas);
            } catch(Exception e){
                revistas.remove(revista); throw e;
            }
        }
    }

    public void eliminar(Material material) throws IOException{
        if (material instanceof Libro libro){
            if (!libros.remove(libro)) return;
            try{
                libroDAO.guardar(libros);
            }  catch(IOException e){
                libros.add(libro); throw e;
            }
        }
    }

}
