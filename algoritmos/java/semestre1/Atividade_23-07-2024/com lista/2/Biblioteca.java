import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class Biblioteca 
{
    String nome;
    List<Livro> livros = new ArrayList<>();

    Biblioteca(String nome)
    {
        this.nome = nome;
    }

    void adicionarLivro(Livro livro)
    {
        livros.add(livro);
    }

    void removerLivro(Livro livro)
    {
        if(livro.getEmprestado() != true)
        {
            livros.remove(livro);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "O livro " + livro.getNome() + " esta em uso");
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

    public List<Livro> getLivros() 
    {
        return livros;
    }

    public void setLivros(List<Livro> livros) 
    {
        this.livros = livros;
    }
}
