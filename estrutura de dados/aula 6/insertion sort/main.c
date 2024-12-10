#include <stdio.h>
#include <stdlib.h>


void insertionSortN(int *vetor, int tamanhoVetor)
{
    for(int i = 1; i < tamanhoVetor; i += 1)
    {
        int aux = vetor[i];
        for(int j = i; j >= 0; j --)
        {
            if(aux < vetor[j - 1]) {vetor[j] = vetor[j-1];}
            else{vetor[j] = aux; break;}
        }
    }
}


void insertionSort(int *vetor, int tamanhoVetor)
{
    for(int i = 1; i < tamanhoVetor; i += 1)
    {
        int aux = vetor[i];
        int j;
        for(j = i; (j >= 0) && (aux < vetor[j-1]); j --)
        {
            vetor[j] = vetor[j - 1];
        }
        vetor[j] = aux;
    }
}


int main()
{
    int vetor[] = {25,48,37,12,57,86};
    insertionSortN(vetor, 6);
    for(int i = 0; i < 6; i += 1)
    {
        printf("N: %d, ", vetor[i]);
    }

    system("pause");
    return 0;
}
