package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Esta clase se encargara de establecer y cerrar la conexion con la base de datos
public class ConfigDB {
// Este atributo tendra el estado de la conexion

    static Connection objConnection = null;

    //metodo para conectar la db

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            // creamos las variables de la conexion
            String url = "jdbc:mysql://b3utjxmnweinhk5k8gm5-mysql.services.clever-cloud.com/b3utjxmnweinhk5k8gm5";
            String user = "ude14x53yx2e1btd";
            String pass = "xu5V3SVjwOpA4bCRbAxx";

            //estable la conexion
            objConnection = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa");


        } catch (ClassNotFoundException error) {
            System.out.println("error driver not found" + error.getMessage());


        } catch (SQLException e) {

            System.out.println("error al conectar" + e.getMessage());
        }


        return objConnection;
    }

    //metodo para cerrar la conexion
    public static void closeConnection() {
        try {

            //si hay conexion activa la cierra
            if (objConnection != null) {

                objConnection.close();
                System.out.println("finalizo con exito");
            }

        } catch (SQLException e) {
            System.out.println("error al cerrar" + e.getMessage());

        }


    }


}

