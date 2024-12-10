#include <stdio.h>
#include <stdlib.h>
#include <time.h> //clock(), CLOCKS_PER_SEC e clock_t


double gerarNumeroReal(long int *seed, double low, double high)
{
    double numeroReal;
    long int m,a,b,c, k;
    double value_0_1;
    m = 2147483647;
    a = 16807;
    b = 127773;
    c = 2836;
    k = *seed/b;
    *seed = a * (*seed % b) - k*c;
    if (*seed <0)
    *seed = *seed + m;
    value_0_1 = (double) *seed/m;
    numeroReal = low+value_0_1*(high - low);
    return (numeroReal);
}


int gerarNumeroInteiro(long int *seed, int low, int high)
{
    int numeroInteiro;
    long int m,a,b,c, k;
    double value_0_1;
    m = 2147483647;
    a = 16807;
    b = 127773;
    c = 2836;
    k = *seed/b;
    *seed = a * (*seed % b) - k * c;
    if (*seed <0)
    *seed = *seed + m;
    value_0_1 = (double) *seed/m;
    numeroInteiro = low+value_0_1*(high-low+1);
    return (numeroInteiro);
}


void popularVetorReal(double vetor[], int tamanhoVetor)
{
    long int seed = 1234554321;
    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        vetor[i] = gerarNumeroReal(&seed, 0, 100000);
    }
}


void popularVetorInteiro(int vetor[], int tamanhoVetor)
{
    long int seed = 1234554321;
    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        vetor[i] = gerarNumeroInteiro(&seed, 0, 100000);
    }
}


int intBuscarPosicaoDoValorViaAlgoritmoLinear(int vetor[], int tamanhoVetor, int valorProcurado)
{
    int index = 0;
    int posicaoValorProcurado = -1;

    while(index < tamanhoVetor && posicaoValorProcurado == -1)
    {
        if (vetor[index] == valorProcurado)
        {
            posicaoValorProcurado = index;
        }
        index += 1;
    }

    return posicaoValorProcurado;
}


void realBuscarPosicaoDoValorViaAlgoritmoLinear(double vetor[], int tamanhoVetor, double valorProcurado)
{
    int index; index = 0;
    int posicaoValorProcurado; posicaoValorProcurado = -1;

    while(index < tamanhoVetor && posicaoValorProcurado == -1)
    {
        if (vetor[index] == valorProcurado)
        {
            posicaoValorProcurado = index;
        }
        index += 1;
    }
}


int intBuscarPosicaoDoValorViaAlgoritmoLinearComSentinela(int vetor[], int tamanhoVetor, int valorProcurado)
{
    int index = 0;
    int posicaoValorProcurado = -1;

    while(index < tamanhoVetor && posicaoValorProcurado == -1)
    {
        if (vetor[index] == valorProcurado)
        {
            posicaoValorProcurado = index;
        }
        index += 1;
    }

    return posicaoValorProcurado;
}


void realBuscarPosicaoDoValorViaAlgoritmoLinearComSentinela(double vetor[], int tamanhoVetor, double valorProcurado)
{
    int index; index = 0;
    int posicaoValorProcurado; posicaoValorProcurado = -1;

    while(index < tamanhoVetor && posicaoValorProcurado == -1)
    {
        if (vetor[index] == valorProcurado)
        {
            posicaoValorProcurado = index;
        }
        index += 1;
    }
}


int main() {
    double pop1, pop2, pop3, pop4, pop5, pop6, pop7, pop8;
    clock_t inicio, fim;

    int iRetorno;

    // inteiro cem
    int intVetorCem[100]; popularVetorInteiro(intVetorCem, 100);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(intVetorCem, 100, 87); fim = clock();
    pop1 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000; // Conversão para milissegundos
    printf("v1[%d]: 87, tempo gasto: %lf ms\n",iRetorno, pop1);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(intVetorCem, 100, 100001); fim = clock();
    pop1 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000; // Conversão para milissegundos
    printf("v1[%d]: 100001, tempo gasto: %lf ms\n",iRetorno, pop1);


    // inteiro mil
    int intVetorMil[1000]; popularVetorInteiro(intVetorMil, 1000);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(intVetorMil, 1000, 87);  fim = clock();
    pop2 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v2[%d]: 87, tempo gasto: %lf ms\n",iRetorno, pop2);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(intVetorMil, 1000, 100001);  fim = clock();
    pop2 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v2[%d]: 100001, tempo gasto: %lf ms\n",iRetorno, pop2);


    // inteiro dez mil
    int intVetorDezMil[10000]; popularVetorInteiro(intVetorDezMil, 10000);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(intVetorDezMil, 10000, 87); fim = clock();
    pop3 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v3[%d]: 87, tempo gasto: %lf ms\n",iRetorno, pop3);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(intVetorDezMil, 10000, 100001); fim = clock();
    pop3 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v3[%d]: 100001, tempo gasto: %lf ms\n",iRetorno, pop3);

    
    // inteiro cem mil
    int IntVetorCemMil[100000]; popularVetorInteiro(IntVetorCemMil, 100000);
    
    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(IntVetorCemMil, 100000, 87);  fim = clock();
    pop4 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v4[%d]: 87, tempo gasto: %lf ms\n",iRetorno, pop4);

    inicio = clock(); iRetorno = intBuscarPosicaoDoValorViaAlgoritmoLinear(IntVetorCemMil, 100000, 100001);  fim = clock();
    pop4 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v4[%d]: 100001, tempo gasto: %lf ms\n",iRetorno, pop4);


    printf("\n");


    // real cem
    double realVetorCem[100]; popularVetorReal(realVetorCem, 100);

    inicio = clock(); realBuscarPosicaoDoValorViaAlgoritmoLinear(realVetorCem, 100, 87);  fim = clock();
    pop5 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v5, valor procurado: 87, tempo gasto: %lf ms\n", pop5);


    // real mil
    double realVetorMil[1000]; popularVetorReal(realVetorMil, 1000);
    inicio = clock(); realBuscarPosicaoDoValorViaAlgoritmoLinear(realVetorMil, 1000, 87);  fim = clock();
    pop6 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v6, valor procurado: 87, tempo gasto: %lf ms\n", pop6);
    
    
    // real dez mil
    double realVetorDezMil[10000]; popularVetorReal(realVetorDezMil, 10000);
    
    inicio = clock(); realBuscarPosicaoDoValorViaAlgoritmoLinear(realVetorDezMil, 10000, 87);  fim = clock();
    pop7 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v7, valor procurado: 87, tempo gasto: %lf ms\n", pop7);

    
    // real cem mil
    double realVetorCemMil[100000]; popularVetorReal(realVetorCemMil, 100000);

    inicio = clock(); realBuscarPosicaoDoValorViaAlgoritmoLinear(realVetorCemMil, 100000, 87);  fim = clock();
    pop8 = ((double)(fim - inicio)) / CLOCKS_PER_SEC * 1000;
    printf("v8, valor procurado: 87, tempo gasto: %lf ms\n", pop8);


    system("pause");

    return 0;
}