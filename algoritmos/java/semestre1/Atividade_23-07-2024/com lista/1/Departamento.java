import java.util.ArrayList;
import java.util.List;

class Departamento 
{
    String nome;
    List<Funcionario> funcionarios = new ArrayList<>();

    Departamento(String nome)
    {
        this.nome = nome;
    }


    void adicionarFuncionario(Funcionario funcionario)
    {
        funcionarios.add(funcionario);
    }

    void removerFuncionario(Funcionario funcionario)
    {
        funcionarios.remove(funcionario);
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public List<Funcionario> getfuncionarios() 
    {
        return funcionarios;
    }

    public void setfuncionarios(List<Funcionario> funcionarios) 
    {
        this.funcionarios = funcionarios;
    }
}
