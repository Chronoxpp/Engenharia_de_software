import dao.UsuarioDAO;
import entidade.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public void logar()
    {
        String nome = "";
        String senha = "";

        //Requisitando nome
        boolean nomeEstaCorreto = false;
        while(nomeEstaCorreto == false)
        {
            try
            {
                String nomeValidacao = JOptionPane.showInputDialog(null,"Digite o nome");
                if(nomeValidacao == null)
                {
                    nomeEstaCorreto = false;
                }
                else
                {
                    nomeValidacao = nomeValidacao.trim();
                    if(nomeValidacao.equals(""))
                    {
                        nomeEstaCorreto = false;
                    }
                    else
                    {
                        nome = nomeValidacao;
                        nomeEstaCorreto = true;
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente inserir o nome novamente");
                nomeEstaCorreto = false;
            }
        }

        //Requisitando senha
        boolean senhaEstaCorreta = false;
        while(senhaEstaCorreta == false)
        {
            try
            {
                String senhaValidacao = JOptionPane.showInputDialog(null,"Digite a senha");
                if(senhaValidacao == null)
                {
                    senhaEstaCorreta = false;
                }
                else
                {
                    senhaValidacao = senhaValidacao.trim();
                    if(senhaValidacao.equals(""))
                    {
                        senhaEstaCorreta = false;
                    }
                    else
                    {
                        senha = senhaValidacao;
                        senhaEstaCorreta = true;
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente inserir a senha novamente");
                senhaEstaCorreta = false;
            }
        }

        Usuario usuario = new Usuario(senha, nome);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.realizarLogin(usuario))
        {
            JOptionPane.showMessageDialog(null, "Login realizado :), uma pena que não há algo para ser mostrado :(");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Senha ou nome incorretos");
        }
    }

    public void cadastrarNovoUsuario()
    {
        String nome = "";
        String senha = "";

        //Requisitando nome
        boolean nomeEstaCorreto = false;
        while(nomeEstaCorreto == false)
        {
            try
            {
                String nomeValidacao = JOptionPane.showInputDialog(null,"Digite o nome do novo usuario");
                if(nomeValidacao == null)
                {
                    nomeEstaCorreto = false;
                }
                else
                {
                    nomeValidacao = nomeValidacao.trim();
                    if(nomeValidacao.equals(""))
                    {
                        nomeEstaCorreto = false;
                    }
                    else
                    {
                        nome = nomeValidacao;
                        nomeEstaCorreto = true;
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente inserir o nome novamente");
                nomeEstaCorreto = false;
            }
        }

        //Requisitando senha
        boolean senhaEstaCorreta = false;
        while(senhaEstaCorreta == false)
        {
            try
            {
                String senhaValidacao = JOptionPane.showInputDialog(null,"Digite a senha do novo usuario");
                if(senhaValidacao == null)
                {
                    senhaEstaCorreta = false;
                }
                else
                {
                    senhaValidacao = senhaValidacao.trim();
                    if(senhaValidacao.equals(""))
                    {
                        senhaEstaCorreta = false;
                    }
                    else if(senhaValidacao.length() < 6)
                    {
                        senhaEstaCorreta = false;
                    }
                    else
                    {
                        senha = senhaValidacao;
                        senhaEstaCorreta = true;
                    }
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente inserir a senha novamente, minimo de 6 caracteres");
                senhaEstaCorreta = false;
            }
        }

        Usuario usuario = new Usuario(senha, nome);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if(usuarioDAO.consultarUsuario(nome) == null)
        {
            usuarioDAO.cadastrarUsuario(usuario);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ja existe um usuario com esse nome !!!");
        }
    }

    public void listarUsuarios()
    {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarios = usuarioDAO.consultarUsuarios();

        if(usuarios == null || usuarios.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado");
            return;
        }

        String msg = "";
        msg += "Lista de usuarios: \n\n";
        for(Usuario usuario : usuarios)
        {
            msg += "ID: " + usuario.getID() + " | ";
            msg += "Nome: " + usuario.getNome();
            msg += "\n\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public void consultarUsuario()
    {
        Usuario usuario = null;

        boolean IDFoiInserido = false;
        while(IDFoiInserido == false)
        {
            try
            {
                String idString = JOptionPane.showInputDialog(null, "Digite o ID de um usuario", "Consultar usuario",0);
                int id = Integer.parseInt(idString);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuario = usuarioDAO.consultarUsuario(id);
                IDFoiInserido = true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Insira o ID novamente, apenas numeros","Consultar usuario",0);
                IDFoiInserido = false;
            }
        }

        if(usuario == null)
        {
            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado");
            return;
        }

        String msg = "";
        msg += "ID: " + usuario.getID() + " | ";
        msg += "Nome: " + usuario.getNome();

        JOptionPane.showMessageDialog(null, msg);
    }

    public void deletarUsuario()
    {
        int id = -1;

        boolean IDFoiInserido = false;
        while(IDFoiInserido == false)
        {
            try
            {
                String idString = JOptionPane.showInputDialog(null, "Digite o ID do usuario que será deletado");
                id = Integer.parseInt(idString);
                IDFoiInserido = true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Insira o ID novamente, apenas numeros");
                IDFoiInserido = false;
            }
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.deletarUsuario(id))
        {
            JOptionPane.showMessageDialog(null, "Usuario deletado !!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Não foi possivel deletar o usuario ou ele não existe");
        }
    }

    public void alterarUsuario() {
        int id = -1;
        boolean IDFoiInserido = false;
        while (IDFoiInserido == false) {
            try {
                String idString = JOptionPane.showInputDialog(null, "Digite o ID do usuario que será alterado");
                id = Integer.parseInt(idString);
                IDFoiInserido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insira o ID novamente, apenas numeros");
                IDFoiInserido = false;
            }
        }

        //Requisitando nome
        String nome = "";
        boolean nomeEstaCorreto = false;
        while (nomeEstaCorreto == false) {
            try {
                String nomeValidacao = JOptionPane.showInputDialog(null, "Digite o nome do novo usuario");
                if (nomeValidacao == null) {
                    nomeEstaCorreto = false;
                } else {
                    nomeValidacao = nomeValidacao.trim();
                    if (nomeValidacao.equals("")) {
                        nomeEstaCorreto = false;
                    } else {
                        nome = nomeValidacao;
                        nomeEstaCorreto = true;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tente inserir o nome novamente");
                nomeEstaCorreto = false;
            }
        }


        //Requisitando senha
        String senha = "";
        boolean senhaEstaCorreta = false;
        while (senhaEstaCorreta == false)
        {
            try {
                String senhaValidacao = JOptionPane.showInputDialog(null, "Digite a senha do novo usuario");
                if (senhaValidacao == null)
                {
                    senhaEstaCorreta = false;
                }
                else
                {
                    senhaValidacao = senhaValidacao.trim();
                    if (senhaValidacao.equals(""))
                    {
                        senhaEstaCorreta = false;
                    }
                    else if(senha.length() < 6)
                    {
                        senhaEstaCorreta = false;
                    }
                    else
                    {
                        senha = senhaValidacao;
                        senhaEstaCorreta = true;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Tente inserir a senha novamente, minimo de 6 caracteres");
                senhaEstaCorreta = false;
            }
        }

        Usuario usuario = new Usuario(id, senha, nome);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(usuarioDAO.alterarUsuario(usuario.getID(), usuario))
        {
            JOptionPane.showMessageDialog(null, "Usuario foi alterado !!!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o usuario ou ele não existe");
        }
    }
}
