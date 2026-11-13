package cl.duoc.aurora.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {

    private static final String USUARIO = "ADMIN";
    private static final String CLAVE = "Duoc2026#123";
    private static final String SERVICIO = "oraclepoo_low";
    private static final String WALLET = "D:/Biblioteca_Aurora_Base/Wallet_OraclePOO";


    public static Connection conectar() throws SQLException {
        System.setProperty("oracle.net.tns_admin", WALLET);
        String url = "jdbc:oracle:thin:@" + SERVICIO;
        return DriverManager.getConnection(url, USUARIO, CLAVE);
    }
}
