import java.util.Random;

public class Matriz
{
    int[][] dimensoes;


    public Matriz()
    {
        this.dimensoes = new int[2][2];
    }


    public Matriz(int linhas, int colunas)
    {
        this.dimensoes = new int[linhas][colunas];

        popularMatriz();
    }


    public void popularMatriz()
    {
        Random aleatorio = new Random();

        int[][] matriz = this.dimensoes;
        int qtdeDeLinhas = matriz.length;
        int qtdeDeColunas = matriz[0].length;

        for(int linhaAtual = 0; linhaAtual <= (qtdeDeLinhas - 1); linhaAtual = linhaAtual + 1)
        {
            for(int colunaAtual = 0; colunaAtual <= (qtdeDeColunas - 1); colunaAtual = colunaAtual + 1)
            {
                matriz[linhaAtual][colunaAtual] = aleatorio.nextInt(100); 
            }
        }

        this.dimensoes = matriz;
    }


    public void exibirMatriz()
    {
        int qtdeDeLinhas = this.dimensoes.length;
        int qtdeDeColunas = this.dimensoes[0].length;

        for(int linhaAtual = 0; linhaAtual <= (qtdeDeLinhas - 1); linhaAtual = linhaAtual + 1)
        {
            for(int colunaAtual = 0; colunaAtual <=  (qtdeDeColunas - 1); colunaAtual = colunaAtual + 1)
            {
                System.out.print(dimensoes[linhaAtual][colunaAtual] + " "); 
            }
            System.out.println("");
        }
    }

    
    public int somarDiagonalPrincipal()
    {
        int somatoria = 0;
        for(int i = 0; i <= this.dimensoes.length - 1; i = i + 1)
        {
            somatoria = somatoria + this.dimensoes[i][i];
        }

        return somatoria;
    }


    public int somarDiagonalSecundaria()
    {
        int somatoria = 0;
        int linha = 0;
        for(int i = (this.dimensoes[0].length - 1); i >=0 ; i = i - 1)
        {
            somatoria = somatoria + this.dimensoes[linha][i];
            linha = linha + 1;
        }

        return somatoria;
    }


    public void ordenarCrescente()
    {
        int[][] matriz = this.dimensoes;
        int qtdeDeItens = dimensoes.length * dimensoes[0].length;

        int[] vetor = new int[qtdeDeItens];

        //Criando e populando o vetor em linha
        int coluna_v = 0;
        for(int linha_m = 0; linha_m <= (matriz.length - 1); linha_m = linha_m + 1)
        {
            for(int coluna_m = 0; coluna_m <=  (matriz[0].length - 1); coluna_m = coluna_m + 1)
            {

                vetor[coluna_v] = matriz[linha_m][coluna_m];
                coluna_v = coluna_v + 1;
                
            }
        }

        // ordenando o vetor em linha
        for (int i = 0; i <= vetor.length - 2; i = i + 1){
            for (int j = 0; j < (vetor.length - 1) - i; j = j + 1) {
                // comparar os pares
                if (vetor[j] > vetor[j+1]){
                    int aux = vetor[j]; 
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = aux;
                }
            }
        }

        System.out.println("Vetor ordenado de forma crescente: ");
        for(int i = 0; i <= vetor.length - 1; i = i + 1)
        {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        System.out.println();

        //convertendo vetorEmLinha -> matriz

        coluna_v = 0;
        for(int i = 0; i <= this.dimensoes.length - 1; i = i + 1)
        {
            for(int j = 0; j <=  this.dimensoes[0].length - 1; j = j + 1)
            {
                this.dimensoes[i][j] = vetor[coluna_v];
                coluna_v = coluna_v + 1;
            }
        }
    }

    // public void ordenarDescrescente()
    // {
    //     for(int i = 0; i <= this.dimensao.length - 1; i = i + 1)
    //     {
    //         int k = 0;
    //         for(int j = 0; j <=  this.dimensao[0].length - 1; j = j + 1)
    //         {
    //             vetor[k] = this.dimensao[i][j];
    //         }
    //     }
    // }
}
