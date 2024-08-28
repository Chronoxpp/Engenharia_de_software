public class Espectador
{
    private int idade;
    private int avaliacao;

    //
    Espectador(int idade, int avaliacao)
    {
        this.idade = idade;
        this.avaliacao = avaliacao;
    }

    
    public int getIdade() 
    {
        return idade;
    }

    public void setIdade(int idade) 
    {
        this.idade = idade;
    }

    public int getAvaliacao() 
    {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) 
    {
        this.avaliacao = avaliacao;
    }
}