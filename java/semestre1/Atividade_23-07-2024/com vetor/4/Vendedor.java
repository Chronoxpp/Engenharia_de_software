class Vendedor 
{
    private Venda[] vendas;
    private String nome;
    private int contador = 0;


    Vendedor(String nome, int capacidadeDeVendas)
    {
        this.nome = nome;
        vendas = new Venda[capacidadeDeVendas];
    }


    void registrarVenda(Venda venda)
    {
        if(contador < vendas.length)
        {
            vendas[contador++] = venda;
        }
    }


    double calcularTotal()
    {
        double total = 0;
        
        for(Venda venda : vendas)
        {
            if(venda != null)
            {
                total = total + venda.calcularTotal();
            }
        }

        return total;
    }


    public Venda[] getVendas() 
    {
        return vendas;
    }

    public void setVendas(Venda[] vendas) 
    {
        this.vendas = vendas;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
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
