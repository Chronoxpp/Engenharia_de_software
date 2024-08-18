import java.util.List;
import java.util.ArrayList;

public class Pagamento
{
    Venda venda;
    List<Parcela> parcelas = new ArrayList<>();

    Pagamento(Venda venda)
    {
        this.venda = venda;
    }

    Pagamento(Venda venda, int quantidadeParcelas)
    {
        this.venda = venda;
        realizarParcelamento(quantidadeParcelas);
    }

    public void realizarParcelamento(int quantidadeParcelas)
    {
        double valorParcela = (venda.calcularTotal() / quantidadeParcelas);

        for(int i = 1; i <= quantidadeParcelas; i += 1)
        {
            Parcela parcela = new Parcela(i, valorParcela);

            parcelas.add(parcela);
        }
    }

    public Venda getVenda() 
    {
        return venda;
    }

    public void setVenda(Venda venda) 
    {
        this.venda = venda;
    }

    public List<Parcela> getParcelas() 
    {
        return parcelas;
    }

    public void setParcelas(List<Parcela> parcelas) 
    {
        this.parcelas = parcelas;
    }
}
