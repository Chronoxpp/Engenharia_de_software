import java.util.List;
import java.util.ArrayList;

public class Projeto 
{
    private String nome;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome)
    {
        this.nome = nome;
    }

    public void adicionarTarefa(Tarefa tarefa)
    {
        tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa)
    {
        tarefas.remove(tarefa);
    }

    public double calcularProgressoTotal()
    {
        if (tarefas.size() <= 0) 
        {
            return 0;
        }
        else
        {
            double totalTarefasConcluidas = contarQuantidadeTarefasConcluidas();
            double totalTarefas = tarefas.size();
            return ((totalTarefasConcluidas / totalTarefas) * 100);
        }
    }

    public int contarQuantidadeTarefasNaoConcluidas()
    {
        int quantidadeTarefas = 0;
        for(Tarefa tarefa : tarefas)
        {
            if(tarefa.getConcluida() == false)
            {
                quantidadeTarefas = quantidadeTarefas + 1;
            }
        }
        return quantidadeTarefas;
    }

    public StringBuilder listarTarefasNaoConcluidas()
    {
        StringBuilder tarefasNaoConcluidas = new StringBuilder();

        for(Tarefa tarefa : tarefas)
        {
            if(tarefa.getConcluida() == false)
            {
                tarefasNaoConcluidas.append(tarefa.getDescricao()).append("\n");
            }
        }
        return tarefasNaoConcluidas;
    }

    public int contarQuantidadeTarefasConcluidas()
    {
        int quantidadeTarefas = 0;
        for(Tarefa tarefa : tarefas)
        {
            if(tarefa.getConcluida())
            {
                quantidadeTarefas = quantidadeTarefas + 1;
            }
        }
        return quantidadeTarefas;
    }

    public StringBuilder listarTarefasConcluidas()
    {
        StringBuilder tarefasConcluídas = new StringBuilder();

        for(Tarefa tarefa : tarefas)
        {
            if(tarefa.getConcluida())
            {
                tarefasConcluídas.append(tarefa.getDescricao()).append("\n");
            }
        }
        return tarefasConcluídas;
    }

    public int contarQuantidadeTotalTarefas()
    {
        return tarefas.size();
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
