//Desenvolvido por: Lucas Dourado Rodrigues

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String[] args)
    {
        Sistema sistema = new Sistema();

        double[][] minhaMatriz = new double[10][5];

        //Populando a matriz
        minhaMatriz = sistema.gerarMatriz(minhaMatriz.length, minhaMatriz[0].length);
        sistema.receberMatriz(minhaMatriz);

        //convertendo matriz double -> variavel String e exibindo ela
        String msg = sistema.converterMatrizParaMsg(minhaMatriz);
        JOptionPane.showMessageDialog(null, msg);

        //Somando todos os elementos a partir da linha 7 da matriz
        double somatoria = sistema.somarElementosMatriz(7);

        //Formatando a somatoria para exibição simplificada
        DecimalFormat formatador = new DecimalFormat("#.0000");
        msg = formatador.format(somatoria);
        msg = msg.replace(".", ",");
        JOptionPane.showMessageDialog(null, "Somataria: " + msg);
    }
}
