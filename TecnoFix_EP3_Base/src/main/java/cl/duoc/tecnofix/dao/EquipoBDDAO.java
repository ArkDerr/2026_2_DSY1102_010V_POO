package cl.duoc.tecnofix.dao;

import cl.duoc.tecnofix.config.conexionBD;
import cl.duoc.tecnofix.model.Equipo;
import cl.duoc.tecnofix.model.Monitor;
import cl.duoc.tecnofix.model.Notebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoBDDAO implements EquipoDAO {

    @Override
    public List<Equipo> obtenerTodos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT id, nombre, edad, peso, tipo, marca, diagnosticado, reventa, intensivo FROM equipos ORDER BY id ASC";
        try(Connection con= conexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                double peso = rs.getDouble("peso");
                String tipo = rs.getString("tipo");

                if ("Notebook".equals(tipo)) {
                    String marca = rs.getString("marca");
                    boolean diagnosticado = rs.getBoolean("diagnosticado");
                    boolean reventa = rs.getBoolean("reventa");
                    Notebook notebook = new Notebook(nombre, edad, peso, marca, diagnosticado);
                    notebook.setId(id);
                    if(reventa) {
                        notebook.marcarDisponibleParaReventa();
                    }
                    equipos.add(notebook);
                } else if ("Monitor".equals(tipo)) {
                    boolean intensivo = rs.getBoolean("intensivo");
                    Monitor monitor = new Monitor(nombre, edad, peso, intensivo);
                    monitor.setId(id);
                    equipos.add(monitor);
                } else {
                    throw new SQLException("Tipo desconocido: " + tipo);
                }
            }
            return equipos;
        }  catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insertar(Equipo equipo) {
        String sql = "INSERT INTO equipos " +
                "(nombre, edad, peso, tipo, marca, diagnosticado, reventa, intensivo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            if (equipo instanceof Notebook notebook) {
                ps.setString(1, equipo.getNombre());
                ps.setInt(2,equipo.getEdad());
                ps.setDouble(3,equipo.getPeso());
                ps.setString(4,"Notebook");
                ps.setString(5,((Notebook) equipo).getMarca());

                if(((Notebook) equipo).isDiagnosticado()){
                    ps.setInt(6,1);
                } else {
                    ps.setInt(6,0);
                }

                if (((Notebook) equipo).estaDisponibleParaReventa()){
                    ps.setInt(7,1);
                } else {
                    ps.setInt(7,0);
                }

                ps.setInt(8,0);
            } else if (equipo instanceof Monitor monitor) {
                ps.setString(1, equipo.getNombre());
                ps.setInt(2,equipo.getEdad());
                ps.setDouble(3,equipo.getPeso());
                ps.setString(4,"Monitor");
                ps.setString(5,("N/A"));

                ps.setInt(6,0);
                ps.setInt(7,0);

                if(((Monitor) equipo).isIntensivo()){
                    ps.setInt(8,1);
                } else {
                    ps.setInt(8,0);
                }
            } else {
                throw new IllegalArgumentException("Tipo de material no válido.");
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void actualizar(Equipo equipo) {
        String sql = "UPDATE equipos SET nombre = ?, edad = ?, peso = ?, tipo = ?, marca = ?, diagnosticado = ?, reventa = ?, intensivo = ? WHERE id = ?";
        try (Connection con = conexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, equipo.getNombre());
            ps.setInt(2, equipo.getEdad());
            ps.setDouble(3, equipo.getPeso());

            if (equipo instanceof Notebook notebook) {
                ps.setString(4, "Notebook");
                ps.setString(5, ((Notebook) equipo).getMarca());
                ps.setBoolean(6, ((Notebook) equipo).isDiagnosticado());
                ps.setBoolean(7, ((Notebook) equipo).estaDisponibleParaReventa());
                ps.setBoolean(8, false);
                ps.setInt(9, equipo.getId());
                ps.executeUpdate();
            } else if (equipo instanceof Monitor monitor) {
                ps.setString(4, "Monitor");
                ps.setString(5, "N/A");
                ps.setBoolean(6, false);
                ps.setBoolean(7, false);
                ps.setBoolean(8, ((Monitor) equipo).isIntensivo());
                ps.setInt(9, equipo.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipos WHERE id = ?";
        try (Connection con = conexionBD.conectar();
        PreparedStatement ps =  con.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible eliminar");
        }
    }
}
