package cl.duoc.aurora.repository;

import cl.duoc.aurora.config.ConexionOracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterialesOracleRepository {



    public void eliminar(String codigo) throws SQLException {
        String sql = "DELETE FROM materiales WHERE codigo = ?";

        try (Connection conexion = ConexionOracle.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, codigo);
            ps.executeUpdate();
        };
    }
}
