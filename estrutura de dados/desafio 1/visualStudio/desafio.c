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


void popularVetorInteiro(int *vetor, int tamanhoVetor)
{
    long int seed = 1234554321;

    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        vetor[i] = gerarNumeroInteiro(&seed, 0, 100000);
    }
}


void popularVetorReal(double *vetor, int tamanhoVetor)
{
    long int seed = 1234554321;

    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        vetor[i] = gerarNumeroInteiro(&seed, 0, 100000);
    }
}


void insertionSortNInteiro(int *vetor, int tamanhoVetor)
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


void insertionSortNReal(double *vetor, int tamanhoVetor)
{
    for(int i = 1; i < tamanhoVetor; i += 1)
    {
        double aux = vetor[i];
        for(int j = i; j >= 0; j --)
        {
            if(aux < vetor[j - 1]) {vetor[j] = vetor[j-1];}
            else{vetor[j] = aux; break;}
        }
    }
}


void iPesquisaSequencial(int *vetor,int tamanhoVetor, int numeroPesquisado, int* valoresDeRetorno)
{
    int posicaoNumeroProcurado = -1;
    int i = 0;
    int qtdeComparacoes = 0;

    while(i < tamanhoVetor && posicaoNumeroProcurado == -1)
    {
        qtdeComparacoes += 1;
        if(vetor[i] == numeroPesquisado) {posicaoNumeroProcurado = i;}
        i += 1;
    }

    valoresDeRetorno[0] = posicaoNumeroProcurado;
    valoresDeRetorno[1] = qtdeComparacoes;
}


void rPesquisaSequencial(double *vetor,int tamanhoVetor, double numeroPesquisado, int* valoresDeRetorno)
{
    int posicaoNumeroProcurado = -1;
    int i = 0;
    int qtdeComparacoes = 0;

    while(i < tamanhoVetor && posicaoNumeroProcurado == -1)
    {
        qtdeComparacoes += 1;
        if(vetor[i] == numeroPesquisado) {posicaoNumeroProcurado = i;}
        i += 1;
    }

    valoresDeRetorno[0] = posicaoNumeroProcurado;
    valoresDeRetorno[1] = qtdeComparacoes;
}


void iPesquisaSequencialComSentinela(int* vetor, int tamanhoVetor, int numeroPesquisado, int* vetorQueVaiReceberOsResultadosDaPesquisa)
{
    vetor = (int*)realloc(vetor, (tamanhoVetor + 1) * sizeof(*vetor));
    vetor[tamanhoVetor] = numeroPesquisado;

    int i = 0;
    int qtdeComparacoes = 0;
    int posicaoNumeroProcurado = -1;
    while(i < (tamanhoVetor + 1) && vetor[i] != numeroPesquisado)
    {qtdeComparacoes += 1; i += 1;}

    posicaoNumeroProcurado = i;
    
    if (posicaoNumeroProcurado == tamanhoVetor) 
    {vetorQueVaiReceberOsResultadosDaPesquisa[0] = -1;}
    else
    {vetorQueVaiReceberOsResultadosDaPesquisa[0] = posicaoNumeroProcurado;}

    vetorQueVaiReceberOsResultadosDaPesquisa[1] = qtdeComparacoes;
    
    vetor = (int*)realloc(vetor, tamanhoVetor * sizeof(*vetor));
}


void rPesquisaSequencialComSentinela(double* vetor, int tamanhoVetor, double numeroPesquisado, int* vetorQueVaiReceberOsResultadosDaPesquisa)
{
    vetor = (double*)realloc(vetor, (tamanhoVetor + 1) * sizeof(*vetor));
    vetor[tamanhoVetor] = numeroPesquisado;

    int i = 0;
    int qtdeComparacoes = 0;
    int posicaoNumeroProcurado = -1;
    while(i < (tamanhoVetor + 1) && vetor[i] != numeroPesquisado)
    {qtdeComparacoes += 1; i += 1;}

    posicaoNumeroProcurado = i;
    
    if (posicaoNumeroProcurado == tamanhoVetor)
    {vetorQueVaiReceberOsResultadosDaPesquisa[0] = -1;}
    else
    {vetorQueVaiReceberOsResultadosDaPesquisa[0] = posicaoNumeroProcurado;}

    vetorQueVaiReceberOsResultadosDaPesquisa[1] = qtdeComparacoes;
    
    vetor = (double*)realloc(vetor, tamanhoVetor * sizeof(*vetor));
}


