import java.util.ArrayList;
import java.util.List;

class Empresa 
{
    String nome;
    List<Departamento> departamentos = new ArrayList<>();

    Empresa(String nome)
    {
        this.nome = nome;
    }

    void adicionarDepartamento(Departamento departamento)
    {
        departamentos.add(departamento);
    }

    void removerDepartamento(Departamento departamento)
    {
        departamentos.remove(departamento);
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public List<Departamento> getDepartamentos() 
    {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
