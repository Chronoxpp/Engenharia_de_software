//Desenvolvido por Lucas Dourado Rodrigues

import javax.swing.JOptionPane;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        int[] vetor1 = new int[10];
        preencherVetorInteiro(vetor1);

        int[] vetor2 = new int[10];
        preencherVetorInteiro(vetor2);

        int[] vetorInterseccao;
        vetorInterseccao = sistema.determinarInterseccaoEntreConjuntos(vetor1, vetor2);

        //Exibe os vetores
        String msg = "";
        msg = "Vetor 1: " + sistema.converterVetorInteiroEmMsg(vetor1);
        msg += "\n";
        msg += "Vetor 2:" + sistema.converterVetorInteiroEmMsg(vetor2);
        msg += "\n\n";

        msg += "vetor interseccao: " + sistema.converterVetorInteiroEmMsg(vetorInterseccao);

        JOptionPane.showMessageDialog(null, msg);
    }

    public static void preencherVetorInteiro(int[] vetor)
    {
        if(vetor == null)
        {
            return;
        }

        Random randomizador = new Random();

        for(int i = 0; i < vetor.length; i += 1)
        {
            vetor[i] = randomizador.nextInt(11);
        }
    }
}
