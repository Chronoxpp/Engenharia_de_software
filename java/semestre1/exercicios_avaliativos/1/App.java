import javax.swing.*;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        int[][] matrizOriginal = new int[4][4];

        popularMatriz(matrizOriginal);

        //Cria a matriz original e exibe na tela
        String msg;
        msg = "Matriz original: \n \n";
        msg += converterMatrizParaMsg(matrizOriginal);
        JOptionPane.showMessageDialog(null, msg);

        //Cria a matriz somatoria e exibe na tela
        int[][] matrizSomatoria = criarMatrizComSomatoriaLinhaEColuna(matrizOriginal);
        msg = "Matriz somatoria: \n\n";
        msg += converterMatrizParaMsg(matrizSomatoria);
        JOptionPane.showMessageDialog(null, msg);

        //Cria duas variaveis para armazenar as somatorias das diagonais da matriz
        int somatoriaDiagonalPrincipal = somarValoresDiagonalPrincipal(matrizOriginal);
        int somatoriaDiagonalSecundaria = somarValoresDiagonalSecundaria(matrizOriginal);

        //Exibe na tela as duas somatorias e a soma das somatorias
        msg = "Somatoria diagonal principal = " + somatoriaDiagonalPrincipal + "\n";
        msg += "Somatoria diagonal secundaria = " + somatoriaDiagonalSecundaria + "\n";
        msg += "Soma das somatorias = " + (somatoriaDiagonalPrincipal + somatoriaDiagonalSecundaria);
        JOptionPane.showMessageDialog(null, msg);

        //Cria a matriz ordenada com base na matriz original, e exibe as duas na tela
        int[][] matrizOrdenada = ordenarMatriz(matrizOriginal);
        msg = "Matriz original: \n \n";
        msg += converterMatrizParaMsg(matrizOriginal) + "\n\n";
        msg += "Matriz original ordenada: \n \n";
        msg += converterMatrizParaMsg(matrizOrdenada);
        JOptionPane.showMessageDialog(null, msg);
    }

    //
    private static void popularMatriz(int[][] matriz)
    {
        if(matriz == null)
            return;


        Random randomizador = new Random();
        for(int linha = 0; linha < matriz.length; linha += 1)
        {
            for(int coluna = 0; coluna < matriz[0].length; coluna += 1)
            {
                matriz[linha][coluna] = randomizador.nextInt(10, 100);
            }
        }
    }

    //
    private static String converterMatrizParaMsg(int[][] matriz)
    {
        if(matriz == null)
            return null;


        String msg = "";

        for(int linha = 0; linha < matriz.length; linha += 1)
        {
            for(int coluna = 0; coluna < matriz[0].length; coluna += 1)
            {
                msg += matriz[linha][coluna] + "   ";
            }
            msg += "\n";
        }

        return msg;
    }

    //
    public static int[][] criarMatrizComSomatoriaLinhaEColuna(int matrizOriginal[][])
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

    //
    public static int[][] ordenarMatriz(int[][] matrizOriginal)
    {
        //Converte a matriz em vetor, ordena o vetor com o algoritmo bubbleSort e por fim converte o vetor ordenado em uma nova matriz

        if(matrizOriginal == null)
            return null;

        int[] vetorOrdenado = converterMatrizParaVetor(matrizOriginal);

        for (int linha = 0; linha < (vetorOrdenado.length - 1); linha = linha + 1)
        {
            for (int coluna = 0; coluna < ((vetorOrdenado.length - 1) - linha); coluna = coluna + 1)
            {
                if (vetorOrdenado[coluna] > vetorOrdenado[coluna +1])
                {
                    int aux = vetorOrdenado[coluna];
                    vetorOrdenado[coluna] = vetorOrdenado[coluna +1];
                    vetorOrdenado[coluna +1] = aux;
                }
            }
        }

        int[][] matrizOrdenada = converterVetorParaMatriz(vetorOrdenado, matrizOriginal.length, matrizOriginal[0].length);
        return matrizOrdenada;
    }

    //
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

    //
    public static int[][] converterVetorParaMatriz(int[] vetor, int qtdeLinhas, int qtdeColunas)
    {
        if(vetor == null)
            return null;

        if(vetor.length != (qtdeLinhas * qtdeColunas))
            return null;


        int contador = 0;
        int[][] novaMatriz = new int[qtdeLinhas][qtdeColunas];

        for(int linha = 0; linha < novaMatriz.length; linha += 1)
        {
            for(int coluna = 0; coluna < novaMatriz[0].length; coluna += 1)
            {
                novaMatriz[linha][coluna] = vetor[contador];
                contador += 1;
            }
        }

        return novaMatriz;
    }
}
