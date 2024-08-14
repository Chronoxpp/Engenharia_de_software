import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Aplicacao {
    static List<Vendedor> vendedores =  new ArrayList<>();
    static List<Produto> produtos = new ArrayList<>();
    static List<Venda> vendas =  new ArrayList<>();

    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Atribuindo vendas a vendedores");

        
        Vendedor vendedor1 = new Vendedor(JOptionPane.showInputDialog("Insira o nome do vendedor 1:"));
        vendedores.add(vendedor1);

        Vendedor vendedor2 = new Vendedor(JOptionPane.showInputDialog("Insira o nome do vendedor 2:"));
        vendedores.add(vendedor2);

        Vendedor vendedor3 = new Vendedor(JOptionPane.showInputDialog("Insira o nome do vendedor 3:"));
        vendedores.add(vendedor3);

        
        Produto produto1 = new Produto(JOptionPane.showInputDialog("Nome do produto 1:"), 5);
        produtos.add(produto1);

        Produto produto2 = new Produto(JOptionPane.showInputDialog("Nome do produto 2:"), 10);
        produtos.add(produto2);

        Produto produto3 = new Produto(JOptionPane.showInputDialog("Nome do produto 3:"), 15);
        produtos.add(produto3);


        Object[] botoes = {"Iniciar nova venda","Consultar total vendido", "Finalizar"};
        ImageIcon icone = new ImageIcon("comercio-e-compras.png");

        int opcaoSelecionada = 0;
        while (opcaoSelecionada != 2) 
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opcao", "opcoes", 0, 0, icone , botoes, 0);

            if(opcaoSelecionada == 0)
            {
                iniciarNovaVenda();
            }
            else if(opcaoSelecionada == 1)
            {
                consultaTotaisPorVendedor();
            }
            else if(opcaoSelecionada == 2)
            {
                JOptionPane.showMessageDialog(null, "Encerrando...");
            }
        }
    }

    static void iniciarNovaVenda()
    {
        Venda venda = new Venda();
        vendas.add(venda);

        ImageIcon icone = new ImageIcon("comercio-e-compras.png");
        Object[] botoes = {"Adicionar item","Concluir","Cancelar"};

        int opcaoSelecionada = 0;
        while (opcaoSelecionada != 2) 
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "O que você deseja fazer ?", "opcoes", 0, 0, icone , botoes, 0);

            if(opcaoSelecionada == 0)
            {
                venda.adicionarProduto(buscarProduto());
            }
            else if(opcaoSelecionada == 1)
            {
                Vendedor vendedor = buscarVendedor();
                vendedor.registrarVenda(venda);
                return;
            }
            else if(opcaoSelecionada == 2)
            {
                vendas.remove(venda);
            }
        }
    }


    static Produto buscarProduto()
    {
        Object[] vetorProdutos = new Object[produtos.size()];
        for(int i = 0; i < vetorProdutos.length; i++)
        {
            vetorProdutos[i] = produtos.get(i).getNome();
        }

        int opcaoSelecionada;
        opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um produto", "opcoes", 0, 0, null , vetorProdutos, 0);

        return produtos.get(opcaoSelecionada);
    }


    static Vendedor buscarVendedor()
    {
        Object[] vetorVendedores = new Object[vendedores.size()];
        for(int i = 0; i < vetorVendedores.length; i++)
        {
            vetorVendedores[i] = vendedores.get(i).getNome();
        }

        int opcaoSelecionada;
        opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um vendedor", "opcoes", 0, 0, null , vetorVendedores, 0);

        return vendedores.get(opcaoSelecionada);
    }


    static void consultaTotaisPorVendedor()
    {
        Vendedor vendedor = buscarVendedor();

        double total = 0;
        for(Venda venda : vendedor.getVendas())
        {
            total = total + venda.calcularTotal();
        }

        JOptionPane.showMessageDialog(null, "Total vendido por " + vendedor.getNome() + ": " + total + " reais");
    }
}
