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

    public Venda(){};

    public double calcularTotal()
    {
        if(itens.isEmpty())
            return 0;

        double total = 0;
        for(ItemVenda item : itens)
        {
            total += item.calcularTotal();
        }

        return total;
    }

    public void gerarParcelas(int qtdeParcelas)
    {
        if(qtdeParcelas == 0)
            return;

        double valorParcelas = calcularTotal() / (double)qtdeParcelas;

        for(int parcela_i = 1; parcela_i <= qtdeParcelas; parcela_i += 1)
        {
            Parcela parcela = new Parcela(parcela_i, valorParcelas);
            parcelas.add(parcela);
        }
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
