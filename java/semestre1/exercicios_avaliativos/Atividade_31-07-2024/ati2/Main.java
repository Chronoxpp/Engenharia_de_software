import javax.swing.JOptionPane;

public class Main 
{
    static Biblioteca biblioteca;
    public static void main(String[] args)
    {
        String nomeBiblioteca = obterNomeBiblioteca();
        while (nomeBiblioteca == null || nomeBiblioteca.equals(""))
        {
            nomeBiblioteca = obterNomeBiblioteca();
        }

        biblioteca = new Biblioteca(nomeBiblioteca);
        
        Object[] botoes = {"Cadastrar livro", "Cadastrar revista", "Mostrar itens","Emprestar", "Sair"};

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma ação", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                cadastrarLivro();
            }
            else if(opcaoSelecionada == 1)
            {
                cadastrarRevista();
            }
            else if(opcaoSelecionada == 2)
            {
                mostrarItens();
            }
            else if(opcaoSelecionada == 3)
            {
                emprestarItem(selecionarItem());
            }
            else
            {
                sair = encerrarExecucao();
            }
        }

    }


    public static String obterNomeBiblioteca()
    {
        String nomeBiblioteca = JOptionPane.showInputDialog("Insira o nome da biblioteca");
        if(nomeBiblioteca != null && !nomeBiblioteca.equalsIgnoreCase(""))
        {
            return nomeBiblioteca;
        }
        else
        {
            return null;
        }
    }


    public static void cadastrarLivro()
    {
        String nomeLivro = obterTitulo();
        if (nomeLivro == null) 
        {
            return;
        }

        String nomeAutor = obterAutor();
        if(nomeAutor == null)
        {
            return;
        }

        if (nomeLivro != null && nomeAutor != null)
        {
            Livro livro = new Livro(nomeLivro, nomeAutor);
            adicionarItem(livro);
        }
    }


    public static String obterTitulo()
    {
        String titulo = JOptionPane.showInputDialog("Insira o titulo");

        if(titulo != null && !titulo.equalsIgnoreCase(""))
        {
            return titulo;
        }
        else
        {
            return null;
        }
    }


    public static String obterAutor()
    {
        String nomeAutor = JOptionPane.showInputDialog("Insira o autor");

        if(nomeAutor != null && !nomeAutor.equalsIgnoreCase(""))
        {
            return nomeAutor;
        }
        else
        {
            return null;
        }
    }


    public static void adicionarItem(ItemBiblioteca item)
    {
        biblioteca.adicionarItem(item);
    }


    public static void cadastrarRevista()
    {
        String nomeRevista = obterTitulo();
        if(nomeRevista == null)
        {
            return;
        }

        String edicao = obterEdicao();
        if(edicao == null)
        {
            return;
        }

        if (nomeRevista != null && edicao != null)
        {
            Revista revista = new Revista(nomeRevista, edicao);
            adicionarItem(revista);
        }
    }


    public static String obterEdicao()
    {
        String edicao = JOptionPane.showInputDialog("Insira a edicao");

        if(edicao != null && !edicao.equalsIgnoreCase(""))
        {
            return edicao;
        }
        else
        {
            return null;
        }
    }


    public static void mostrarItens()
    {
        String msg = "";
        for(ItemBiblioteca item : biblioteca.getItens())
        {
            msg = msg + item.mostrarDetalhes();
            msg = msg + "\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }


    public static ItemBiblioteca selecionarItem()
    {
        int qtdeItensDisponivei = 0;
        for(ItemBiblioteca item : biblioteca.getItens())
        {
            if(item.getEmprestado() == false)
            {
                qtdeItensDisponivei = qtdeItensDisponivei + 1;
            }
        }

        String[] nomeItensDisponiveis = new String[qtdeItensDisponivei];
        ItemBiblioteca[] itensDisponiveis = new ItemBiblioteca[qtdeItensDisponivei];

        int i = 0;
        for(ItemBiblioteca item : biblioteca.getItens())
        {
            if(item.getEmprestado() == false)
            {
                nomeItensDisponiveis[i] = item.getTitulo();
                itensDisponiveis[i] = item;
                i = i + 1;
            }
        }

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Seecione um item", "Itens disponiveis", 0, 0, null, nomeItensDisponiveis, 0);
        if(opcaoSelecionada >= 0)
        {
            return itensDisponiveis[opcaoSelecionada];
        }
        else
        {
            return null;
        }
        
    }


    public static void emprestarItem(ItemBiblioteca item)
    {
        if(item != null)
        {
            item.emprestar();
        } 
    }


    public static boolean encerrarExecucao()
    {
        JOptionPane.showMessageDialog(null, "Encerrando...");
        return true;
    }
}
