package cl.duoc.tecnofix.dao;

import cl.duoc.tecnofix.config.ConexionBD;
import cl.duoc.tecnofix.model.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoBDDAO {

    public List<Equipo>  obtenerTodos(){
        List<Equipo> equipos = new ArrayList<>();
        String sql1 = "select * from Equipos";
        String sql2 = "select * from Tipo WHERE idtipo = ?";

        try(Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                int idtipo = rs.getInt("idtipo");
                try(Connection con2 = ConexionBD.conectar();
                    PreparedStatement ps2 = con.prepareStatement(sql2)){
                    ps2.setInt(1, idtipo);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return equipos;
    }
}
