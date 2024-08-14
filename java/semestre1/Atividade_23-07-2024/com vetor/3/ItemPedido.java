class ItemPedido 
{
    private Produto produto;
    private double quantidade;

    ItemPedido(Produto produto, double quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }


    double calcularTotal()
    {
        return (produto.getPreco() * quantidade);
    }


    Produto getProduto()
    {
        return produto;
    }

    void setProduto(Produto produto)
    {
        this.produto = produto;
    }

    double getQuantidade()
    {
        return quantidade;
    }

    void setQuantidade(double quantidade)
    {
        this.quantidade = quantidade;
    }
}
