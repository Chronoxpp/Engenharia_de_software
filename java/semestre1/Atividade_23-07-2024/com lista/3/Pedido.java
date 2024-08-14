import java.util.List;
import java.util.ArrayList;

class Pedido 
{
    Cliente cliente;
    List<ItemPedido> itens = new ArrayList<>();

    Pedido(Cliente cliente)
    {
        this.cliente = cliente;
    }

    void adicionarItem(ItemPedido item)
    {
        itens.add(item);
    }

    void removerItem(ItemPedido item)
    {
        itens.remove(item);
    }

    double calcularTotal()
    {
        double total = 0;
        for(ItemPedido item : itens)
        {
            total = total + item.calcularTotal();
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

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) 
    {
        this.itens = itens;
    }
}