void iSelectionSort(int *vetor, int tamanhoVetor, double *vetorQueVaiReceberEstatiscasDaOrdenacao)
{
    double qtdeComparacoes = 0;
    double qtdeMovimentacoes = 0;
    double qtdeTrocas = 0;

    int indiceComMenorValor;
    int aux;

    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        for(int j = (i + 1); j < tamanhoVetor; j += 1)
        {
            qtdeComparacoes += 1;
            if(vetor[j] < vetor[indiceComMenorValor])
            {
                indiceComMenorValor = j;
            }
        }

        if(vetor[indiceComMenorValor] < vetor[i])
        {
            qtdeComparacoes += 1;

            aux = vetor[i];
            vetor[i] = vetor[indiceComMenorValor];
            vetor[indiceComMenorValor] = aux;

            qtdeMovimentacoes += 3;
            qtdeTrocas += 1;
        }
    }

    vetorQueVaiReceberEstatiscasDaOrdenacao[0] = qtdeComparacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[1] = qtdeMovimentacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[2] = qtdeTrocas;
}


void rSelectionSort(double *vetor, int tamanhoVetor, double *vetorQueVaiReceberEstatiscasDaOrdenacao)
{
    double qtdeComparacoes = 0;
    double qtdeMovimentacoes = 0;
    double qtdeTrocas = 0;

    int indiceComMenorValor;
    double aux;

    for(int i = 0; i < tamanhoVetor; i += 1)
    {
        for(int j = (i + 1); j < tamanhoVetor; j += 1)
        {
            qtdeComparacoes += 1;
            if(vetor[j] < vetor[indiceComMenorValor])
            {
                indiceComMenorValor = j;
            }
        }

        if(vetor[indiceComMenorValor] < vetor[i])
        {
            qtdeComparacoes += 1;

            aux = vetor[i];
            vetor[i] = vetor[indiceComMenorValor];
            vetor[indiceComMenorValor] = aux;

            qtdeMovimentacoes += 3;
            qtdeTrocas += 1;
        }
    }

    vetorQueVaiReceberEstatiscasDaOrdenacao[0] = qtdeComparacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[1] = qtdeMovimentacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[2] = qtdeTrocas;
}


void iBubbleSort(int *vetor, int tamanhoVetor, double *vetorQueVaiReceberEstatiscasDaOrdenacao)
{
    double qtdeComparacoes = 0;
    double qtdeMovimentacoes = 0;
    double qtdeTrocas = 0;

    int continua;
    int aux;
    int fim = tamanhoVetor;

    do{
        continua = 0;
        for(int i = 0; i < (fim - 1); i += 1)
        {
            if(vetor[i] > vetor[i + 1])
            {
                qtdeComparacoes += 1;

                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                continua = i;

                qtdeMovimentacoes += 3;
                qtdeTrocas += 1;
            }
        }

        fim -= 1;
    }while(continua != 0);

    vetorQueVaiReceberEstatiscasDaOrdenacao[0] = qtdeComparacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[1] = qtdeMovimentacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[2] = qtdeTrocas;
}


void rBubbleSort(double *vetor, int tamanhoVetor, double *vetorQueVaiReceberEstatiscasDaOrdenacao)
{
    double qtdeComparacoes = 0;
    double qtdeMovimentacoes = 0;
    double qtdeTrocas = 0;

    int continua;
    double aux;
    int fim = tamanhoVetor;

    do{
        continua = 0;
        for(int i = 0; i < (fim - 1); i += 1)
        {
            if(vetor[i] > vetor[i + 1])
            {
                qtdeComparacoes += 1;

                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
                continua = i;

                qtdeMovimentacoes += 3;
                qtdeTrocas += 1;
            }
        }

        fim -= 1;
    }while(continua != 0);

    vetorQueVaiReceberEstatiscasDaOrdenacao[0] = qtdeComparacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[1] = qtdeMovimentacoes;
    vetorQueVaiReceberEstatiscasDaOrdenacao[2] = qtdeTrocas;
}


