class Projeto 
{
    private String nome;
    private Tarefa[] tarefas;
    private int contador = 0;


    Projeto(String nome, int limiteDeTarefas)
    {
        this.nome = nome;
        tarefas = new Tarefa[limiteDeTarefas];
    }


    void adicionarTarefa(Tarefa tarefa)
    {
        if(contador < tarefas.length)
        {
            tarefas[contador++] = tarefa;
        }
    }

    void removerTarefa(Tarefa tarefa)
    {
        for(int i = 0; i < contador; i++)
        {
            if(tarefas[i].equals(tarefa))
            {
                tarefas[i] = tarefas[--contador];
                tarefas[contador] = null;
            }
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

    public Tarefa[] getTarefas() 
    {
        return tarefas;
    }

    public void setTarefas(Tarefa[] tarefas) 
    {
        this.tarefas = tarefas;
    }

    public int getContador() 
    {
        return contador;
    }

    public void setContador(int contador) 
    {
        this.contador = contador;
    }
}
