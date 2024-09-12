import javax.swing.*;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        int[][] matrizOriginal = new int[4][4];

        popularMatrizInteira(matrizOriginal);

        String msg;
        msg = "Matriz original: \n \n";
        msg += converterMatrizInteiraParaMsg(matrizOriginal);
        JOptionPane.showMessageDialog(null, msg);

        int[][] matrizSomatoria = criarMatrizInteiraComSomatoriaLinhaEColuna(matrizOriginal);
        msg = "Matriz somatoria: \n\n";
        msg += converterMatrizInteiraParaMsg(matrizSomatoria);
        JOptionPane.showMessageDialog(null, msg);
    }

    //
    private static void popularMatrizInteira(int[][] matrizInteira)
    {
        Random randomizador = new Random();
        for(int linha = 0; linha < matrizInteira.length; linha += 1)
        {
            for(int coluna = 0; coluna < matrizInteira[1].length; coluna += 1)
            {
                matrizInteira[linha][coluna] = randomizador.nextInt(10, 100);
            }
        }
    }

    //
    private static String converterMatrizInteiraParaMsg(int[][] matrizInteira)
    {
        String msg = "";

        for(int linha = 0; linha < matrizInteira.length; linha += 1)
        {
            for(int coluna = 0; coluna < matrizInteira[1].length; coluna += 1)
            {
                msg += matrizInteira[linha][coluna] + "   ";
            }
            msg += "\n";
        }

        return msg;
    }

    //
    public static int[][] criarMatrizInteiraComSomatoriaLinhaEColuna(int matrizOriginal[][])
    {
        if(matrizOriginal == null)
        {
            return null;
        }

        if(matrizOriginal.length != matrizOriginal[0].length)
        {
            return null;
        }

        int[][] novaMatriz = new int[matrizOriginal.length][matrizOriginal[1].length];


        for(int linha = 0; linha < matrizOriginal.length; linha += 1)
        {
            for(int coluna = 0; coluna < matrizOriginal[1].length; coluna += 1)
            {
                int somatoria = 0;

                for(int linhaAuxiliar = 0; linhaAuxiliar < matrizOriginal.length; linhaAuxiliar += 1)
                {
                    somatoria += matrizOriginal[linhaAuxiliar][coluna];
                }

                for(int colunaAuxiliar = 0; colunaAuxiliar < matrizOriginal[1].length; colunaAuxiliar += 1)
                {
                    if(colunaAuxiliar != coluna) //Isso evita que o elemento [linha][coluna] seja somado novamente na somatoria
                        somatoria += matrizOriginal[linha][colunaAuxiliar];
                }

                novaMatriz[linha][coluna] = somatoria;
            }
        }

        return novaMatriz;
    }

    public void exibirVetor(int[][] matriz)
    {
        String msg = "Matri \n";
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz.length; j++)
            {
                msg = msg + matriz[i][j]  + " ";
            }
            msg = msg + "\n";
        }

        JOptionPane.showMessageDialog(null, msg,"Ola", 0);
    }
}
