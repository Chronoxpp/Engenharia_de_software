package dao;

import conexao.Conexao;
import entidade.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO<SQLExcption> {
    public void cadastrarUsuario(Usuario usuario)
    {
        String sql = "INSERT INTO usuario(nome, senha) values (?, ?);";

        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());

            System.out.println(ps.toString());
            ps.execute();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Usuario> consultarUsuarios()
    {
        String sql = "SELECT * FROM usuario;";

        ResultSet rs;
        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            rs = null;
        }

        if(rs == null)
        {
            return null;
        }

        List<Usuario> usuarios = new ArrayList<Usuario>();
        try
        {
            while (rs.next())
            {
                int id = rs.getInt("ID");
                String nome = rs.getString("nome");

                Usuario usuario = new Usuario(id, nome);
                usuarios.add(usuario);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        if (usuarios.isEmpty())
        {
            return null;
        }
        else
        {
            return usuarios;
        }
    }

    public Usuario consultarUsuario(int id)
    {
        String sql = "SELECT * FROM usuario where ID = ? ;";

        PreparedStatement ps = null;
        try
        {
            ps = Conexao.conectar().prepareStatement(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        try
        {
            ps.setInt(1, id);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        try
        {
            ResultSet rs = ps.executeQuery();

            rs.next();
            String nome = rs.getString("nome");
            Usuario usuario = new Usuario(id, nome);

            ps.close();
            return usuario;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario consultarUsuario(String nome)
    {
        String sql = "SELECT * FROM usuario where nome = ? ;";

        PreparedStatement ps = null;
        try
        {
            ps = Conexao.conectar().prepareStatement(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        try
        {
            ps.setString(1, nome);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        try
        {
            ResultSet rs = ps.executeQuery();

            rs.next();
            int id = rs.getInt("ID");
            Usuario usuario = new Usuario(id, nome);

            ps.close();
            return usuario;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deletarUsuario(int id)
    {
        Usuario usuario = consultarUsuario(id);

        if (usuario == null)
        {
            return false;
        }

        String sql = "DELETE FROM usuario WHERE ID = ? ;";

        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();

            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterarUsuario(int id, Usuario usuario)
    {
        Usuario usuarioBD = consultarUsuario(id);
        if(usuarioBD == null)
        {
            return false;
        }

        String sql = "update usuario set nome = ?, senha =  ? where ID = ?";

        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(3, usuario.getID());
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.execute();
            ps.close();

            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean realizarLogin(Usuario usuario)
    {
        String sql = "select * from usuario where nome = ? and senha = ? ;";

        ResultSet rs = null;
        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());

            rs = ps.executeQuery();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        if(rs == null)
        {
            return false;
        }

        try
        {
            rs.next();
            System.out.println(rs.getString("nome"));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
