public abstract class Pessoa
{
    private String nome;
    
    Pessoa(String nome)
    {
        this.nome = nome;
    }

    public abstract void mostrarDetalhes();

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
}