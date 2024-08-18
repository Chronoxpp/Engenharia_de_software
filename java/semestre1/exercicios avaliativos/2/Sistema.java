import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sistema 
{
    List<Produto> produtos = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Pagamento> pagamentos = new ArrayList<>();

    public void realizarVenda()
    {
        if(clientes.isEmpty())
        {
            return;
        }

        if (produtos.isEmpty()) 
        {
            return;
        }

        Venda venda = new Venda();

        boolean sair = false;
        while(sair == false)
        {
            Produto produto = selecionarProduto();

            int quantidade = obterQuantidade();

            if(verificarEstoqueDisponivel(produto, quantidade))
            {
                ItemVenda item = new ItemVenda(produto, quantidade);
                venda.adicionarItem(item);
                sair = true;
            }
        }

        Cliente cliente = selecionarCliente();

        venda.setCliente(cliente);

        realizarParcelamento(venda);
    }

    public Produto selecionarProduto()
    {
        String[] nomeProdutos = new String[produtos.size()];

        for(int i = 0; i < nomeProdutos.length; i += 1)
        {
            nomeProdutos[i] = produtos.get(i).getNome();
        }

        int opcaoSelecionada = 0;
        boolean sair = false;
        while(sair == false)
        {
            try
            {
                opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha um produto", "Produtos", 0, 0, null, nomeProdutos, 0);

                if (opcaoSelecionada < 0) 
                {
                    throw new IllegalArgumentException("Selecionado index de um produto inexistente");
                }

                sair = true;
            }
            catch(IllegalArgumentException erro)
            {
                sair = false;
                JOptionPane.showMessageDialog(null, "Selecione um produto corretamente");
            }
            catch(Exception erro)
            {
                JOptionPane.showMessageDialog(null, "Tente selecionar o produto novamente");
            }
        }

        return produtos.get(opcaoSelecionada);
    }

    public boolean verificarEstoqueDisponivel(Produto produto, int quantidadeDesejada)
    {
        try
        {
            if(produto.getEstoque() < quantidadeDesejada)
            {
                throw new ProdutoNaoEncontradoException("Produto sem estoque suficiente !!!");
            }
        }
        catch(ProdutoNaoEncontradoException erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

        return true;
    }

    public void realizarParcelamento(Venda venda)
    {
        int quantidadeParcelas = 0;

        boolean sair = false;
        while(sair == false)
        {
            quantidadeParcelas = obterQuantidade();

            if(quantidadeParcelas <= 0)
            {
                sair = false;
            }
            else
            {
                sair = true;
            }
        }

        Pagamento pagamento = new Pagamento(venda, quantidadeParcelas);
        pagamentos.add(pagamento);
    }

    public Cliente selecionarCliente()
    {
        String[] clientes = {"Max", "Maximus"};

        boolean sair = false;
        int opcaoSelecionada = 0;
        while(sair == false)
        {
            try
            {
                opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um cliente", "Clientes", 0, 0, null, clientes, 0);
                if (opcaoSelecionada < 0) 
                {
                    throw new IllegalArgumentException("Index de um cliente inexistente");
                }

                sair = true;
            }
            catch(IllegalArgumentException erro)
            {
                sair = false;
                JOptionPane.showMessageDialog(null, "Insira um cliente !");
            }
            catch(Exception erro)
            {
                sair = false;
                JOptionPane.showMessageDialog(null, "Tente selecionar um cliente novamente !!!");
            }
        }

        Cliente cliente = this.clientes.get(opcaoSelecionada);

        return cliente;
    }


    public void cadastroProdutosAutomatico()
    {
        Produto produto1 = new Produto("Banana", 5, 100);
        produtos.add(produto1);

        Produto produto2 = new Produto("Maçã", 10, 100);
        produtos.add(produto2);

        Produto produto3 = new Produto("Pera", 15, 100);
        produtos.add(produto3);
    }

    public void cadastrarProduto()
    {
        String nomeProduto = obterNomeProduto();
        double preco = obterPreco();
        double quantidade = obterQuantidade();

        Produto produto = new Produto(nomeProduto, preco, quantidade);
        produtos.add(produto);
    }

    private String obterNomeProduto()
    {
        String nomeProduto = "";

        boolean sair = false;
        while(sair == false)
        {
            nomeProduto = JOptionPane.showInputDialog("Insira o nome do produto");

            if(nomeProduto == null)
            {
                JOptionPane.showMessageDialog(null, "Insira o nome corretamente !!!");
                sair = false;
            }
            else
            {
                nomeProduto = nomeProduto.replace(" ", "");
                
                if(nomeProduto.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Insira o nome corretamente !!!");
                    sair = false;
                }
                else
                {
                    sair = true;
                }
            }
        }
        
        return nomeProduto;
    }

    private double obterPreco()
    {
        double preco = 0;

        boolean sair = false;
        while(sair == false)
        {
            String precoString = JOptionPane.showInputDialog("Insira o preco do produto");

            try
            {
                preco = Double.parseDouble(precoString);
                
                if(preco < 0)
                {
                    throw new IllegalArgumentException("O preco nao pode ser negativo");
                }

                sair = true;
            }
            catch(NumberFormatException erro)
            {

            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
        
        return preco; 
    }

    private int obterQuantidade()
    {
        int quantidade = 0;

        boolean sair = false;
        while(sair == false)
        {
            String quantidadeString = JOptionPane.showInputDialog("Insira a quantidade");

            try
            {
                quantidade = Integer.parseInt(quantidadeString);
                
                if(quantidade < 0)
                {
                    throw new IllegalArgumentException("a quantidade nao pode ser negativa");
                }

                sair = true;
            }
            catch(NumberFormatException erro)
            {

            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
        
        return quantidade; 
    }

    public void cadastroClientesAutomatico()
    {
        Cliente cliente1 = new Cliente("Max");
        clientes.add(cliente1);


        Cliente cliente2 = new Cliente("Maximus");
        clientes.add(cliente2);
    }
}
