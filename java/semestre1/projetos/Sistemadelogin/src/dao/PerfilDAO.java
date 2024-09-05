package dao;

import conexao.Conexao;
import entity.Perfil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilDAO
{
    public void cadastrarPerfil(Perfil perfil)
    {

        String sql = "INSERT INTO perfil(nome, descricao) values (?,?)";

        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, perfil.getNome());
            ps.setString(2, perfil.getDescricao());
            ps.execute();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Perfil buscarPerfilPorID(int id)
    {
        String sql = "Select * from perfil where id = ?";

        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                Perfil perfil = new Perfil();
                perfil.setIdPerfil(rs.getInt("id"));
                perfil.setNome(rs.getString("nome"));
                perfil.setDescricao(rs.getString("descricao"));
                return perfil;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public void atualizarPerfil(Perfil perfil)
    {
        String sql = "UPDATE perfil SET nome = ?, descricao = ? where id = ?;";
        try
        {
            PreparedStatement ps = Conexao.conectar().prepareStatement(sql);
            ps.setString(1, perfil.getNome());
            ps.setString(2, perfil.getDescricao());
            ps.setInt(3, perfil.getIdPerfil());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
