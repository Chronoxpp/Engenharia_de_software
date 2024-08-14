import java.util.List;
import java.util.ArrayList;

public class Produto
{
    private String nome;
    private double preco;
    private  List<Categoria> categorias = new ArrayList<>();

    Produto(String nome)
    {
        this.nome = nome;
    }

    Produto(String nome, double preco)
    {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() 
    {
        return categorias;
    }
}