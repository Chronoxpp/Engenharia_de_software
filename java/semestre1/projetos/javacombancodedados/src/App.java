import java.util.List;

import entity.Usuario;
import dao.UsuarioDAO;

public class App {
    public static void main(String[] args) throws Exception {
        // // Cadastrar um novo usuário
        Usuario novoUsuario = new Usuario();
        // novoUsuario.setNome("Carlos");
        // novoUsuario.setLogin("carlos123");
        // novoUsuario.setSenha("1234");
        // novoUsuario.setEmail("carlos@gmail.com");
        // novoUsuario.setPerfil(1);  // 1 pode representar, por exemplo, um perfil de administrador
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        // usuarioDAO.cadastrarUsuario(novoUsuario);

        // Buscar um usuário por ID
        Usuario usuarioBuscado = usuarioDAO.getUsuarioById(1);
        if (usuarioBuscado != null) {
            System.out.println("Usuário encontrado: " + usuarioBuscado.getId() + usuarioBuscado.getNome() + ", Perfil: " + usuarioBuscado.getPerfil());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Atualizar um usuário
        usuarioBuscado.setNome("Neto Atualizado");
        usuarioBuscado.setPerfil(3);  // 2 pode representar, por exemplo, um perfil de usuário comum
        // nao posso alterar o ID
        usuarioDAO.atualizarUsuario(usuarioBuscado);

        // // Listar todos os usuários
        // List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        // for (Usuario usuario : usuarios) {
        //     System.out.println(usuario.getId() + ": " + usuario.getNome() + " (" + usuario.getLogin() + "), Perfil: " + usuario.getPerfil());
        // }

        // Deletar um usuário
        // usuarioDAO.deletarUsuario(2);
    }
}