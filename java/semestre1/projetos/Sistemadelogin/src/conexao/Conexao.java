package conexao;

import java.sql.*;

public class Conexao
{
    private static final String url = "jdbc:mysql://localhost:3308/primeiroprograma";
    private static final String user = "root";
    private static final String password = "Cluster4546b";

    private static Connection conn = null;

    public static Connection conectar()
    {
        try
        {
            if(conn == null)
            {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }
            else
            {
                return conn;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
