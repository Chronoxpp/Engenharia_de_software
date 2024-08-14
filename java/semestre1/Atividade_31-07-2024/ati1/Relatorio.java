import javax.swing.JOptionPane;

class Relatorio 
{
    public void gerarRelatorioCompleto(Projeto projeto)
    {
        StringBuilder msg = new StringBuilder();

        msg.append("Quantidade total de tarefas: ").append(projeto.contarQuantidadeTotalTarefas()).append("\n \n")

        .append("Tarefas concluidas: ").append(projeto.contarQuantidadeTarefasConcluidas()).append("\n")

        .append(projeto.listarTarefasConcluidas()).append("\n")

        .append("Tarefas não concluidas: ").append(projeto.contarQuantidadeTarefasNaoConcluidas()).append("\n")

        .append(projeto.listarTarefasNaoConcluidas()).append("\n")

        .append("Progresso atual: ").append(projeto.calcularProgressoTotal()).append("% \n");

        JOptionPane.showMessageDialog(null, msg);
    }
}
