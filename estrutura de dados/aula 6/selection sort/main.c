#include <stdio.h>
#include <stdlib.h>


void selectionSort(int vetor[], int tamanhoVetor)
{
    int indiceComMenorValor, aux;
    int iteracoes = 0;
    int trocas = 0;
    int comparacoes = 0;

    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        iteracoes += 1;
        //comparacoes += 1;

        indiceComMenorValor = i;
        for(int j = i + 1; j < tamanhoVetor; j += 1)
        {
            //iteracoes += 1;
            comparacoes += 1;

            if(vetor[j] < vetor[indiceComMenorValor])
            {
                indiceComMenorValor = j;
                //trocas += 1;
            }
            //comparacoes += 1;
        }

        if(vetor[indiceComMenorValor] < vetor[i])
        {
            aux = vetor[i];
            vetor[i] = vetor[indiceComMenorValor];
            vetor[indiceComMenorValor] = aux;
            trocas += 1;
        }
        //comparacoes += 1;
    }
    printf("trocas: %d\ncomparacoes: %d\niteracoes: %d\n\n", trocas, comparacoes, iteracoes);
}


int main()
{
    int vetor[] = {25,48,37,12,57,86,33,92};
    int tamanhoVetor = sizeof(vetor)/sizeof(vetor[0]);
    selectionSort(vetor, tamanhoVetor);
    for(int i = 0; i < 8; i += 1)
        printf("N: %d, ", vetor[i]);
    return 0;
}
