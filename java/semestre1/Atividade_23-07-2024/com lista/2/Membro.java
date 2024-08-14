import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class Membro 
{
    String nome;
    List<Livro> livrosEmprestados =  new ArrayList<>();

    Membro(String nome)
    {
        this.nome = nome;
    }

    void emprestarLivro(Livro livro)
    {
        if(livro.getEmprestado() != true)
        {
            livrosEmprestados.add(livro);
            livro.setEmprestado(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "O livro " + livro.getNome() + " esta em uso");
        }
    }

    void devolverLivro(Livro livro)
    {
        livrosEmprestados.remove(livro);
        livro.setEmprestado(false);
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
        return livrosEmprestados;
    }

    public void setLivros(List<Livro> livros) 
    {
        this.livrosEmprestados = livros;
    }
}
