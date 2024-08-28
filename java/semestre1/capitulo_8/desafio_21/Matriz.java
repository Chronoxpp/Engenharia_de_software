import java.text.DecimalFormat;
import java.util.Random;

public class Matriz
{
    private int[][] matriz;

    //
    public Matriz(int qtdeLinhas, int qtdeColunas)
    {
        this.matriz = new int[qtdeLinhas][qtdeColunas];
    }

    //
    public int[][] popularMatriz()
    {
        Random geradorAleatorio = new Random();

        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz[0].length; j += 1)
            {
                matriz[i][j] = geradorAleatorio.nextInt(100);
            }
        }

        return matriz;
    }

    //
    public int somarElementosAcimaDiagonalPrincipal()
    {
        int somatoria = 0;

        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz[0].length; j += 1)
            {
                if(j > i)
                {
                    somatoria += matriz[i][j];
                }
            }
        }

        return somatoria;
    }

    //
    public String converterMatrizParaMsg()
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

    public int[][] getMatriz() 
    {
        return matriz;
    }

    public void setMatriz(int[][] matriz) 
    {
        this.matriz = matriz;
    }
}

