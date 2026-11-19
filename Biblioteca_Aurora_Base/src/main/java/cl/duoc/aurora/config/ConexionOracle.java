package cl.duoc.aurora.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {
<<<<<<< HEAD:Biblioteca_Aurora_EP2_Base/src/main/java/cl/duoc/aurora/config/ConexionOracle.java
    private static final String USUARIO = "ADMIN";
    private static final String PASSWORD = "Duoc2026#123";
    private static final String SERVICIO = "oraclepoo_low";
    private static final String WALLET = "D:/POO/2026_2_DSY1102_010V_POO/Biblioteca_Aurora_EP2_Base/Wallet_OraclePOO.zip";

    public static Connection conectar() throws SQLException{
        System.setProperty("oracle.net.tns_admin", WALLET);
        String url = "jdbc:oracle:thin:@" + SERVICIO;
        return DriverManager.getConnection(url, USUARIO, PASSWORD);
    }

=======

    private static final String USUARIO = "ADMIN";
    private static final String CLAVE = "Duoc2026#123";
    private static final String SERVICIO = "oraclepoo_low";
    private static final String WALLET = "D:/Biblioteca_Aurora_Base/Wallet_OraclePOO";


    public static Connection conectar() throws SQLException {
        System.setProperty("oracle.net.tns_admin", WALLET);
        String url = "jdbc:oracle:thin:@" + SERVICIO;
        return DriverManager.getConnection(url, USUARIO, CLAVE);
    }
>>>>>>> 8f9270de84f89ffa0ceee3c90082fe08976cfd6c:Biblioteca_Aurora_Base/src/main/java/cl/duoc/aurora/config/ConexionOracle.java
}
