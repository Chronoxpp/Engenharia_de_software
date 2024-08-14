class Tarefa 
{
    private String descricao;
    private Funcionario funcionario;

    Tarefa(String descricao)
    {
        this.descricao = descricao;
    }

    Tarefa(String descricao, Funcionario funcionario)
    {
        this.descricao = descricao;
        this.funcionario = funcionario;
    }

    void atribuirFuncionario(Funcionario funcionario)
    {
        this.funcionario = funcionario;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) 
    {
        this.funcionario = funcionario;
    }
}
