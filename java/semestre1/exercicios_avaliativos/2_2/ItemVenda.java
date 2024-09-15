public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void removerEstoque(int quantidadeRemovida)
    {
        produto.setEstoque((produto.getEstoque() - quantidadeRemovida));
    }

    public void verificarEstoque() throws IllegalArgumentException
    {
        if(this.quantidade > this.produto.getEstoque() || this.produto.getEstoque() <= 0)
            throw new IllegalArgumentException("Quantidade em falta no estoque !!");
    }

    public double calcularTotal()
    {
        return this.produto.getPreco() * (double)this.quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
