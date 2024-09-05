import entity.Usuario;
import entity.*;
import dao.*;

public class App
{
    public static void main(String[] args)
    {
        PerfilDAO dao = new PerfilDAO();
        Perfil perfil = new Perfil();
        perfil = dao.buscarPerfilPorID(1);

        System.out.println(perfil.getNome());
    }
}