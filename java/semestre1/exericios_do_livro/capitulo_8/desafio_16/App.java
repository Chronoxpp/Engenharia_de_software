//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.JOptionPane;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        Random randomizador = new Random();

        double[] vetorDouble = new double[20];

        //Populando o vetorDouble
        for(int i = 0; i < vetorDouble.length; i += 1)
        {
            double numeroReal = randomizador.nextDouble();
            vetorDouble[i] = numeroReal * 100; //usei 100 por aleatoriedade, poderia ser usado qualquer multiplo de 10
        }

        //Criando uma msg que exibe os valores do vetor double
        String msg = "";
        for(int i = 0; i < vetorDouble.length; i += 1)
        {
            msg += vetorDouble[i] + "\n";
        }

        //Adicionando a somatoria do vetorDouble na msg
        msg += "\n";
        Vetor vetorTeste = new Vetor();
        msg += "Somatoria do vetor: " + vetorTeste.somarValoresDoVetor(vetorDouble);

        //Exibe a msg
        JOptionPane.showMessageDialog(null, msg);
    }
}
