class ItemPedido
{
    Produto produto;
    double quantidade;

    ItemPedido(Produto produto, double quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    double calcularTotal()
    {
        return (produto.preco * quantidade);
    }

    public Produto getProduto() 
    {
        return produto;
    }

    public void setProduto(Produto produto) 
    {
        this.produto = produto;
    }

    public double getQuantidade() 
    {
        return quantidade;
    }

    public void setQuantidade(double quantidade) 
    {
        this.quantidade = quantidade;
    }
}