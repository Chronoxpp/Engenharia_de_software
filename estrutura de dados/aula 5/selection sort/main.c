#include <stdio.h>
#include <stdlib.h>

int main()
{
    int vetor[5];
    int tamanhoVetor = 5;
    
    //Selection sort
        for(int i = 0; i < tamanhoVetor; i += 1)
        {
            int indiceComMenorValor = i;
            for(int j = (i+1); j < tamanhoVetor; j += 1 )
            {
                if(vetor[j] < vetor[indiceComMenorValor])
                {
                    indiceComMenorValor = j;
                }
            }

            int aux = vetor[i];
            vetor[i] = vetor[indiceComMenorValor];
            vetor[indiceComMenorValor] = aux;
        }
    return 0;
}