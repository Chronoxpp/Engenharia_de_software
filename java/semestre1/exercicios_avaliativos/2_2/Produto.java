public class Produto {
    private String produto;
    private double preco;
    private int estoque;

    public Produto(String produto, double preco, int estoque)
    {
        this.produto = produto;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void removerEstoque(int quantidadeRemovida)
    {
        estoque = (estoque - quantidadeRemovida);
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
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
