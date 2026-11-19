package cl.duoc.aurora.services;

import cl.duoc.aurora.config.ConexionOracle;
import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.repository.MaterialesOracleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MaterialServices {

    private final MaterialesOracleRepository materialesRepository = new MaterialesOracleRepository();

    public List<Material> listar() throws SQLException {
        return materialesRepository.listar();
    }

    public void registar(Material material) throws SQLException {
        if(material == null) {
            throw new SQLException("Materiales no puede ser nulo");
        }
        materialesRepository.registrar(material);
    }

    public void eliminar(String codigo) throws SQLException {
        if (codigo == null || codigo.equals("")) {
            throw new SQLException("El codigo no puede ser nulo");
        }
        materialesRepository.eliminar(codigo);
    }

}
