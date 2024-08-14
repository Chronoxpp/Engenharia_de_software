import java.util.ArrayList;
import java.util.List;

public class Biblioteca 
{
    String nome;
    List<ItemBiblioteca> itens = new ArrayList<>();

    Biblioteca(String nome)
    {
        this.nome = nome;
    }

    public void adicionarItem(ItemBiblioteca item)
    {
        if(item != null)
        {
            itens.add(item);
        }
    }

    public void removerItem(ItemBiblioteca item)
    {
        if(item != null)
        {
            itens.remove(item);
        }
    }

    public void mostrarItens()
    {
        for(ItemBiblioteca item : itens)
        {
            item.mostrarDetalhes();
            System.out.println();
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

    public List<ItemBiblioteca> getItens()
    {
        return itens;
    }
}
