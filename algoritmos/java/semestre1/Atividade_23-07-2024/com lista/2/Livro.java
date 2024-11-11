class Livro
{
    String nome;
    boolean emprestado;

    Livro(String nome)
    {
        this.nome = nome;
        emprestado = false;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public boolean getEmprestado() 
    {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) 
    {
        this.emprestado = emprestado;
    }
}