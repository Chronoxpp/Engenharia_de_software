import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Venda> vendas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto()
    {
        String nome = obterNomeProduto();
        if(nome == null || nome.length() <= 0)
        {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado !!");
            return;
        }

        int quantidadeEstoque = obterQuantidadeEstoqueDoProduto();
        if(quantidadeEstoque < 0)
        {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado");
            return;
        }

        double preco = obterPrecoProduto();
        if(preco <= 0)
        {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado");
            return;
        }

        Produto produto = new Produto(nome, preco, quantidadeEstoque);
        produtos.add(produto);
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

    public double obterPrecoProduto()
    {
        String precoString;
        double preco = 0;
        boolean precoValidado = false;

        while(precoValidado == false)
        {
            precoString = JOptionPane.showInputDialog("Digite o preco do produto: ");

            if(precoString == null)
                return -1;

            precoString = precoString.trim();
            precoString = precoString.replaceAll(",", ".");

            try
            {
                preco = Double.parseDouble(precoString);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente digitar o preco novamente !!");
                continue;
            }

            if(preco <= 0)
            {
                JOptionPane.showMessageDialog(null, "O preco deve ser superior a 0 !!");
                continue;
            }

            precoValidado = true;
        }

        return preco;
    }

    public int obterQuantidadeEstoqueDoProduto()
    {
        String quantidadeString;
        int quantidade = 0;
        boolean quantidadeValidada = false;

        while(quantidadeValidada == false)
        {
            quantidadeString = JOptionPane.showInputDialog("Digite a quantidade em estoque do produto: ");

            if(quantidadeString == null)
                return -1;

            quantidadeString = quantidadeString.trim();
            quantidadeString = quantidadeString.replaceAll(",", ".");

            try
            {
                quantidade = Integer.parseInt(quantidadeString);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente digitar a quantidade novamente !!" + "\n A quantidade não pode ser um numero fracionado !!");
                continue;
            }

            if(quantidade < 0)
            {
                JOptionPane.showMessageDialog(null, "O quantidade deve ser igual ou superior a 0 !!");
                continue;
            }

            quantidadeValidada = true;
        }

        return quantidade;
    }

    public int obterQuantidade()
    {
        String quantidadeString;
        int quantidade = 0;
        boolean quantidadeValidada = false;

        while(quantidadeValidada == false)
        {
            quantidadeString = JOptionPane.showInputDialog("Digite a quantidade: ");

            if(quantidadeString == null)
                return -1;

            quantidadeString = quantidadeString.trim();
            quantidadeString = quantidadeString.replaceAll(",", ".");

            try
            {
                quantidade = Integer.parseInt(quantidadeString);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Tente digitar a quantidade novamente !!" + "\n A quantidade não pode ser um numero fracionado !!");
                continue;
            }

            if(quantidade <= 0)
            {
                JOptionPane.showMessageDialog(null, "O quantidade deve ser superior a 0 !!");
                continue;
            }

            quantidadeValidada = true;
        }

        return quantidade;
    }
}
