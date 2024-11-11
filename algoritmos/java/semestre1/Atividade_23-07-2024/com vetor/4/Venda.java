class Venda 
{
    private Produto[] produtos;
    private int contador = 0;


    Venda(int limiteProdutos)
    {
        produtos = new Produto[limiteProdutos];
    }


    void adicionarProduto(Produto produto)
    {
        if(contador < produtos.length)
        {
            produtos[contador++] = produto;
        }
    }


    double calcularTotal()
    {
        double total = 0;

        for(Produto produto : produtos)
        {
            if(produto != null)
            {
                total = total + produto.getPreco();
            }
        }

        return total;
    }


    public Produto[] getProdutos() 
    {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) 
    {
        this.produtos = produtos;
    }

    public int getContador() 
    {
        return contador;
    }

    public void setContador(int contador) 
    {
        this.contador = contador;
    }
}
