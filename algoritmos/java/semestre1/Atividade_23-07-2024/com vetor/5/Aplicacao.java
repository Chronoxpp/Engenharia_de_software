class Aplicacao
{
    public static void main(String args[])
    {
        Funcionario lucas = new Funcionario("Lucas");

        Tarefa codificar1 = new Tarefa("Codificar o tal tal");
        Tarefa codificar2 = new Tarefa("Codificar aquela outra coisa");

        Projeto software = new Projeto("software", 999);

        software.adicionarTarefa(codificar1);
        codificar1.setFuncionario(lucas);

        software.adicionarTarefa(codificar2);

        for(int i = 0; i < software.getContador(); i++)
        {
            System.out.println(software.getTarefas()[i].getDescricao());
            if(software.getTarefas()[i].getFuncionario() != null)
            {
                System.out.println(software.getTarefas()[i].getFuncionario().getNome());
            }
            System.out.println();
        }
    }
}