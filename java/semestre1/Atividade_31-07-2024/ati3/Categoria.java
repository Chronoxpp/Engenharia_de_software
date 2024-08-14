import java.util.List;
import java.util.ArrayList;

public class Categoria 
{
    String nome;
    List<Produto> produtos = new ArrayList<>();

    Categoria(String nome)
    {
        this.nome = nome;
    }

    public void vincularProduto(Produto produto)
    {
        if(produto != null)
        {
            produtos.add(produto);
            produto.getCategorias().add(this);
        }
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public List<Produto> getProdutos() 
    {
        return produtos;
    }
}
