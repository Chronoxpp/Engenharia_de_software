import java.util.List;
import java.util.ArrayList;

class Vendedor 
{
    String nome;
    List<Venda> vendas = new ArrayList<>();

    Vendedor(String nome)
    {
        this.nome = nome;
    }

    void registrarVenda(Venda venda)
    {
        vendas.add(venda);
    }

    double calcularTotal()
    {
        double total = 0;
        for(Venda venda : vendas)
        {
            total = total + venda.calcularTotal();
        }
        return total;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public List<Venda> getVendas() 
    {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) 
    {
        this.vendas = vendas;
    }
}
