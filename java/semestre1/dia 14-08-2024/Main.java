import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        sistema.cadastroClientesAutomatico();

        String[] botoes = {"Cadastrar produto", "Realizar venda", "Finalizar"};

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um ação", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                sistema.cadastrarProduto();
            }
            else if(opcaoSelecionada == 1)
            {
                sistema.realizarVenda();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Encerrando...");
                sair = true;
            }
        }
    }
}
