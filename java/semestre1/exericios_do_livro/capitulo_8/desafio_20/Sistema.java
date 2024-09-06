//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Sistema {

    public void exibirDetalhesHabitantes(List<Habitante> habitantes)
    {
        String msg = "";

        msg += "Quantidade de habitantes: " + habitantes.size() + "\n\n";

        msg += "Media salarial da populacao: " + formatarNumero(calcularMediaSalarial(habitantes)) + "\n";

        msg += "Media de filhos por habitante: " + formatarNumero(calcularMediaDeFilhos(habitantes)) + "\n";

        msg += "Maior salario da cidade: " + formatarNumero(determinarMaiorSalario(habitantes)) + "\n";

        msg += "Percentual de pessoas com salario menor que 380 reais: " + formatarNumero(determinarPercentualHabitantesComSalarioAbaixoDeXValor(380, habitantes));

        JOptionPane.showMessageDialog(null, msg);
    }

    //
    public double calcularMediaSalarial(List<Habitante> habitantes)
    {
        int qtdeDeHabitantes = 0;
        double somatoriaSalarios = 0;

        for(Habitante habitante : habitantes)
        {
            if(habitante != null)
            {
                qtdeDeHabitantes += 1;
                somatoriaSalarios += habitante.getSalario();
            }
        }

        double mediaSalarial = somatoriaSalarios / (double)qtdeDeHabitantes;
        return mediaSalarial;
    }

    //
    public double calcularMediaDeFilhos(List<Habitante> habitantes)
    {
        int qtdeDeHabitantes = 0;
        int qtdeDeFilhos = 0;

        for(Habitante habitante : habitantes)
        {
            if(habitante != null)
            {
                qtdeDeHabitantes += 1;
                qtdeDeFilhos += habitante.getQtdeFilhos();
            }
        }

        double mediaDeFilhos = (double) qtdeDeFilhos / (double) qtdeDeHabitantes;
        return mediaDeFilhos;
    }

    //
    public double determinarMaiorSalario(List<Habitante> habitantes)
    {
        double maiorSalario = 0;

        for(Habitante habitante : habitantes)
        {
            if(habitante != null)
            {
                if (habitante.getSalario() > maiorSalario)
                {
                    maiorSalario = habitante.getSalario();
                }
            }
        }

        return maiorSalario;
    }

    //
    public double determinarPercentualHabitantesComSalarioAbaixoDeXValor(double salarioPesquisado, List<Habitante> habitantes)
    {
        int qtdeHabitantes = 0;
        int qtdeHabitantesComSalarioAbaixoDoPesquisado = 0;

        for(Habitante habitante : habitantes)
        {
            if(habitante != null)
            {
                qtdeHabitantes += 1;

                if(habitante.getSalario() < salarioPesquisado)
                {
                    qtdeHabitantesComSalarioAbaixoDoPesquisado += 1;
                }
            }
        }

        if(qtdeHabitantesComSalarioAbaixoDoPesquisado <= 0)
        {
            return 0;
        }
        else
        {
            double percentualHabitantes = (double) qtdeHabitantesComSalarioAbaixoDoPesquisado / (double) qtdeHabitantes;
            return percentualHabitantes;
        }
    }

    //
    public void preencherListaHabitantesAleatoriamente(List<Habitante> habitantes)
    {
        if(habitantes.isEmpty() == false)
        {
            return;
        }

        Random randomizador = new Random();

        int qtdeHabitantes = randomizador.nextInt(1000);
        for(int i = 0; i < qtdeHabitantes; i += 1)
        {
            double salario = randomizador.nextDouble();
            salario = salario * gerarDecimalAleatorio();
            int qtdeFilhos = randomizador.nextInt(10);

            Habitante habitante = new Habitante(salario, qtdeFilhos);

            System.out.println(habitante.getSalario());
            if(habitante.getSalario() < 380)
            {
                System.out.println("Eu aqui");
            }
            System.out.println(habitante.getQtdeFilhos());

            habitantes.add(habitante);
        }
    }

    //
    public double gerarDecimalAleatorio()
    {
        Random randomizador = new Random();

        int numeroAleatorio = randomizador.nextInt(101);

        if(numeroAleatorio == 0)
        {
            return 10;
        }
        else if(numeroAleatorio < 25)
        {
            return 100;
        }
        else if(numeroAleatorio < 50)
        {
            return 1000;
        }
        else
        {
            return 10000;
        }
    }

    //
    public String formatarNumero(double numero)
    {
        DecimalFormat formatador = new DecimalFormat("#0.000");

        String numeroFomatado = formatador.format(numero);

        return numeroFomatado;
    }
}
