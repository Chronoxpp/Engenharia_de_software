import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Sistema 
{
    List<Produto> produtos = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    List<Pagamento> pagamentos = new ArrayList<>();

    //
    public void cadastrarProduto()
    {
        String nomeProduto = obterNomeProduto();
        double preco = obterPreco();
        double estoque = obterEstoque();

        Produto produto = new Produto(nomeProduto, preco, estoque);
        produtos.add(produto);
    }

    //
    private String obterNomeProduto()
    {
        String nomeProduto = "";

        boolean sair = false;
        while(sair == false)
        {
            String msg = "Insira o nome do produto";
            nomeProduto = obterInputUsuario(msg);

            if(nomeProduto == null)
            {
                JOptionPane.showMessageDialog(null, "Insira um nome !!");
                sair = false;
            }
            else
            {
                sair = true;
            }
        }
        
        return nomeProduto;
    }

    //
    private double obterPreco()
    {
        double preco = 0;

        boolean sair = false;
        while(sair == false)
        {
            String msg = "Insira o preco do produto";
            String precoString = obterInputUsuario(msg);

            try
            {
                if(precoString == null)
                {
                    throw new InputMismatchException();
                }   

                preco = Double.parseDouble(precoString);

                if(preco < 0)
                {
                    throw new IllegalArgumentException();
                }
                
                sair = true;
            }

            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Você deve inserir apenas numeros !!");
            }

            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, "O preco deve ser igual ou superior a 0 !!");
            }
            
            catch(InputMismatchException erro)
            {
                JOptionPane.showMessageDialog(null, "Você deve inserir um preco !!");
            }
        }
        
        return preco; 
    }

    //
    private double obterEstoque()
    {
        double estoque = 0;

        boolean sair = false;
        while(sair == false)
        {
            String msg = "Insira a quantidade no estoque";
            String estoqueString = obterInputUsuario(msg);

            try
            {
                if(estoqueString == null)
                {
                    throw new InputMismatchException();
                }

                estoque = Double.parseDouble(estoqueString);
                
                if(estoque < 0)
                {
                    throw new IllegalArgumentException();
                }

                sair = true;
            }
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!");
            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, "O estoque deve ser igual ou superior a 0 !!");
            }
            catch(InputMismatchException erro)
            {
                JOptionPane.showMessageDialog(null, "Você deve inserir uma quantidade !!");
            }
        }
        
        return estoque;
    }

    //
    public String obterInputUsuario(String msg)
    {
        String input = JOptionPane.showInputDialog(msg);

        if(input == null)
        {
            return null;
        }

        input = input.trim();

        if(input.equals(""))
        {
            return null;
        }
        
        return input;
    }

    //
    public void realizarVenda()
    {
        if(clientes.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Cadastre algum cliente !!");
            return;
        }

        if (produtos.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Cadastre algum produto !!");
            return;
        }

        Venda venda  = new Venda();
        JOptionPane.showMessageDialog(null, "Venda iniciada, digite 'Concluir' para concluir a venda");

        boolean vendaConcluida = false;
        while(vendaConcluida == false)
        {
            
            Produto produto = null;

            boolean sair;

            sair = false;
            while(sair == false)
            {
                String nomeProduto = obterNomeProduto();
                if (nomeProduto.equalsIgnoreCase("concluir")) 
                {
                    Cliente cliente = selecionarCliente();
                    while(cliente == null)
                    {
                        cliente = selecionarCliente();
                    }
                    venda.setCliente(cliente);

                    Pagamento pagamento = realizarParcelamento(venda);
                    exibirDadosPagamento(pagamento);

                    return;
                }

                produto = selecionarProduto(nomeProduto);
                if(produto == null)
                {
                    JOptionPane.showMessageDialog(null, "O nome digitado esta incorreto ou o produto não existe !!");
                }
                else
                {
                    sair = true;
                }
            }

            sair = false;
            while(sair == false)
            {

                double quantidade = obterQuantidade();
                if(quantidade <= 0)
                {
                    JOptionPane.showMessageDialog(null, "A quantidade deve ser superior a 0 !!");
                }
                else if(verificarEstoqueDisponivel(produto, quantidade))
                {
                    ItemVenda item = new ItemVenda(produto, quantidade);
                    venda.adicionarItem(item);
                    produto.setEstoque((produto.getEstoque() - quantidade));
                    sair = true;
                }                
            }
        }
    }

    //
    public Produto selecionarProduto(String nomeProduto)
    {

        for(Produto produto : produtos)
        {
            if(produto.getNome().equalsIgnoreCase(nomeProduto))
            {
                return produto;
            }
        }

        return null;
    }

    //
    private double obterQuantidade()
    {
        double quantidade = 0;

        boolean sair = false;
        while(sair == false)
        {
            String msg = "Insira a quantidade";
            String quantidadeString = obterInputUsuario(msg);

            try
            {
                if(quantidadeString == null)
                {
                    throw new InputMismatchException();
                }

                quantidade = Double.parseDouble(quantidadeString);
                
                if(quantidade < 0)
                {
                    throw new IllegalArgumentException();
                }

                sair = true;
            }
            catch(NumberFormatException erro)
            {
                JOptionPane.showMessageDialog(null, "Insira apenas numeros !!");
            }
            catch(IllegalArgumentException erro)
            {
                JOptionPane.showMessageDialog(null, "A quantidade deve ser superior a 0 !!");
            }
            catch(InputMismatchException erro)
            {
                JOptionPane.showMessageDialog(null, "Você deve inserir uma quantidade !!");
            }
        }
        
        return quantidade;
    }

    public boolean verificarEstoqueDisponivel(Produto produto, double quantidadeDesejada)
    {
        try
        {
            if(produto.getEstoque() < quantidadeDesejada)
            {
                throw new ProdutoNaoEncontradoException("Produto sem estoque suficiente !!");
            }
        }

        catch(ProdutoNaoEncontradoException erro)
        {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return false;
        }

        return true;
    }

    //
    public Pagamento realizarParcelamento(Venda venda)
    {
        int quantidadeParcelas = 0;

        boolean sair = false;
        while(sair == false)
        {
            quantidadeParcelas = (int) obterQuantidade();

            if(quantidadeParcelas <= 0)
            {
                JOptionPane.showMessageDialog(null, "A quantidade de parcelas deve ser superior a 0 !!");
            }
            else
            {
                sair = true;
            }
        }

        Pagamento pagamento = new Pagamento(venda, quantidadeParcelas);
        pagamentos.add(pagamento);
        return pagamento;
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

    //
    public void cadastroClientesAutomatico()
    {
        Cliente cliente1 = new Cliente("Max");
        clientes.add(cliente1);

        Cliente cliente2 = new Cliente("Maximus");
        clientes.add(cliente2);
    }

    public void exibirDadosPagamento(Pagamento pagamento)
    {
        String msg = "Valor total = " + pagamento.getVenda().calcularTotal() + "\n";

        msg = msg + pagamento.getParcelas().size() + " parcelas de " + pagamento.getParcelas().get(0).getValor() + " cada";

        JOptionPane.showMessageDialog(null, msg);
    }
}
