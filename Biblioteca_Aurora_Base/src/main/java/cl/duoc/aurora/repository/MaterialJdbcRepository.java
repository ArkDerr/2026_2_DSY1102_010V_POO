package cl.duoc.aurora.repository;

import cl.duoc.aurora.config.ConexionOracle;
import cl.duoc.aurora.model.Libro;
import cl.duoc.aurora.model.Material;
import cl.duoc.aurora.model.Revista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialJdbcRepository {

    public List<Material> listar() throws SQLException {
        List<Material> lista = new ArrayList<>();
        String sql = "SELECT * FROM MATERIALES ORDER BY CODIGO";
        try (Connection conexion = ConexionOracle.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String codigo = rs.getString("CODIGO");
                String titulo = rs.getString("TITULO");
                int dias = rs.getInt("DIAS");
                String tipo = rs.getString("TIPO");

                if ("LIBRO".equals(tipo)) {
                    Libro libro = new Libro(codigo, titulo, dias,
                            rs.getString("AUTOR"), rs.getInt("NOVEDAD") == 1);
                    lista.add(libro);
                } else if ("REVISTA".equals(tipo)) {
                    Revista revista = new Revista(codigo, titulo, dias,
                            rs.getInt("ESPECIAL") == 1);
                    lista.add(revista);
                } else {
                    throw new SQLException("Tipo desconocido: " + tipo);
                }
            }
        }
        return lista;
    }

    public void registrar(Material material) throws SQLException {
        String sql = "INSERT INTO MATERIALES " +
                "(CODIGO, TIPO, TITULO, DIAS, AUTOR, NOVEDAD, ESPECIAL) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionOracle.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, material.getCodigo());
            ps.setString(2, material.getTipo().toUpperCase());
            ps.setString(3, material.getTitulo());
            ps.setInt(4, material.getDias());

            if (material instanceof Libro libro) {
                ps.setString(5, libro.getAutor());
                ps.setInt(6, libro.isNovedad() ? 1 : 0);
                ps.setInt(7, 0);
            } else if (material instanceof Revista revista) {
                ps.setString(5, null);
                ps.setInt(6, 0);
                ps.setInt(7, revista.isEspecial() ? 1 : 0);
            } else {
                throw new IllegalArgumentException("Tipo de material no válido.");
            }
            ps.executeUpdate();
        }
    }

    public void eliminar(String codigo) throws SQLException {
        String sql = "DELETE FROM MATERIALES WHERE CODIGO = ?";

        try (Connection conexion = ConexionOracle.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.executeUpdate();
        }
    }
}