import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        String[] botoes = {"Criar triangulo", "Finalizar"};

        boolean sair = false;
        while(sair == false)
        {
            int botaoClicado = JOptionPane.showOptionDialog(null, "Selecioone uma ação", "Home", 0, 0, null, botoes, 0);

            if(botaoClicado == 0)
            {
                String triangulo = sistema.montarTringulo(sistema.obterLado(), sistema.obterLado(), sistema.obterLado());

                if(triangulo == null)
                {
                    JOptionPane.showMessageDialog(null, "Não foi possivel montar um triangulo com as medidas informadas");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Você montou um triangulo " + triangulo);
                }
            }
            else
            {
                sair = true;
                JOptionPane.showMessageDialog(null, "Encerrando...");
            }
        }
    }
}