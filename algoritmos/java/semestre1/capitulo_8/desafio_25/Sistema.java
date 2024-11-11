//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.JOptionPane;

public class Sistema
{
    Notas registroDeNotas = new Notas();

    //
    public void cadastrarAluno()
    {
        registroDeNotas.cadastrarAluno();
    }

    //
    public void inserirNotasAluno(int indiceAluno)
    {
        registroDeNotas.adicionarNotasAluno(indiceAluno);
    }

    //
    public void exibirInfosDeTodosAlunos()
    {
        String msg = registroDeNotas.gerarRelatorioCompleto();

        JOptionPane.showMessageDialog(null, msg);
    }

    //
    public void listarAlunosDeRecuperacao()
    {
        String msg = registroDeNotas.gerarRelatorioAlunosRecuperacao();

        JOptionPane.showMessageDialog(null, msg);
    }

    //
    public int selecionarAluno()
    {
        double[] alunosENotas = registroDeNotas.getLista();

        String[] alunos = new String[registroDeNotas.contarAlunosCadastrados()];

        int aluno_i = 0;
        for(int indice = 0; indice <= 49; indice = indice + 5)
        {
            if(alunosENotas[indice] > 0)
            {
                alunos[aluno_i] = String.valueOf((alunosENotas[indice]));
                aluno_i += 1;                    
            }
        }

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um aluno", "Alunos", 0, 0, null, alunos, 0);

        final int AJUSTE_INDICE_CORRETO = 4;
        if(opcaoSelecionada > 0)
        {
            return (opcaoSelecionada + AJUSTE_INDICE_CORRETO);
        }
        else
        {
            return opcaoSelecionada;
        }
    }
}
