class Biblioteca 
{
    private String nome;
    private Livro[] livros;
    private int contador = 0;

    Biblioteca(String nome,int limiteDeLivros)
    {
        this.nome = nome;
        livros = new Livro[limiteDeLivros];
    }


    void adicionarLivro(Livro livro)
    {
        if(contador < livros.length)
        {
            livros[contador++] = livro;
        }
        else
        {
            System.out.println("Limite de livros atingido !!!");
        }
    }

    void deletarLivro(Livro livro)
    {
        for(int i = 0; i < contador; i++)
        {
            if (livros[i].equals(livro)) 
            {
                if(livro.getEstaEmprestado() == false)
                {
                    livros[i] = livros[--contador];
                    livros[contador] = null;
                    livro = null;
                }
                else
                {
                    System.out.println("O livro esta em uso !!!");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado !!!");
    }
    

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public Livro[] getLivros() 
    {
        return livros;
    }

    public void setLivros(Livro[] livros) 
    {
        this.livros = livros;
    }

    public int getContador() 
    {
        return contador;
    }

    public void setContador(int contador) 
    {
        this.contador = contador;
    }
}
