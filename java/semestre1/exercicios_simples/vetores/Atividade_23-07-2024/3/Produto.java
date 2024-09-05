class Produto 
{
    private String nome;
    private double preco;

    Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    String getNome()
    {
        return nome;
    }

    void setNome(String nome)
    {
        this.nome = nome;
    }

    double getPreco()
    {
        return preco;
    }

    void setPreco(double preco)
    {
        this.preco = preco;
    }
}
