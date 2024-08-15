public class ItemVenda 
{
    private Produto produto;
    private double quantidade;

    ItemVenda(Produto produto, double quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() 
    {
        return produto;
    }

    public void setProduto(Produto produto) 
    {
        this.produto = produto;
    }

    public double calcularTotal()
    {
        return produto.getPreco() * quantidade;
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
