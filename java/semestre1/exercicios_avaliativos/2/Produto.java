public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String produto, double preco, int estoque)
    {
        this.nome = produto;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void adicionarEstoque(int quantidade)
    {
        this.estoque += quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String produto) {
        this.nome = produto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
