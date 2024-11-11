import javax.swing.JOptionPane;

public class Matriz
{
    public static void main(String[] args)
    {
        int[][] matriz = new int[4][4];

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz.length; j++)
            {
                matriz[i][j] = i + j;
            }
        }

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz.length; j++)
            {
                
            }
        }
    }

    public void somarElementosECriarNovaMatriz(int matriz[][])
    {
        int[][] matriz2 = new int[4][4];

        int soma = 0;
        for(int i = 0; i < matriz.length; i += 1)
        {
            for(int j = 0; j < matriz.length; j += 1)
            {
                for(int k = 0; k < matriz.length; k += 1)
                {
                    soma *= matriz[j][k];
                }

                for(int l = 0; l < matriz.length; l += 1)
                {
                    soma *= matriz[l][i];
                }

                matriz2[i][j] = soma;
            }
        }

        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz.length; j++)
            {
                JOptionPane.showInputDialog(null, matriz[i][j]);
            }
        }
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