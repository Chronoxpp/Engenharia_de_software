class Membro 
{
    private String nome;
    private Livro[] livrosEmprestados;
    private int contador = 0;

    Membro(String nome,int limiteEmprestimos)
    {
        this.nome = nome;
        this.livrosEmprestados = new Livro[limiteEmprestimos];
    }


    void emprestarLivro(Livro livro)
    {
        if(livro.getEstaEmprestado() == true)
        {
            System.out.println("Livro indisponivel !!!");
        }
        else
        {
            if(contador < livrosEmprestados.length)
            {
                livrosEmprestados[contador++] = livro;
                livro.setEstaEmprestado(true);
            }
            else
            {
                System.out.println("Limite de emprestimos atingido !!!");
            }
        }

    }

    void devolverLivro(Livro livro)
    {
        for(int i = 0; i < contador; i++)
        {
            if (livrosEmprestados[i].equals(livro)) {
                livrosEmprestados[i] = livrosEmprestados[--contador];
                livrosEmprestados[contador] = null;
                livro.setEstaEmprestado(false);
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

    public Livro[] getLivrosEmprestados() 
    {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(Livro[] livrosEmprestados) 
    {
        this.livrosEmprestados = livrosEmprestados;
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
