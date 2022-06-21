package adventureworks2019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    public static Connection getConexion() {
        String url = "jdbc:sqlserver://localhost:1433;"
                + "database=adventureWorks2019;"
                + "user=sa;"
                + "password=discon3t159;";

        try {
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

}
