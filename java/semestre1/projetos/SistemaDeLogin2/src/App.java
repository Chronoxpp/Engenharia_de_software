import javax.swing.*;

public class App {
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        String[] botoes = {"Cadastrar", "Alterar", "Listar", "Consultar", "Deletar", "Logar", "Sair"};

        int botaoClicado = -1;
        while(botaoClicado != 6)
        {
            botaoClicado = JOptionPane.showOptionDialog(null,"Selecione uma opcao", "Home", 0,0, null, botoes, 0);

            if(botaoClicado == 0)
            {
                sistema.cadastrarNovoUsuario();
            }
            else if(botaoClicado == 1)
            {
                sistema.alterarUsuario();
            }
            else if(botaoClicado == 2)
            {
                sistema.listarUsuarios();
            }
            else if(botaoClicado == 3)
            {
                sistema.consultarUsuario();
            }
            else if(botaoClicado == 4)
            {
                sistema.deletarUsuario();
            }
            else if(botaoClicado == 5)
            {
                sistema.logar();
            }
            else if(botaoClicado == 6)
            {
                JOptionPane.showMessageDialog(null,"Encerrando...");
            }
        }
    }
}
