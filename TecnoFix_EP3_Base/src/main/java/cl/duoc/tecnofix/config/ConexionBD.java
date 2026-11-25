package cl.duoc.tecnofix.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {
    private static final String USUARIO = "ADMIN";
    private static final String CLAVE = "Duoc2026#123";
    private static final String SERVICIO = "oraclepoo_low";
    //Ruta Wallet Windows:
    //private static final String WALLET = "D:/POO/2026_2_DSY1102_011V_POO/TecnoFix_EP3_Base/Wallet_OraclePOO";
    //Ruta Waller MacOS:
    private static final String WALLET = "/Users/arkder/Desktop/Aplicaciones/2026-2/DESARROLLO ORIENTADO A OBJETOS/2026_2_DSY1102_011V_POO/TecnoFix_EP3_Base/Wallet_OraclePOO";

    public static Connection conectar() throws SQLException {
        System.setProperty("oracle.net.tns_admin", WALLET);
        String url = "jdbc:oracle:thin:@" + SERVICIO;
        return DriverManager.getConnection(url, USUARIO, CLAVE);
    }
}
