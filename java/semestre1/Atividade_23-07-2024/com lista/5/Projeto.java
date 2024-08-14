import java.util.ArrayList;
import java.util.List;

class Projeto 
{
    private String nome;
    List<Tarefa> tarefas = new ArrayList<>();

    Projeto(String nome)
    {
        this.nome = nome;
    }
    
    void adicionarTarefa(Tarefa tarefa)
    {
        tarefas.add(tarefa);
    }

    void removerTarefa(Tarefa tarefa)
    {
        tarefas.remove(tarefa);
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public List<Tarefa> getTarefas() 
    {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) 
    {
        this.tarefas = tarefas;
    }
}
