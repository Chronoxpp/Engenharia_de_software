import java.util.List;
import java.util.ArrayList;

public class Funcionario 
{
    private String nome;
    private List<Projeto> projetos = new ArrayList<>();

    public void vincularProjeto(Projeto projeto)
    {
        projetos.add(projeto);
    }

    public void desvincularProjeto(Projeto projeto)
    {
        projetos.remove(projeto);
    }

    public Funcionario(String nome)
    {
        this.nome = nome;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public List<Projeto> getProjetos() 
    {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) 
    {
        this.projetos = projetos;
    }
}
