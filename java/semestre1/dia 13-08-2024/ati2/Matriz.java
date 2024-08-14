import javax.swing.JOptionPane;

public class Matriz
{
    
    public static void main(String[] args)
    {
        int[][] matriz;
        int qtdeLinha = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de linhas: "));
        int qtdeColuna = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de colunas: "));

        matriz = new int[qtdeLinha][qtdeColuna];

        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz.length; j += 1)
            {
                JOptionPane.showInputDialog(null, matriz[i][j], "Ler os valores da matriz", 0);
            }
        }

        int[][] matriz2 = new int[4][4];
        for(int i = 0; i < matriz.length; i+=1)
        {
            for(int j = 0; j < matriz.length; j += 1)
            {
                matriz2[i][j] = matriz2[i][j] + (matriz[i][j] * matriz[i][j]);  sxxex3wsw
            }
        }

    }

    public int[] obterDiagonalPrincipal(int matriz[][])
    {
        int[] vetor = new int[matriz.length];
        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz.length; j += 1)
            {
                JOptionPane.showInputDialog(null, matriz[i][j], "Ler os valores da matriz", 0);
            }
        }

        return vetor;
    }

    public int[][] obterDiagonalSecundaria()
    {
        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz.length; j += 1)
            {
                JOptionPane.showInputDialog(null, matriz[i][j], "Ler os valores da matriz", 0);
            }
        }
    }
}