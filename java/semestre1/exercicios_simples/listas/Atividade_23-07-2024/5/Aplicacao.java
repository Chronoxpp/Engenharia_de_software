import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Aplicacao {
    static Projeto projeto;
    static List<Funcionario> funcionarios =  new ArrayList<>();

    public static void main(String[] args)
    {
        JOptionPane.showMessageDialog(null, "Gerenciando projetos e tarefas");

        projeto = new Projeto(JOptionPane.showInputDialog("Insira o nome do projeto:"));

        
        Funcionario funcionario1 = new Funcionario(JOptionPane.showInputDialog("Insira o nome do funcionario 1:"));
        funcionarios.add(funcionario1);

        Funcionario funcionario2 = new Funcionario(JOptionPane.showInputDialog("Insira o nome do funcionario 2:"));
        funcionarios.add(funcionario2);


        Object[] botoes = {"Criar tarefa", "Excluir tarefa","Consultar tarefas", "Finalizar"};
        ImageIcon icone = new ImageIcon("checklist.png");
        
        int opcaoSelecionada = 0;
        while (opcaoSelecionada != 3) 
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "O que vc deseja fazer ?", "opcoes", 0, 0, icone , botoes, 0);

            if(opcaoSelecionada == 0)
            {
                criarNovaTarefa();
            }
            else if(opcaoSelecionada == 1)
            {
                deletarTarefa();
            }
            else if(opcaoSelecionada == 2)
            {
                consultarTodasTarefas();
            }
            else if(opcaoSelecionada == 3)
            {
                encerrarPrograma();
            }
        }
    }

    static void criarNovaTarefa()
    {
        String descricaoTarefa = JOptionPane.showInputDialog("Insira a descricao");;
        if(descricaoTarefa != null)
        {
            Tarefa tarefa = new Tarefa(descricaoTarefa);
            atribuirFuncionario(tarefa);
            projeto.adicionarTarefa(tarefa);
        }
    }

    static void consultarTodasTarefas()
    {
        String msg = "Tarefa   |   Funcionario \n \n";
        for(Tarefa tarefa : projeto.tarefas)
        {
            msg = msg + tarefa.getDescricao() + "   |   ";
            if (tarefa.getFuncionario() != null) 
            {
                msg = msg + tarefa.getFuncionario().getNome();
            }
            msg = msg + "\n";
        }
        Object[] botoes = {"Editar tarefa"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(null, msg, "Lista de tarefas", 0, 0, null, botoes, msg);


        if(opcaoSelecionada == 0)
        {
            if(!projeto.getTarefas().isEmpty())
            {
                atribuirFuncionario(buscarTarefa());
            }            
        }
    }

    static void atribuirFuncionario(Tarefa tarefa)
    {
        if(tarefa != null)
        {
            Funcionario funcionario = buscarFuncionario();
            if(funcionario != null)
            {
                tarefa.setFuncionario(funcionario);
            }
        }
    }


    static Funcionario buscarFuncionario()
    {
        ImageIcon icone = new ImageIcon("checklist.png");
        Object[] vetorFuncionarios = new Object[funcionarios.size()];
        for(int i = 0; i < vetorFuncionarios.length; i++)
        {
            vetorFuncionarios[i] = funcionarios.get(i).getNome();
        }

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um vendedor", "opcoes", 0, 0, icone , vetorFuncionarios, 0);
        if(opcaoSelecionada >= 0)
        {
            return funcionarios.get(opcaoSelecionada);
        }
        return null;
    }

    static void deletarTarefa()
    {
        Tarefa tarefa = buscarTarefa();
        if(tarefa != null)
        {
            projeto.getTarefas().remove(tarefa);
        }
    }

    static Tarefa buscarTarefa()
    {
        ImageIcon icone = new ImageIcon("checklist.png");
        Object[] vetorTarefas = new Object[projeto.tarefas.size()];

        for(int i = 0; i < vetorTarefas.length; i++)
        {
            vetorTarefas[i] = projeto.getTarefas().get(i).getDescricao();
        }
        int tarefaSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma tarefa", "Tarefas", 0, 0, icone, vetorTarefas, 0);

        Tarefa tarefa;
        if (tarefaSelecionada >= 0) 
        {
             tarefa = projeto.getTarefas().get(tarefaSelecionada);
        }
        else
        {
            tarefa = null;
        }
        
        return tarefa;
    }

    static void encerrarPrograma()
    {
        JOptionPane.showMessageDialog(null, "Encerrando...");
    }
}
