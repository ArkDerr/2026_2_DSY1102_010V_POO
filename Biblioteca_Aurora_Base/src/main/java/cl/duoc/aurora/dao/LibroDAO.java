package cl.duoc.aurora.dao;

import cl.duoc.aurora.model.Libro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
    private final Path archivo = Path.of("libros.json");

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Libro> leer() throws IOException {
        if (Files.notExists(archivo)) {
            return new ArrayList<>();
        }
        String json = Files.readString(archivo, StandardCharsets.UTF_8);
        List<Libro> datos = gson.fromJson(json, new TypeToken<List<Libro>>() {}.getType());
        return datos == null ? new ArrayList<>() : datos;
    }

    public void guardar(List<Libro> libros) throws IOException {
        Files.write(archivo, gson.toJson(libros).getBytes(StandardCharsets.UTF_8));
    }

}
