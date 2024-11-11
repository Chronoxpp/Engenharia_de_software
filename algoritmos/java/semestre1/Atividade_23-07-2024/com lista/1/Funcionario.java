class Funcionario
{
    String nome;
    int id;
    Departamento departamento;

    Funcionario(String nome, int id)
    {
        this.nome = nome;
        this.id = id;
    }

    Funcionario(String nome, int id, Departamento departamento)
    {
        this.nome = nome;
        this.id = id;
        this.departamento = departamento;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public Departamento getDepartamento() 
    {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) 
    {
        this.departamento = departamento;
    }
}