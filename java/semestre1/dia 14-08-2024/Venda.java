import java.util.ArrayList;
import java.util.List;

public class Venda
{
    Cliente cliente;
    List<ItemVenda> itens = new ArrayList<>();

    Venda()
    {
        
    }

    Venda(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemVenda item)
    {
        itens.add(item);
    }

    public void removerItem(ItemVenda item)
    {
        itens.remove(item);
    }

    public double calcularTotal()
    {
        double valorTotal = 0;
        for(ItemVenda item : itens)
        {
            valorTotal += item.calcularTotal();
        }

        return valorTotal;
    }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() 
    {
        return itens;
    }

    public void setItens(List<ItemVenda> itens)
    {
        this.itens = itens;
    }
}
