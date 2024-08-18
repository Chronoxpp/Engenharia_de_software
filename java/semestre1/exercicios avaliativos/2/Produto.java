public class Produto
{
    private String nome;
    private double preco;
    private double estoque;

    Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    Produto(String nome, double preco, double estoque)
    {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public double getPreco() 
    {
        return preco;
    }

    public void setPreco(double preco) 
    {

        this.preco = preco;
    }

    public double getEstoque()
     {
        return estoque;
    }

    public void setEstoque(double estoque) 
    {
        this.estoque = estoque;
    }
}