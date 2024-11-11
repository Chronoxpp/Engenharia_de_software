import java.util.List;
import java.util.ArrayList;

abstract class Curso
{
    private String nome;
    private List<Estudante> estudantes = new ArrayList<>();

    Curso(String nome){}

    public abstract void matricularEstudante(Estudante estudante);

    public abstract void mostrarDetalhes();

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setEstudantes(List<Estudante> estudantes)
    {
        this.estudantes = estudantes;
    }

    public List<Estudante> getEstudantes()
    {
        return estudantes;
    }
}