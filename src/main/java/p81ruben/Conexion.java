/*
 * Esta clase aplica el patrón SINGLETON
 */
package p81ruben;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Conexion {

    private static final String SERVIDOR = "jdbc:mysql://192.168.56.101:3306/";
    private static final String NOMBRE_BASE_DATOS = "PracticaProgramaciónRuben";
    private static final String USER = "ruben";
    private static final String PASS = "ruben";

    private static Connection instancia = null;
    
    private Conexion() {

    }


    public static Connection getInstance() {

        if (instancia == null) {
            try {


                instancia = DriverManager.getConnection(SERVIDOR + NOMBRE_BASE_DATOS, USER, PASS);

                System.out.println("Conexión realizada con éxito.");

            } catch (SQLException e) {


                System.out.println("Conexión fallida: " + e.getMessage());
            }
        }
        return instancia;
    }

}
