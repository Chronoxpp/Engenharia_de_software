import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Realizando vendas");

        Cliente cliente1 = new Cliente(JOptionPane.showInputDialog("Insira o nome do cliente: "));


        List<Produto> produtos = new ArrayList<>();

        Produto produto1 = new Produto(JOptionPane.showInputDialog("Nome do produto 1:"), 2);
        produtos.add(produto1);

        Produto produto2 = new Produto(JOptionPane.showInputDialog("Nome do produto 2:"), 4);
        produtos.add(produto2);

        Produto produto3 = new Produto(JOptionPane.showInputDialog("Nome do produto 3:"), 6);
        produtos.add(produto3);

        
        Pedido pedido1 = new Pedido(cliente1);

        Object[] botoes = {"Consultar produtos","Adicionar item", "Remover item", "Concluir"};
        ImageIcon icone = new ImageIcon("comercio-e-compras.png");

        int opcaoSelecionada = 0;
        while (opcaoSelecionada != 3) 
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Realize uma venda !", "opcoes", 0, 0, icone , botoes, 0);

            if(opcaoSelecionada == 0)
            {
                JOptionPane.showMessageDialog(null, listarProdutos(produtos));
            }
            else if(opcaoSelecionada == 1)
            {
                ItemPedido item = criarItemPedido(buscarProduto(produtos));
                pedido1.adicionarItem(item);
            }
            else if(opcaoSelecionada == 2)
            {
                ItemPedido item = buscarItem(pedido1);
                pedido1.removerItem(item);
            }
            else if(opcaoSelecionada == 3)
            {
                JOptionPane.showMessageDialog(null, "Total da venda: " + pedido1.calcularTotal() + " reais");
            }
        }
    }


    static String listarProdutos(List<Produto> produtos)
    {
        String listaProdutos = "Nome  |  Valor \n \n";
        for(Produto produto : produtos)
        {
            listaProdutos = listaProdutos + produto.getNome() + "  |  " + produto.getPreco() + "\n";
        }
        return listaProdutos;
    }


    static Produto buscarProduto(List<Produto> produtos)
    {
        String nomeProduto = JOptionPane.showInputDialog("Insira o nome do produto");
        for(Produto produto : produtos)
        {
            if(produto.getNome().equalsIgnoreCase(nomeProduto))
            {
                return produto;
            }
        }
        return null;
    }


    static ItemPedido criarItemPedido(Produto produto)
    {
        ItemPedido item = new ItemPedido(produto, Double.parseDouble(JOptionPane.showInputDialog("Insira a quantidade")));
        return item;
    }


    static ItemPedido buscarItem(Pedido pedido)
    {
        String nomeProduto = JOptionPane.showInputDialog("Insira o nome do produto");
        for(ItemPedido item : pedido.getItens())
        {
            if(item.getProduto().getNome().equalsIgnoreCase(nomeProduto))
            {
                return item;
            }
        }
        return null;
    }
}
