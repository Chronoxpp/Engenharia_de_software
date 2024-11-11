import java.util.List;
import java.util.ArrayList;


class Venda 
{
    List<Produto> produtos = new ArrayList<>();

    void adicionarProduto(Produto produto)
    {
        produtos.add(produto);
    }

    double calcularTotal()
    {
        double total = 0;
        for(Produto produto : produtos)
        {
            total = total + produto.getPreco();
        }
        return total;
    }

    public List<Produto> getProduto() 
    {
        return produtos;
    }

    public void setProduto(List<Produto> produtos) 
    {
        this.produtos = produtos;
    }
}
