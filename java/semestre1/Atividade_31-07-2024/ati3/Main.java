import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main 
{
    static List<Produto> produtos = new ArrayList<>();
    static List<Categoria> categorias = new ArrayList<>();

    public static void main(String[] args)
    {
        Object[] botoes = {"Cadastrar produto", "CadastrarCategoria", "Consultar categoria", "Exibir produtos", "Finalizar" };

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma ação", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                cadastrarProduto();
            }
            else if(opcaoSelecionada == 1)
            {
                cadastrarCategoria();
            }
            else if(opcaoSelecionada == 2)
            {
                consultarCategoria(selecionarCategoria());
            }
            else if(opcaoSelecionada == 3)
            {
                mostrarProdutos();
            }
            else
            {
                sair = encerrarExecucao();
            }
        }
    }

    public static void cadastrarProduto()
    {
        String nomeProduto = obterNome();

        double precoProduto = obterPreco();

        if(nomeProduto == null)
        {
            return;
        }

        if(precoProduto <= 0)
        {
            return;
        }

        Produto produto = new Produto(nomeProduto, precoProduto);
        produtos.add(produto);        
    }

    public static String obterNome()
    {
        String nome = JOptionPane.showInputDialog("Insira o nome");

        if(nome == null)
        {
            return null;
        }
        else if(nome.equals(""))
        {
            return null;
        }
        else
        {
            return nome;
        }
    }

    public static double obterPreco()
    {
        String precoString = JOptionPane.showInputDialog("Insira o preco");

        if(precoString == null)
        {
            return 0;
        }

        for(int i = 0; i < precoString.length(); i = i + 1)
        {
            if(!Character.isDigit(precoString.charAt(i)))
            {
                return 0;
            }
        }

        return Double.parseDouble(precoString);
    }

    public static void cadastrarCategoria()
    {
        String nomeCategoria = obterNome();

        if(nomeCategoria != null)
        {
            Categoria categoria = new Categoria(nomeCategoria);
            categorias.add(categoria);
        }
    }

    public static Categoria selecionarCategoria()
    {
        if(categorias.isEmpty())
        {
            return null;
        }

        String[] categoriasNomes = new String[categorias.size()];
        for(int i = 0; i < categorias.size(); i++)
        {
            categoriasNomes[i] = categorias.get(i).getNome();
        }

        int categoriaSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma categoria", "Categorias", 0, 0, null, categoriasNomes, 0);
        if(categoriaSelecionada >= 0)
        {
            return categorias.get(categoriaSelecionada);
        }
        else
        {
            return null;
        }
    }

    public static void consultarCategoria(Categoria categoria)
    {
        if(categoria == null)
        {
            return;
        }

        Object[] botoes = {"Vincular produto","sair" };

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma ação", "Consulta categoria", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                vincularProduto(selecionarProduto(), categoria);
            }
            else
            {
                sair = true;
            }
        }
    }

    public static void mostrarProdutos()
    {
        String msg = "Lista de produtos:" + "\n\n";

        for(Produto produto : produtos)
        {
            msg = msg + "Nome: " + produto.getNome() + "\n";
            msg = msg + "Preco: " + produto.getPreco() + "\n";
            msg = msg + "Categorias: ";
            if (!produto.getCategorias().isEmpty()) 
            {
                for(Categoria categoria : produto.getCategorias())
                {
                    msg = msg + categoria.getNome() + "\n";
                }                
            }

            msg = msg + "\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }

    public static boolean encerrarExecucao()
    {
        JOptionPane.showMessageDialog(null, "Encerrando...");
        return true;
    }


    public static Produto selecionarProduto()
    {
        if(produtos.isEmpty())
        {
            return null;
        }

        String[] produtosNomes = new String[produtos.size()];
        for(int i = 0; i < produtos.size(); i++)
        {
            produtosNomes[i] = produtos.get(i).getNome();
        }

        int produtoSelecionado = JOptionPane.showOptionDialog(null, "Selecione uma categoria", "Categorias", 0, 0, null, produtosNomes, 0);
        if(produtos.get(produtoSelecionado) != null)
        {
            return produtos.get(produtoSelecionado);
        }
        else
        {
            return null;
        }
    }

    public static void vincularProduto(Produto produto, Categoria categoria)
    {
        if(produto == null)
        {
            return;
        }

        if(categoria == null)
        {
            return;
        }

        categoria.vincularProduto(produto);
    }
}
