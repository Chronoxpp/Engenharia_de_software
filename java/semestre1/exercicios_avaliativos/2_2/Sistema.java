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
        String nome = "";

        while(nome.length() <= 0)
        {
            nome = JOptionPane.showInputDialog("Digite o nome do produto: ");

            if(nome == null)
                return null;

            nome = nome.trim();
            if(nome.length() <= 0)
            {
                JOptionPane.showMessageDialog(null, "Tente digitar o nome novamente !!");
            }
        }

        return nome;
    }
}
