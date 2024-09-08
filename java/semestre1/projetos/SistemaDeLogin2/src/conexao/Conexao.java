package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String url = "jdbc:mysql://localhost:3308/usuariologin";
    private static String usuario = "root";
    private static String senha = "Cluster4546b";

    private static Connection conn = null;

    public static Connection conectar()
    {
        try
        {
            if (conn == null)
            {
                conn = DriverManager.getConnection(url, usuario, senha);
                return conn;
            }
            else
            {
                return conn;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