void iPesquisaBinaria(int *vetor, int tamanhoVetor, int numeroPesquisado, int *vetorQueVaiReceberEstatiscasDaPesquisa)
{
    int qtdeComparacoes = 0;

    int achou = 0;
    int posicaoInicial = 0;
    int posicaoFinal = tamanhoVetor - 1;
    int posicaoMeio;

    while(posicaoInicial <= posicaoFinal && achou == 0)
    {
        posicaoMeio = (posicaoInicial + posicaoFinal) / 2;

        if(vetor[posicaoMeio] == numeroPesquisado)
        {
            qtdeComparacoes += 1;

            achou = 1;
        }
        else if(numeroPesquisado < vetor[posicaoMeio])
        {
            qtdeComparacoes += 2;

            posicaoFinal = posicaoMeio - 1;
        }
        else
        {
            qtdeComparacoes += 2;

            posicaoInicial = posicaoMeio + 1;
        }
    }

    if(achou == 0) {posicaoMeio = -1;}

    vetorQueVaiReceberEstatiscasDaPesquisa[0] = posicaoMeio;
    vetorQueVaiReceberEstatiscasDaPesquisa[1] = qtdeComparacoes;
}


void rPesquisaBinaria(double *vetor, int tamanhoVetor, double numeroPesquisado, int *vetorQueVaiReceberEstatiscasDaPesquisa)
{
    int qtdeComparacoes = 0;

    int achou = 0;
    int posicaoInicial = 0;
    int posicaoFinal = tamanhoVetor - 1;
    int posicaoMeio;

    while(posicaoInicial <= posicaoFinal && achou == 0)
    {
        posicaoMeio = (posicaoInicial + posicaoFinal) / 2;

        if(vetor[posicaoMeio] == numeroPesquisado)
        {
            qtdeComparacoes += 1;

            achou = 1;
        }
        else if(numeroPesquisado < vetor[posicaoMeio])
        {
            qtdeComparacoes += 2;

            posicaoFinal = posicaoMeio - 1;
        }
        else
        {
            qtdeComparacoes += 2;

            posicaoInicial = posicaoMeio + 1;
        }
    }

    if(achou == 0) {posicaoMeio = -1;}

    vetorQueVaiReceberEstatiscasDaPesquisa[0] = posicaoMeio;
    vetorQueVaiReceberEstatiscasDaPesquisa[1] = qtdeComparacoes;
}


double calcularTempoDescorrido(clock_t tempoInicial, clock_t tempoFinal)
{
    return ((double)(tempoFinal - tempoInicial)) / CLOCKS_PER_SEC * 1000; // Conversão para milissegundos
}


void exibirMensagemInstantaneaPosicaoEncontrada(char* nomeVetor, double valorPesquisado, int posicaoEncontrada, double tempoGasto, int qtdeComparacoes)
{
    printf("%s[%d]: %f, gastou %lf ms e %d comparacoes\n", nomeVetor, posicaoEncontrada, valorPesquisado, tempoGasto, qtdeComparacoes);
}


void exibirMensagemPosOrdenacao(char* nomeVetor, double tempoGasto, double qtdeComparacoes, double qtdeMovimentacoes, double qtdeTrocas)
{
    printf("%s: gastou %lf ms, %f comparacoes, %f movimentacoes, e %f trocas\n", nomeVetor, tempoGasto, qtdeComparacoes, qtdeMovimentacoes, qtdeTrocas);
}


