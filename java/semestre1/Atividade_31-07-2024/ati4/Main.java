import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main 
{
    static List<CursoGraduacao> cursosGraduacao = new ArrayList<>();
    static List<CursoPosGraduacao> cursosPosGraduacao = new ArrayList<>();  

    public static void main(String[] args)
    {
        Object[] botoes = {"Cadastrar", "Consultar", "Finalizar"};
        int opcaoSelecionada = 0;
        while(opcaoSelecionada != 2)
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione: ", "Gerenciador de cursos", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                carregarTelaCadastrarCurso();
            }   
            else if (opcaoSelecionada == 1)
            {
                carregarTelaConsultarCursos();
            }
            else
            {
                encerrarExecucao();
            }
        }
    }


    static void carregarTelaCadastrarCurso()
    {
        Object[] botoes = {"Graduacao", "Pós graduacao", "Voltar"};

        int opcaoSelecionada = 0;
        while(opcaoSelecionada != 2)
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Que tipo de curso você deseja cadastrar ?", "Cadastrar curso", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                CursoGraduacao curso = criarCursoGraduacao();
                if(curso != null)
                {
                    cursosGraduacao.add(curso);
                }
            }   
            else if (opcaoSelecionada == 1)
            {
                CursoPosGraduacao curso = criarCursoPosGraduacao();
                if(curso != null)
                {
                    cursosPosGraduacao.add(curso);
                }
            }
        }
    }


    static CursoGraduacao criarCursoGraduacao()
    {
        String nomeCurso = JOptionPane.showInputDialog("Insira o nome do curso");
        if(!nomeCurso.equalsIgnoreCase(""))
        {
            CursoGraduacao curso = new CursoGraduacao(nomeCurso);
            return curso;
        }
        else
        {
            return null;
        }
    }


    static CursoPosGraduacao criarCursoPosGraduacao()
    {
        String nomeCurso = JOptionPane.showInputDialog("Insira o nome do curso");
        if(!nomeCurso.equalsIgnoreCase(""))
        {
            CursoPosGraduacao curso = new CursoPosGraduacao(nomeCurso);
            return curso;
        }
        else
        {
            return null;
        }

    }


    static void carregarTelaConsultarCursos()
    {
        Object[] botoes = {"Curso de graduacao", "Curso de pós graduacao", "Voltar"};

        int opcaoSelecionada = 0;
        while(opcaoSelecionada != 2)
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Que tipo de curso você deseja consultar ?", "Consultar cursos", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                CursoGraduacao curso = selecionarCursoGraduacao();
                if(curso != null)
                {
                    consultarCursoGraducao(curso);
                }
            }   
            else if (opcaoSelecionada == 1)
            {
                CursoPosGraduacao curso = selecionarCursoPosGraduacao();
                if(curso != null)
                {
                    consultarCursoPosGraducao(curso);
                }
            }
        }
    }


    static CursoGraduacao selecionarCursoGraduacao()
    {
        String[] vetorCursos = new String[cursosGraduacao.size()];
        for(int i = 0; i < vetorCursos.length; i++)
        {
            vetorCursos[i] = cursosGraduacao.get(i).getNome();
        }

        Object[] botoes = vetorCursos;

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um curso", "Selecao de cursos", 0, 0, null, botoes, 0);
        if(opcaoSelecionada >= 0)
        {
            return cursosGraduacao.get(opcaoSelecionada);
        }
        else
        {
            return null;
        }
    }


    static void consultarCursoGraducao(CursoGraduacao curso)
    {
        Object[] botoes = {"Inserir aluno", "Exibir detalhes", "Voltar"};

        int opcaoSelecionada = 0;
        while(opcaoSelecionada != 2)
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opcao", "Consulta do curso", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                Estudante estudante = cadastrarAluno();
                if(estudante != null)
                {
                    curso.getEstudantes().add(estudante);
                }
            }
            else if (opcaoSelecionada == 1)
            {
                curso.mostrarDetalhes();
            }
        }
    }


    static Estudante cadastrarAluno()
    {
        String nome = JOptionPane.showInputDialog("Insira o nome do estudante");
        if(!nome.equalsIgnoreCase(""))
        {
            Estudante aluno = new Estudante(nome);
            return aluno;
        }
        else
        {
            return null;
        }
    }


    static CursoPosGraduacao selecionarCursoPosGraduacao()
    {
        String[] vetorCursos = new String[cursosPosGraduacao.size()];
        for(int i = 0; i < vetorCursos.length; i++)
        {
            vetorCursos[i] = cursosPosGraduacao.get(i).getNome();
        }
        
        Object[] botoes = vetorCursos;

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um curso", "Selecao de cursos", 0, 0, null, botoes, 0);
        if(opcaoSelecionada >= 0)
        {
            return cursosPosGraduacao.get(opcaoSelecionada);
        }
        else
        {
            return null;
        }
    }


    static void consultarCursoPosGraducao(CursoPosGraduacao curso)
    {
        Object[] botoes = {"Inserir aluno", "Exibir detalhes", "Voltar"};

        int opcaoSelecionada = 0;
        while(opcaoSelecionada != 2)
        {
            opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opcao", "Consulta do curso", 0, 0, null, botoes, 0);

            if(opcaoSelecionada == 0)
            {
                Estudante estudante = cadastrarAluno();
                if(estudante != null)
                {
                    curso.getEstudantes().add(estudante);
                }
            }   
            else if (opcaoSelecionada == 1)
            {
                curso.mostrarDetalhes();
            }
        }
    }

    
    static void encerrarExecucao()
    {
        JOptionPane.showMessageDialog(null, "Encerrando...");
    }
}
