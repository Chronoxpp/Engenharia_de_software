//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.JOptionPane;

public class Notas
{
    private double[] lista = new double[50];

    //
    public void cadastrarAluno()
    {
        int indice = encontrarEspacoDisponivel();
        if(indice < 0)
        {
            JOptionPane.showMessageDialog(null, "Espaco indisponivel");
            return;
        }

        int codigoAluno = Integer.parseInt(JOptionPane.showInputDialog("Insira o codigo do aluno"));
        if(codigoAluno < 0)
        {
            JOptionPane.showMessageDialog(null, "Codigo invalido");
            return;
        }

        lista[indice] = codigoAluno;
    }

    //
    public void adicionarNotasAluno(int indiceAluno)
    {
        if(indiceAluno < 0)
        {
            return;
        }

        InserirNota1(indiceAluno);
        InserirNota2(indiceAluno);
        InserirNota3(indiceAluno);
        InserirNota4(indiceAluno);
    }

    //
    private void InserirNota1(int indiceAluno)
    {
        boolean concluido = false;
        while(concluido == false) 
        {
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Insira a nota 1"));

            if(checarNota(nota))
            {
                setNota1(indiceAluno, nota);
                concluido = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nota invalida");
            }
        }   
    }

    //
    private void InserirNota2(int indiceAluno)
    {
        boolean concluido = false;
        while(concluido == false) 
        {
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Insira a nota 2"));

            if(checarNota(nota))
            {
                setNota2(indiceAluno, nota);
                concluido = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nota invalida");
            }
        }   
    }

    //
    private void InserirNota3(int indiceAluno)
    {
        boolean concluido = false;
        while(concluido == false) 
        {
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Insira a nota 3"));

            if(checarNota(nota))
            {
                setNota3(indiceAluno, nota);
                concluido = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nota invalida");
            }
        }   
    }

    //
    private void InserirNota4(int indiceAluno)
    {
        boolean concluido = false;
        while(concluido == false) 
        {
            double nota = Double.parseDouble(JOptionPane.showInputDialog("Insira a nota 4"));

            if(checarNota(nota))
            {
                setNota4(indiceAluno, nota);
                concluido = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Nota invalida");
            }
        }   
    }

    //
    private boolean checarNota(double nota)
    {
        if(nota >= 0 && nota <= 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //
    public double calcularMediaAritmetica(int indiceDoAluno)
    {
        double media = 0;
        media = media + lista[indiceDoAluno + 1];
        media = media + lista[indiceDoAluno + 2];
        media = media + lista[indiceDoAluno + 3];
        media = media + lista[indiceDoAluno + 4];

        media = media / 4;

        return media;
    }

    //
    public String gerarRelatorioCompleto()
    {
        String msg = "Lista dos alunos e suas medias \n\n";

        for(int indice = 0; indice <= 49; indice = indice + 5)
        {
            if(lista[indice] > 0)
            {
                double media = calcularMediaAritmetica(indice);
                msg = msg + "Aluno: " + lista[indice] + " Media: " + media + "\n\n";
            }
        }

        return msg;
    }

    //
    public String gerarRelatorioAlunosRecuperacao()
    {
        String msg = "Lista dos alunos em recuperação \n\n";

        for(int indice = 0; indice <= 49; indice = indice + 5)
        {
            if(lista[indice] != 0)
            {
                double media = calcularMediaAritmetica(indice);
                if (media < 6) 
                {
                    msg = msg + "Aluno: " + lista[indice] + " Media: " + media + "\n\n";
                }
            }
        }

        return msg;
    }

    //
    private int encontrarEspacoDisponivel()
    {
        for(int indice = 0; indice <= 49; indice = indice + 5)
        {
            if(lista[indice] == 0)
            {
                return indice;
            }
        }
        return -1;
    }

    //
    public int encontrarIndiceDoAluno(int codigoDoAluno)
    {
        for(int indice = 0; indice <= 49; indice = indice + 5)
        {
            if(lista[indice] == codigoDoAluno)
            {
                return indice;
            }
        }
        return -1;
    }

    //
    public int contarAlunosCadastrados()
    {
        int contador = 0;
        for(int indice = 0; indice <= 49; indice = indice + 5)
        {
            if(lista[indice] > 0)
            {
                contador += 1;
            }
        }

        return contador;
    }


    public double[] getLista()
    {
        return lista;
    }

    public void setNota1(int indiceAluno, double n1)
    {
        lista[indiceAluno + 1] = n1; 
    }

    public void setNota2(int indiceAluno, double n2)
    {
        lista[indiceAluno + 2] = n2;
    }

    public void setNota3(int indiceAluno, double n3)
    {
        lista[indiceAluno + 3] = n3;
    }

    public void setNota4(int indiceAluno, double n4)
    {
        lista[indiceAluno + 4] = n4;
    }
}