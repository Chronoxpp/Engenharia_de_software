//Desenvolvido por: Lucas Dourado Rodrigues

import java.util.Random;
import java.text.DecimalFormat;

public class Sistema
{
    double[][] matriz;

    public void receberMatriz(double[][] matriz)
    {
        this.matriz = matriz;
    }

    public double somarElementosMatriz(int linhaInicial)
    {
        double somataria = 0;

        for(int i = (linhaInicial - 1); i < this.matriz.length; i += 1)
        {    
            for(int j = 0; j < this.matriz[0].length; j += 1)
            {
                somataria += matriz[i][j];
            }
        }

        return somataria;
    }

    public String converterMatrizParaMsg(double[][] matriz)
    {
        DecimalFormat formatador = new DecimalFormat("00.00");

        String msg;
        msg = "Matriz[" + matriz.length + "][" + matriz[0].length + "]\n\n";

        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz[0].length; j += 1)
            {
                String numeroFomatado = formatador.format(matriz[i][j]);
                numeroFomatado = numeroFomatado.replace(".", ",");
                msg = msg + numeroFomatado + "  ";
            }
            msg = msg + "\n";
        }

        return msg;
    }

    public double[][] gerarMatriz(int quantidadeLinhas, int quantidadeColunas)
    {
        Random geradorAleatorio = new Random();

        double[][] matriz = new double[quantidadeLinhas][quantidadeColunas];

        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz[0].length; j += 1)
            {
                matriz[i][j] = geradorAleatorio.nextDouble(100);
            }
        }

        return matriz;
    }
}