void iRealizarBateriaDeTestes(int *vetor, int tamanhoVetor, char* nomeVetor)
{
    clock_t tempoInicial, tempoFinal;

    double tempoGasto;

    // Valores de retorno das pesquisas
    //[0] = posicaoNumeroProcurado;
    //[1] = qtdeComparacoes;
    int resultadosDaPesquisa[2];

    int posicaoRetornada;
    int qtdeComparacoes;


    //Testes com a pesquisa sequencial

    printf("Pesquisa sequencial\n");
    
    tempoInicial = clock(); 
    iPesquisaSequencial(vetor, tamanhoVetor, 87, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    iPesquisaSequencial(vetor, tamanhoVetor, 100001, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Testes com a pesquisa sequencial com sentinela

    printf("\nPesquisa sequencial com sentinela\n");

    tempoInicial = clock(); 
    iPesquisaSequencialComSentinela(vetor, tamanhoVetor, 87, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    iPesquisaSequencialComSentinela(vetor, tamanhoVetor, 100001, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Preparacao de dados para ordenacoes
    double resultadosDaOrdenacao[3];
    double qtdeComparacoesOrdenacao;
    double qtdeMovimentacoes;
    double qtdeTrocas;
    int *vetorTemporario = (int *)malloc(tamanhoVetor * sizeof(int));


    //Teste com o algoritmo Selecion sort

    printf("\nOrdenacao com Selecion sort\n");

    popularVetorInteiro(vetorTemporario, tamanhoVetor);
    tempoInicial = clock();
    iSelectionSort(vetorTemporario, tamanhoVetor, resultadosDaOrdenacao);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    qtdeComparacoesOrdenacao = resultadosDaOrdenacao[0];
    qtdeMovimentacoes = resultadosDaOrdenacao[1];
    qtdeTrocas = resultadosDaOrdenacao[2];
    exibirMensagemPosOrdenacao(nomeVetor, tempoGasto, qtdeComparacoesOrdenacao, qtdeMovimentacoes, qtdeTrocas);


    //Testes com o algoritmo Bubble sort

    printf("\nOrdenacao com Bubble sort\n");
    
    popularVetorInteiro(vetorTemporario, tamanhoVetor);
    tempoInicial = clock();
    iBubbleSort(vetorTemporario, tamanhoVetor,resultadosDaOrdenacao);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    qtdeComparacoesOrdenacao = resultadosDaOrdenacao[0];
    qtdeMovimentacoes = resultadosDaOrdenacao[1];
    qtdeTrocas = resultadosDaOrdenacao[2];
    exibirMensagemPosOrdenacao(nomeVetor, tempoGasto, qtdeComparacoesOrdenacao, qtdeMovimentacoes, qtdeTrocas);


    //Testes com a pesquisa sequencial com vetor ordenado

    printf("\nPesquisa sequencial com vetor ordenado\n");
    
    tempoInicial = clock(); 
    iPesquisaSequencial(vetorTemporario, tamanhoVetor, 87, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    iPesquisaSequencial(vetorTemporario, tamanhoVetor, 100001, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Testes com a pesquisa sequencial com sentinela com vetor ordenado

    printf("\nPesquisa sequencial com sentinela com vetor ordenado\n");
    
    tempoInicial = clock(); 
    iPesquisaSequencialComSentinela(vetorTemporario, tamanhoVetor, 87, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    iPesquisaSequencialComSentinela(vetorTemporario, tamanhoVetor, 100001, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Testes com a pesquisa binaria com vetor ordenado

    printf("\nPesquisa binaria com vetor ordenado\n");
    
    tempoInicial = clock(); 
    iPesquisaBinaria(vetorTemporario, tamanhoVetor, 87, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    iPesquisaBinaria(vetorTemporario, tamanhoVetor, 100001, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    printf("\n\n");
}


void rRealizarBateriaDeTestes(double *vetor, int tamanhoVetor, char* nomeVetor)
{
    clock_t tempoInicial, tempoFinal; double tempoGasto;

    int resultadosDaPesquisa[2];
    //[0] = posicaoNumeroProcurado;
    //[1] = qtdeComparacoes;

    int posicaoRetornada;
    int qtdeComparacoes;


    //Testes com a pesquisa sequencial

    printf("Pesquisa sequencial\n");
    
    tempoInicial = clock(); 
    rPesquisaSequencial(vetor, tamanhoVetor, 87, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    rPesquisaSequencial(vetor, tamanhoVetor, 100001, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Testes com a pesquisa sequencial com sentinela

    printf("\nPesquisa sequencial com sentinela\n");
    
    tempoInicial = clock(); 
    rPesquisaSequencialComSentinela(vetor, tamanhoVetor, 87, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    rPesquisaSequencialComSentinela(vetor, tamanhoVetor, 100001, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Preparacao de dados para ordenacoes
    double resultadosDaOrdenacao[3];
    double qtdeComparacoesOrdenacao;
    double qtdeMovimentacoes;
    double qtdeTrocas;
    double *vetorTemporario = (double *)malloc(tamanhoVetor * sizeof(double));
    

    //Teste com o algoritmo Selecion sort

    printf("\nOrdenacao com Selecion sort\n");
    
    popularVetorReal(vetorTemporario, tamanhoVetor);
    tempoInicial = clock();
    rSelectionSort(vetorTemporario, tamanhoVetor,resultadosDaOrdenacao);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    qtdeComparacoesOrdenacao = resultadosDaOrdenacao[0];
    qtdeMovimentacoes = resultadosDaOrdenacao[1];
    qtdeTrocas = resultadosDaOrdenacao[2];
    exibirMensagemPosOrdenacao(nomeVetor, tempoGasto, qtdeComparacoesOrdenacao, qtdeMovimentacoes, qtdeTrocas);


    //Testes com o algoritmo Bubble sort

    printf("\nOrdenacao com Bubble sort\n");
    
    popularVetorReal(vetorTemporario, tamanhoVetor);
    tempoInicial = clock();
    rBubbleSort(vetorTemporario, tamanhoVetor,resultadosDaOrdenacao);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    qtdeComparacoesOrdenacao = resultadosDaOrdenacao[0];
    qtdeMovimentacoes = resultadosDaOrdenacao[1];
    qtdeTrocas = resultadosDaOrdenacao[2];
    exibirMensagemPosOrdenacao(nomeVetor, tempoGasto, qtdeComparacoesOrdenacao, qtdeMovimentacoes, qtdeTrocas);


    //Testes com a pesquisa sequencial com vetor ordenado

    printf("\nPesquisa sequencial com vetor ordenado\n");
    
    tempoInicial = clock(); 
    rPesquisaSequencial(vetorTemporario, tamanhoVetor, 87, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    rPesquisaSequencial(vetorTemporario, tamanhoVetor, 100001, resultadosDaPesquisa); 
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Testes com a pesquisa sequencial com sentinela com vetor ordenado

    printf("\nPesquisa sequencial com sentinela com vetor ordenado\n");

    tempoInicial = clock(); 
    rPesquisaSequencialComSentinela(vetorTemporario, tamanhoVetor, 87, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    rPesquisaSequencialComSentinela(vetorTemporario, tamanhoVetor, 100001, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    //Testes com a pesquisa binaria com vetor ordenado

    printf("\nPesquisa binaria com vetor ordenado\n");

    tempoInicial = clock(); 
    rPesquisaBinaria(vetorTemporario, tamanhoVetor, 87, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,87,posicaoRetornada, tempoGasto, qtdeComparacoes);

    tempoInicial = clock(); 
    rPesquisaBinaria(vetorTemporario, tamanhoVetor, 100001, resultadosDaPesquisa);
    tempoFinal = clock();
    tempoGasto = calcularTempoDescorrido(tempoInicial, tempoFinal);
    posicaoRetornada = resultadosDaPesquisa[0]; 
    qtdeComparacoes = resultadosDaPesquisa[1];
    exibirMensagemInstantaneaPosicaoEncontrada(nomeVetor,100001,posicaoRetornada, tempoGasto, qtdeComparacoes);


    printf("\n\n");
}


int main()
{
    int *vetor1 = (int *)malloc(100 * sizeof(int)); popularVetorInteiro(vetor1, 100);
    iRealizarBateriaDeTestes(vetor1, 100, "vetor1");

    int *vetor2 = (int *)malloc(1000 * sizeof(int)); popularVetorInteiro(vetor2, 1000);
    iRealizarBateriaDeTestes(vetor2, 1000, "vetor2");

    int *vetor3 = (int *)malloc(10000 * sizeof(int)); popularVetorInteiro(vetor3, 10000);
    iRealizarBateriaDeTestes(vetor3, 10000, "vetor3");

    int *vetor4 = (int *)malloc(100000 * sizeof(int)); popularVetorInteiro(vetor4, 100000);
    iRealizarBateriaDeTestes(vetor4, 100000, "vetor4");


    printf("\n\nVetores do tipo double\n");


    double *vetor5 = (double *)malloc(100 * sizeof(double)); popularVetorReal(vetor5, 100);
    rRealizarBateriaDeTestes(vetor5, 100, "vetor5");

    double *vetor6 = (double *)malloc(1000 * sizeof(double)); popularVetorReal(vetor6, 1000);
    rRealizarBateriaDeTestes(vetor6, 1000, "vetor6");

    double *vetor7 = (double *)malloc(10000 * sizeof(double)); popularVetorReal(vetor7, 10000);
    rRealizarBateriaDeTestes(vetor7, 10000, "vetor7");
    
    double *vetor8 = (double *)malloc(100000 * sizeof(double)); popularVetorReal(vetor8, 100000);
    rRealizarBateriaDeTestes(vetor8, 100000, "vetor8");

    system("pause");

    return 0;
}