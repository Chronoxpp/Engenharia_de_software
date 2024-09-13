import javax.swing.*;
import java.lang.annotation.Retention;
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

        int somatoriaDiagonalPrincipal = somarValoresDiagonalPrincipal(matrizOriginal);
        int somatoriaDiagonalSecundaria = somarValoresDiagonalSecundaria(matrizOriginal);

        msg = "Somatoria diagonal principal = " + somatoriaDiagonalPrincipal + "\n";
        msg += "Somatoria diagonal secundaria = " + somatoriaDiagonalSecundaria + "\n";
        msg += "Soma das somatorias = " + (somatoriaDiagonalPrincipal + somatoriaDiagonalSecundaria);
        JOptionPane.showMessageDialog(null, msg);
    }

    //
    private static void popularMatrizInteira(int[][] matrizInteira)
    {
        Random randomizador = new Random();
        for(int linha = 0; linha < matrizInteira.length; linha += 1)
        {
            for(int coluna = 0; coluna < matrizInteira[0].length; coluna += 1)
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
            for(int coluna = 0; coluna < matrizInteira[0].length; coluna += 1)
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
        if(validarMatrizQuadrada(matrizOriginal) == false)
            return null;


        int[][] novaMatriz = new int[matrizOriginal.length][matrizOriginal[0].length];

        for(int linha = 0; linha < matrizOriginal.length; linha += 1)
        {
            for(int coluna = 0; coluna < matrizOriginal[0].length; coluna += 1)
            {
                int somatoria = 0;

                for(int linhaAuxiliar = 0; linhaAuxiliar < matrizOriginal.length; linhaAuxiliar += 1)
                {
                    somatoria += matrizOriginal[linhaAuxiliar][coluna];
                }

                for(int colunaAuxiliar = 0; colunaAuxiliar < matrizOriginal[0].length; colunaAuxiliar += 1)
                {
                    if(colunaAuxiliar != coluna) //Isso evita que o elemento [linha][coluna] seja somado novamente na somatoria
                        somatoria += matrizOriginal[linha][colunaAuxiliar];
                }

                novaMatriz[linha][coluna] = somatoria;
            }
        }

        return novaMatriz;
    }

    //
    public static boolean validarMatrizQuadrada(int[][] matriz)
    {
        if(matriz == null)
        {
            return false;
        }

        if(matriz.length != matriz[0].length)
        {
            return false;
        }

        if(matriz.length < 2 || matriz[0].length < 2)
        {
            return false;
        }

        return true;
    }

    //
    public static Integer somarValoresDiagonalPrincipal(int[][] matrizInteira)
    {
        if(validarMatrizQuadrada(matrizInteira) == false)
        {
            return null;
        }

        int somatoria = 0;
        for(int linha = 0; linha < matrizInteira.length; linha += 1)
        {
            int coluna = linha;
            somatoria += matrizInteira[linha][coluna];
        }

        return somatoria;
    }

    //
    public static Integer somarValoresDiagonalSecundaria(int[][] matrizInteira)
    {
        if(validarMatrizQuadrada(matrizInteira) == false)
        {
            return null;
        }

        int somatoria = 0;
        for(int linha = 0; linha < matrizInteira.length; linha += 1)
        {
            int coluna = (matrizInteira[0].length - 1) - linha; //Escreva e execute esse loop em um papel caso pareca confuso pra voce
            somatoria += matrizInteira[linha][coluna];
        }

        return somatoria;
    }


    public static int[][] ordenarMatriz(int[][] matrizOriginal)
    {
        if(matrizOriginal == null)
            return null;

        int[] vetorOrdenado = new int[(matrizOriginal.length * matrizOriginal[0].length)];


        int[][] matrizOrdenada = new int[matrizOriginal.length][matrizOriginal[0].length];
    }

    public static int[] converterMatrizParaVetor(int[][] matriz)
    {
        if(matriz == null)
            return null;

        int[] vetor = new int[(matriz.length * matriz[0].length)];
        int contador = 0;

        for(int linha = 0; linha < matriz.length; linha += 1)
        {
            for(int coluna = 0; coluna < matriz[0].length; coluna += 1)
            {
                vetor[contador] = matriz[linha][coluna];
                contador += 1;
            }
        }

        return vetor;
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
