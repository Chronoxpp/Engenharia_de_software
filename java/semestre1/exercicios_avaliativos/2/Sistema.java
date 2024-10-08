import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Sistema {
    private List<Venda> vendas = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    //
    public void cadastrarProduto()
    {
        String nome;
        int quantidadeEstoque;
        double preco;

        try
        {
            nome = obterNomeProduto();
            quantidadeEstoque = obterQuantidadeEstoqueDoProduto();
            preco = obterPrecoProduto();
        }
        catch (IllegalArgumentException erro)
        {
            JOptionPane.showMessageDialog(null, "Cadastro cancelado !!");
            return;
        }

        Produto produto = new Produto(nome, preco, quantidadeEstoque);
        produtos.add(produto);
    }

    //
    public String obterNomeProduto()
    {
        String nome = "";

        while(nome.length() <= 0)
        {
            nome = JOptionPane.showInputDialog("Digite o nome do produto: ");

            if(nome == null)
                throw new IllegalArgumentException();

            nome = nome.trim();
            if(nome.length() <= 0)
            {
                JOptionPane.showMessageDialog(null, "Tente digitar o nome novamente !!");
            }
        }

        return nome;
    }

    //
    public int obterQuantidadeEstoqueDoProduto()
    {
        String quantidadeString;
        int quantidade = 0;
        boolean quantidadeValidada = false;

        while(quantidadeValidada == false)
        {
            quantidadeString = JOptionPane.showInputDialog("Digite a quantidade em estoque do produto: ");

            if(quantidadeString == null)
                throw new IllegalArgumentException();

            quantidadeString = quantidadeString.trim();
            quantidadeString = quantidadeString.replaceAll(",", ".");

            try
            {
                quantidade = Integer.parseInt(quantidadeString);

                if(quantidade < 0)
                    throw new IllegalArgumentException();
            }
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!" + "\n A quantidade não pode ser um numero fracionado !!");
                continue;
            }
            catch(IllegalArgumentException erro)
            {
                //Esse segundo try é desnecessario, esta aqui apenas para atender o comando da atividade
                try
                {
                    throw new InputMismatchException();
                }
                catch(InputMismatchException erro2)
                {
                    JOptionPane.showMessageDialog(null, "O quantidade deve ser igual ou superior a 0 !!");
                    continue;
                }
            }

            quantidadeValidada = true;
        }

        return quantidade;
    }

    //
    public double obterPrecoProduto()
    {
        String precoString;
        double preco = 0;
        boolean precoValidado = false;

        while(precoValidado == false)
        {
            precoString = JOptionPane.showInputDialog("Digite o preco do produto: ");

            if(precoString == null)
                throw new IllegalArgumentException();

            precoString = precoString.trim();
            precoString = precoString.replaceAll(",", ".");

            try
            {
                preco = Double.parseDouble(precoString);

                if(preco <= 0)
                    throw new IllegalArgumentException();

            }
            catch(NumberFormatException erro)
            {
                //Esse segundo try é desnecessario, esta aqui apenas para atender o comando da atividade
                try
                {
                    throw new InputMismatchException();
                }
                catch(InputMismatchException erro2)
                {
                    JOptionPane.showMessageDialog(null, "Insira apenas numeros !!");
                    continue;
                }
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
                estornarProdutos(venda);
                JOptionPane.showMessageDialog(null, "Venda cancelada !!");
                sair = true;
            }
        }
    }

    //
    public void inserirItemVenda(Venda venda)
    {
        if(venda == null)
            return;

        Produto produto = consultarProduto();

        if(produto == null)
            return;

        int quantidade;

        try
        {
            quantidade = obterQuantidade();
        }
        catch(IllegalArgumentException erro)
        {
            return;
        }

        ItemVenda item = new ItemVenda(produto, quantidade);

        try
        {
            item.verificarEstoque();
        }
        catch(IllegalArgumentException erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return;
        }

        venda.getItens().add(item);
        item.removerEstoque(quantidade);

        JOptionPane.showMessageDialog(null, "Produto adicionado" + "\n\nProduto: " + produto.getNome() + "\nQuantidade: " + quantidade);
    }

    //
    public Produto consultarProduto()
    {
        String nomePesquisado;

        try
        {
            nomePesquisado = obterNomeProduto();
        }
        catch(IllegalArgumentException erro)
        {
            return null;
        }

        for(Produto produto : produtos)
        {
            if(produto.getNome().equals(nomePesquisado))
                return produto;
        }

        try
        {
            throw new ProdutoNaoEncontradoException("Nenhum produto encontrado !!");
        }
        catch(ProdutoNaoEncontradoException erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return null;
        }
    }

    //
    public int obterQuantidade()
    {
        String quantidadeString;
        int quantidade = 0;
        boolean quantidadeValidada = false;

        while(quantidadeValidada == false)
        {
            quantidadeString = JOptionPane.showInputDialog("Digite a quantidade: ");

            if(quantidadeString == null)
                throw new IllegalArgumentException();

            quantidadeString = quantidadeString.trim();
            quantidadeString = quantidadeString.replaceAll(",", ".");

            try
            {
                quantidade = Integer.parseInt(quantidadeString);

                if(quantidade <= 0)
                    throw new IllegalArgumentException();
            }
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!" + "\n A quantidade não pode ser um numero fracionado !!");
                continue;
            }
            catch(IllegalArgumentException erro)
            {
                //Esse segundo try é desnecessario, esta aqui apenas para atender o comando da atividade
                try
                {
                    throw new InputMismatchException();
                }
                catch(InputMismatchException erro2)
                {
                    JOptionPane.showMessageDialog(null, "O quantidade deve ser superior a 0 !!");
                    continue;
                }
            }

            quantidadeValidada = true;
        }

        return quantidade;
    }

    //
    public void concluirVenda(Venda venda)
    {
        if(venda == null)
            return;

        if(venda.getItens().isEmpty())
            return;

        JOptionPane.showMessageDialog(null, "Digite a quantidade de parcelas");
        int quantidadeParcelas;

        try
        {
            quantidadeParcelas = obterQuantidade();
            double teste = venda.calcularTotal() / (double)quantidadeParcelas; //Verifica se é possivel realizar a divisao para gerar as parcelas
        }
        catch(IllegalArgumentException erro)
        {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser superior a 0 !!");
            return;
        }
        catch(ArithmeticException erro)
        {
            JOptionPane.showMessageDialog(null, "A quantidade deve ser superior 0 !!"); //Tratamento pra quando a quantidade de parcelas for 0
            return;
        }

        venda.gerarParcelas(quantidadeParcelas);

        String msg = "";
        msg += "Totais: \n\n";
        msg += "Total da venda: " + "R$" + venda.calcularTotal();
        msg += "\nQuantidade de parcelas: " + venda.getParcelas().size();
        msg += "\nValor de cada parcela: " + "R$" + venda.getParcelas().get(0).getValor();
        JOptionPane.showMessageDialog(null, msg);
    }

    private void estornarProdutos(Venda venda)
    {
        if(venda == null)
            return;

        if(venda.getItens().isEmpty())
            return;

        for(ItemVenda item : venda.getItens())
        {
            item.getProduto().adicionarEstoque(item.getQuantidade());
        }
    }
}
