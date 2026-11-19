package cl.duoc.tecnofix.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String USUARIO = "ADMIN";
    private static final String CLAVE = "Duoc2026#123";
    private static final String SERVICIO = "oraclepoo_low";
    private static final String WALLET = "D:/POO/2026_2_DSY1102_010V_POO/TecnoFix_EP3_Base/Wallet_OraclePOO";
    //private static final String URL = "jdbc:mysql://localhost:3306/";

    public static Connection conectar() throws SQLException {
        System.setProperty("oracle.net.tns_admin", WALLET);
        String url = "jdbc:oracle:thin:@" + SERVICIO;
        return DriverManager.getConnection(url, USUARIO, CLAVE);
    }
}
