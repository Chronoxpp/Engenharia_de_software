import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens = new ArrayList<>();
    private List<Parcela> parcelas = new ArrayList<>();

    public Venda(List<ItemVenda> itens, List<Parcela> parcelas)
    {
        this.itens = itens;
        this.parcelas = parcelas;
    }

    public Venda(List<ItemVenda> itens)
    {
        this.itens = itens;
    }

    public double calcularTotal()
    {
        if(itens.isEmpty() == false)
            return 0;

        double total = 0;
        for(ItemVenda item : itens)
        {
            total += item.calcularTotal();
        }

        return total;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) {
        this.parcelas = parcelas;
    }
}
