import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Main 
{
    static List<Funcionario> funcionarios = new ArrayList<>();
    static List<Projeto> projetos = new ArrayList<>();  

    public static void main(String[] args) 
    {
        Object[] botoes = {"Cadastrar projeto", "Cadastrar funcionario", "Gerenciar projeto", "Sair"};

        boolean sair = false;
        while (sair == false) 
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "O que você deseja fazer ?", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                cadastrarProjeto();
            }
            else if(opcaoSelecionada == 1)
            {
                cadastrarFuncionario();
            }
            else if(opcaoSelecionada == 2)
            {
                carregarProjeto(selecionarProjeto());
            }
            else
            {
                sair = encerrarExecucao();
            }
        }
    }

    static void cadastrarProjeto()
    {
        String nomeProjeto = JOptionPane.showInputDialog("Insira o nome do novo projeto");

        if(nomeProjeto != null  && !nomeProjeto.equalsIgnoreCase(""))
        {
            Projeto projeto = new Projeto(nomeProjeto);
            projetos.add(projeto);
        }
    }

    static void cadastrarFuncionario()
    {
        String nomeFuncionario = JOptionPane.showInputDialog("Insira o nome do novo funcionario");
        
        if(nomeFuncionario != null && !nomeFuncionario.equalsIgnoreCase(""))
        {
            Funcionario funcionario = new Funcionario(nomeFuncionario);
            funcionarios.add(funcionario);
        }
    }

    static Projeto selecionarProjeto()
    {
        if(projetos.size() == 0)
        {
            return null;
        }

        String[] projetosNome = new String[projetos.size()];

        for(int i = 0; i < projetosNome.length; i++)
        {
            projetosNome[i] = projetos.get(i).getNome();
        }

        int projetoSelecionado = JOptionPane.showOptionDialog(null, "Selecione um projeto", "projetos", 0, 0, null, projetosNome, 0);
        if (projetoSelecionado >= 0) 
        {
            Projeto projeto = projetos.get(projetoSelecionado);
            return projeto;
        }
        else
        {
            return null;
        }
    }

    static void carregarProjeto(Projeto projeto)
    {
        if (projeto == null)
        {
            return;
        }

        Object[] botoes = {"Cadastrar tarefa", "Concluir tarefa", "Vincular funcionario", "Gerar relatorio", "Voltar"};

        boolean sair = false;
        while (sair == false) 
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Escolha uma ação: ", "Home", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                cadastrarTarefa(projeto);
            }
            else if(opcaoSelecionada == 1)
            {
                concluirTarefa(selecionarTarefaNaoConcluida(projeto));
            }
            else if(opcaoSelecionada == 2)
            {
                vincularFuncionario(selecionarFuncionario(), projeto);
            }
            else if(opcaoSelecionada == 3)
            {
                Relatorio relatorio = new Relatorio();
                relatorio.gerarRelatorioCompleto(projeto);
            }
            else
            {
                sair = true;
            }
        }
    }

    static void cadastrarTarefa(Projeto projeto)
    {
        String nomeTarefa = JOptionPane.showInputDialog("Insira o nome da tarefa");
        if(nomeTarefa != null  && !nomeTarefa.equalsIgnoreCase(""))
        {
            Tarefa tarefa = new Tarefa(nomeTarefa);
            projeto.adicionarTarefa(tarefa);

            JOptionPane.showMessageDialog(null, "Tarefa cadastrada !!!");
        }
    }

    static Tarefa selecionarTarefaNaoConcluida(Projeto projeto)
    {
        if(projeto.contarQuantidadeTarefasNaoConcluidas() == 0)
        {
            return null;
        }

        String[] tarefasDescricao = new String[projeto.contarQuantidadeTarefasNaoConcluidas()];
        Tarefa[] tarefasNaoConcluidas = new Tarefa[projeto.contarQuantidadeTarefasNaoConcluidas()];

        int j = 0;
        for(int i = 0; i < projeto.getTarefas().size(); i++)
        {
            if(projeto.getTarefas().get(i).getConcluida() == false)
            {
                tarefasNaoConcluidas[j] = projeto.getTarefas().get(i);
                tarefasDescricao[j] = tarefasNaoConcluidas[j].getDescricao();
                j = j + 1;
            } 
        }

        int tarefaSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma tarefa", "Tarefas", 0, 0, null, tarefasDescricao, 0);
        if (tarefaSelecionada >= 0) 
        {
            return tarefasNaoConcluidas[tarefaSelecionada];
        }
        else
        {
            return null;
        }
    }

    static void concluirTarefa(Tarefa tarefa)
    {
        if(tarefa != null)
        {
            tarefa.setConcluida(true);
        }
    }

    static Funcionario selecionarFuncionario()
    {
        if(funcionarios.size() == 0)
        {
            return null;
        }
        
        String[] funcionariosNome = new String[funcionarios.size()];

        for(int i = 0; i < funcionariosNome.length; i++)
        {
            funcionariosNome[i] = funcionarios.get(i).getNome();
        }

        int funcionarioSelecionado = JOptionPane.showOptionDialog(null, "Selecione um funcionario", "Funcionario", 0, 0, null, funcionariosNome, 0);
        if (funcionarioSelecionado >= 0) 
        {
            Funcionario funcionario = funcionarios.get(funcionarioSelecionado);
            return funcionario;
        }
        else
        {
            return null;
        }
    }

    static void vincularFuncionario(Funcionario funcionario, Projeto projeto)
    {
        if(funcionario != null && projeto != null)
        {
            funcionario.vincularProjeto(projeto);
            JOptionPane.showMessageDialog(null, "Funcionario vinculado !!!");
        }
    }

    static boolean encerrarExecucao()
    {
        JOptionPane.showMessageDialog(null, "Encerrando...");
        return true;
    }
}
