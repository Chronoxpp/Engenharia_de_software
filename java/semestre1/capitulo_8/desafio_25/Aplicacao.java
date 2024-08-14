//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.JOptionPane;

public class Aplicacao 
{
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        String[] botoes = {"Cadastrar aluno", "Inserir notas", "Exibir alunos","Exibir alunos recuperacao","Finalizar"};

        boolean sair = false;
        while(sair == false)
        {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma ação", "Home", 0, 0, null, botoes, 0);

            if (opcaoSelecionada == 0) 
            {
                sistema.cadastrarAluno();
            }
            else if(opcaoSelecionada == 1)
            {
                sistema.inserirNotasAluno(sistema.selecionarAluno());
            }
            else if(opcaoSelecionada == 2)
            {
                sistema.exibirInfosDeTodosAlunos();
            }
            else if(opcaoSelecionada == 3)
            {
                sistema.listarAlunosDeRecuperacao();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Encerrando...");
                sair = true;
            }
        }
    }
}
