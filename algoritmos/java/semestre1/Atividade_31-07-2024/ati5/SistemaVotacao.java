import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class SistemaVotacao 
{
    List<Candidato> candidatos = new ArrayList<>();
    List<Eleitor> eleitores = new ArrayList<>();

    public void cadastrarEleitor()
    {
        String nomeEleitor = JOptionPane.showInputDialog(null, "Insira o nome do eleitor");
        if(checarNome(nomeEleitor) == true)
        {
            Eleitor eleitor = new Eleitor(nomeEleitor);
            adicionarEleitor(eleitor);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nome invalido");
        }
    }


    private void adicionarEleitor(Eleitor eleitor)
    {
        eleitores.add(eleitor);
    }


    private boolean checarNome(String nome)
    {
        if(nome == null)
        {
            return false;
        }
        else if(nome.equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public void cadastrarCandidato()
    {
        String nomeCandidato = JOptionPane.showInputDialog("Insira o nome do candidato");
        if(checarNome(nomeCandidato) == true)
        {
            Candidato candidato = new Candidato(nomeCandidato);
            adicionarCandidato(candidato);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nome invalido");
        }
    }


    private void adicionarCandidato(Candidato candidato)
    {
        candidatos.add(candidato);
    }


    public void exibirResultadosVotacao()
    {
        List<Candidato> candidatosEmOrdem = consultarResultados();
        if(candidatosEmOrdem == null)
        {
            return;
        }

        String msg = "Resultado da votação: \n\n";

        for(Candidato candidato : candidatosEmOrdem)
        {
            msg = msg + "Candidato: " + candidato.getNome() + "\n";
            msg = msg + "Votos: " + candidato.getVotos() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, msg);
    }


    private List<Candidato> consultarResultados()
    {
        if(candidatos.isEmpty())
        {
            return null;
        }

        List<Candidato> resultadoVotacao = new ArrayList<>();
        List<Candidato> candidatosParticipantes = candidatos;

        for(int i = 0; i < candidatos.size(); i += 1)
        {
            Candidato candidatoMaior = candidatosParticipantes.get(0);
            for(Candidato candidato : candidatosParticipantes)
            {
                if(candidato.getVotos() > candidatoMaior.getVotos())
                {
                    candidatoMaior = candidato;
                }
            }
            for(Candidato candidato2 : candidatos)
            {
                System.out.println(candidato2.getNome());
            }
            resultadoVotacao.add(candidatoMaior);
            candidatosParticipantes.remove(candidatoMaior);

            System.out.println("");

            for(Candidato candidato2 : candidatos)
            {
                System.out.println(candidato2.getNome());
            } 
        }

        return resultadoVotacao;
    }


    private Candidato selecionarCandidato()
    {
        String[] opcoes = new String[candidatos.size()];

        int i = 0;
        for(Candidato candidato : candidatos)
        {
            opcoes[i] = candidato.getNome();
            i += 1;
        }

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um candidato", "Selecao", 0, 0, null, opcoes, 0);
        if(opcaoSelecionada < 0) 
        {
            return null;
        }
        else
        {
            return candidatos.get(opcaoSelecionada);
        }
    }


    private Eleitor selecionarEleitor()
    {
        String[] opcoes = new String[eleitores.size()];

        int i = 0;
        for(Eleitor eleitor : eleitores)
        {
            opcoes[i] = eleitor.getNome();
            i += 1;
        }

        int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione um eleitor", "Selecao", 0, 0, null, opcoes, 0);
        if(opcaoSelecionada < 0) 
        {
            return null;
        }
        else
        {
            return eleitores.get(opcaoSelecionada);
        }
    }


    public void realizarVotacao()
    {
        Eleitor eleitor = selecionarEleitor();
        if(eleitor == null)
        {
            return;
        }     

        Candidato candidato = selecionarCandidato();
        if (candidato == null) 
        {
            return;
        }

        eleitor.votar(candidato);
    }


    public List<Candidato> getCandidatos() 
    {
        return candidatos;
    }
    
    public List<Eleitor> getEleitores() 
    {
        return eleitores;
    }
}
