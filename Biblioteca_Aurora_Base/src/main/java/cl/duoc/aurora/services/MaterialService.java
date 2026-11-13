package cl.duoc.aurora.services;

import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.repository.MaterialJdbcRepository;

import java.sql.SQLException;
import java.util.List;

public class MaterialService {

    private final MaterialJdbcRepository repository = new MaterialJdbcRepository();

    public List<Material> listar() throws SQLException {
        return repository.listar();
    }

    public void registrar(Material material) throws SQLException {
        if (material == null) {
            throw new IllegalArgumentException("Debes ingresar un material");
        }
        repository.registrar(material);
    }

    public void eliminar(String codigo) throws SQLException {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Debes seleccionar un material.");
        }
        repository.eliminar(codigo);
    }

}
