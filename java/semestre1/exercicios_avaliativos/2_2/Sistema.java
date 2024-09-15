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
        Venda venda = new Venda();

        String[] botoes = {"Inserir produto", "Concluir", "Cancelar"};

        boolean sair = false;
        while(sair == false)
        {
            int botaoClicado = JOptionPane.showOptionDialog(null, "Selecione uma ação" , "Venda", 0, 0, null, botoes, 0);

            if(botaoClicado == 0)
            {
                inserirItemVenda(venda);
            }
            else if(botaoClicado == 1)
            {
                concluirVenda(venda);
                sair = true;
            }
            else if(botaoClicado == 2 || botaoClicado < 0)
            {
                JOptionPane.showMessageDialog(null, "Venda cancelada !!");
                sair = true;
            }
        }
    }

    public Produto consultarProduto()
    {
        String nomePesquisado = obterNomeProduto();

        if(nomePesquisado == null)
            return null;

        for(Produto produto : produtos)
        {
            if(produto.getNome().equals(nomePesquisado))
                return produto;
        }

        JOptionPane.showMessageDialog(null, "Nenhum produto com este nome foi encontrado !!");
        return null;
    }

    public void inserirItemVenda(Venda venda)
    {
        if(venda == null)
            return;

        Produto produto = consultarProduto();

        if(produto == null)
            return;

        int quantidade = obterQuantidade();

        if(quantidade <= 0)
            return;

        ItemVenda item = new ItemVenda(produto, quantidade);

        try
        {
            item.verificarEstoque();
        }
        catch(ProdutoNaoEncontradoException erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return;
        }

        venda.getItens().add(item);
        item.removerEstoque(quantidade);

        JOptionPane.showMessageDialog(null, "Produto adicionado" + "\n\nProduto: " + produto.getNome() + "\nQuantidade: " + quantidade);
    }

    public void concluirVenda(Venda venda)
    {
        if(venda == null)
            return;

        if(venda.getItens().isEmpty())
            return;

        JOptionPane.showMessageDialog(null, "Digite a quantidade de parcelas na proxima seção");
        int quantidade = obterQuantidade();

        if(quantidade <= 0)
            return;

        venda.gerarParcelas(quantidade);

        String msg = "";
        msg += "Totais: \n\n";
        msg += "Total da venda: " + "R$" + venda.calcularTotal();
        msg += "\nQuantidade de parcelas: " + venda.getParcelas().size();
        msg += "\nValor de cada parcela: " + "R$" + venda.getParcelas().get(0).getValor();
        JOptionPane.showMessageDialog(null, msg);
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
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!");
                continue;
            }

            try
            {
                if(preco <= 0)
                    throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, "O preco deve ser superior a 0 !!");
                continue;
            }

            precoValidado = true;
        }

        return preco;
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
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!" + "\n A quantidade não pode ser um numero fracionado !!");
                continue;
            }

            try
            {
                if(quantidade <= 0)
                    throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, "O quantidade deve ser superior a 0 !!");
                continue;
            }

            quantidadeValidada = true;
        }

        return quantidade;
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
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!" + "\n A quantidade não pode ser um numero fracionado !!");
                continue;
            }

            try
            {
                if(quantidade < 0)
                    throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, "O quantidade deve ser igual ou superior a 0 !!");
                continue;
            }

            quantidadeValidada = true;
        }

        return quantidade;
    }


}
