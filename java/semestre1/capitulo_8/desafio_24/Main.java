//Desenvolvido por: Lucas Dourado Rodrigues

import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        String[] botoes = {"Adicionar temperatura", "Exibir temperaturas", "Sair"};

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma ação", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                sistema.adicionarTemperatura();
            }
            else if( opcaoSelecionada == 1)
            {
                sistema.exibirTemperaturasExtremas();
            }
            else
            {
                sair = true;
                JOptionPane.showMessageDialog(null, "Encerrando...");
            }
        }
    }
}