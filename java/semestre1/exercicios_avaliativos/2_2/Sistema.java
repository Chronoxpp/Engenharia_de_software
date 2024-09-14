import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Venda> vendas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto()
    {
        //Nome produto,valor e estoque
    }

    public void realizarVenda()
    {

    }

    public void realizarParcelamento(Venda venda)
    {

    }

    public String obterNomeProduto()
    {
        String nome = null;

        while(nome == null)
        {
            nome = JOptionPane.showInputDialog("Digite o nome do produto: ");

            if(nome == null)
            {
                JOptionPane.showMessageDialog(null, "Tente digitar o nome novamente !!");
                continue;
            }

            nome = nome.trim();
        }

        return nome;
    }
}
