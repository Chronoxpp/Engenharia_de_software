class Pedido 
{
    private Cliente cliente;
    private ItemPedido[] itens;
    private int contador = 0;

    
    Pedido(Cliente cliente, int limiteDeItens)
    {
        this.cliente  = cliente;
        itens = new ItemPedido[limiteDeItens];
    }


    void adicionarItem(ItemPedido item)
    {
        if(contador < itens.length)
        {
            itens[contador++] = item;
        }
        else
        {
            System.out.println("O cliente atingiu o limite de itens disponivel !!!");
        }
    }

    void removerItem(ItemPedido item)
    {
        for(int i = 0; i < contador; i++)
        {
            if(itens[i].equals(item))
            {
                itens[i] = itens[--contador];
                itens[contador] = null;
            }
        }
    }

    double calcularTotal()
    {
        double total = 0;
        for(ItemPedido item : itens)
        {
            if(item != null)
            {
                total = total + item.calcularTotal();
            }
        }

        return total;
    }


    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public ItemPedido[] getItens() 
    {
        return itens;
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
