package cl.duoc.aurora.dao;

import cl.duoc.aurora.model.Libro;
import cl.duoc.aurora.model.Revista;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RevistaDAO {
    private final Path archivo = Path.of("revista.json");

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Revista> leer() throws IOException {
        if (Files.notExists(archivo)) {
            return new ArrayList<>();
        }
        String json = Files.readString(archivo, StandardCharsets.UTF_8);
        List<Revista> datos = gson.fromJson(json, new TypeToken<List<Revista>>() {}.getType());
        return datos == null ? new ArrayList<>() : datos;
    }

    public void guardar(List<Revista> revistas) throws IOException {
        Files.write(archivo, gson.toJson(revistas).getBytes(StandardCharsets.UTF_8));
    }
}
