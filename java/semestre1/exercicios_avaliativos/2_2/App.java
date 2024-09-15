import javax.swing.*;

public class App {
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        String[] botoes = {"Cadastrar produto", "Vender", "Sair"};

        boolean sair = false;
        while(sair == false)
        {
            int botaoClicado = JOptionPane.showOptionDialog(null, "Selecione uma ação" , "HOME", 0, 0, null, botoes, 0);

            if(botaoClicado == 0)
            {
                sistema.cadastrarProduto();
            }
            else if(botaoClicado == 1)
            {
                sistema.realizarVenda();
            }
            else if(botaoClicado == 2 || botaoClicado < 0)
            {
                JOptionPane.showMessageDialog(null, "Encerrando...");
                sair = true;
            }
        }
    }
}
