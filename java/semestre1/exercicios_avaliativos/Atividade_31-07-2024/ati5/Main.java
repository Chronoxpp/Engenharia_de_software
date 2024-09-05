import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String[] args)
    {
        Object[] botoes = {"Cadastrar candidato", "Cadastrar eleitor", "Votar", "Exibir resultados", "Finalizar"};
        SistemaVotacao sistema = new SistemaVotacao();

        boolean sair = false;
        while(sair != true)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma ação", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                sistema.cadastrarCandidato();
            }
            else if (opcaoSelecionada == 1)
            {
                sistema.cadastrarEleitor();
            }
            else if(opcaoSelecionada == 2)
            {
                sistema.realizarVotacao();
            }
            else if(opcaoSelecionada == 3)
            {
                sistema.exibirResultadosVotacao();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Encerrando...");
                sair = true;
            }
        }
    }
}
