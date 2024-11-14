#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main()
{
    // Inicializa a semente do gerador de números aleatórios
    srand(time(NULL));

    int tamanhoArray;
    //Loop para determinar se o usuario vai inserir um array ou se o software vai criar um
    char respostaUsuario; 
    while (1)
    {
        printf("Voce deseja inserir seu array? \nDigite S ou N: "); scanf(" %c", &respostaUsuario);
        
        if (respostaUsuario == 'S' || respostaUsuario == 's')
        {
            printf("\n Insira a quantidade de elementos do seu array: ");
            scanf(" %d", &tamanhoArray);

            break;
        }
        else if(respostaUsuario == 'N' || respostaUsuario == 'n')
        {
            //Inicializa com uma quantidade aleatoria de elementos
            tamanhoArray = rand() % 100;

            break;
        }
        else
        {
            printf("\n Voce deve responder S ou N!");
        }        
    }


    //Permite que o usuario popule o array ou faz isso de forma automatica
    int array[tamanhoArray];
    if (respostaUsuario == 'S' || respostaUsuario == 's')
    {
        for(int i = 0; i < tamanhoArray; i += 1)
        {
            printf("\n Digite o valor do elemento [%d]: ", i); scanf(" %d", &array[i]);
        }
    }
    else if(respostaUsuario == 'N' || respostaUsuario == 'n')
    {
        // Popula o array com 10 números inteiros aleatórios
        for(int i = 0; i < tamanhoArray; i += 1)
        {
            array[i] = rand() % 100;
        }
    }


    //Cria um buffer temporario suficiente para armazenar cada numero do array;
    char intTemp[12];

    //Determina o tamanho necessario da string para exibir o array ao usuario
    int espacoExibicaoArray = (tamanhoArray * 12) + (tamanhoArray - 1) + 3;

    //Cria um ponteiro que indica a msg de exibicao do array atual, e aloca a memoria
    char *msgArrayAntigo = (char *)malloc(espacoExibicaoArray * sizeof(char));
    
    //Monta a msg na memoria alocada anteriormente, concatenando os char e strings
    strcpy(msgArrayAntigo, "[");
    sprintf(intTemp, "%d", array[0]);
    strcat(msgArrayAntigo, intTemp);

    for(int i = 1; i < tamanhoArray; i += 1)
    {
        strcat(msgArrayAntigo, ",");
        sprintf(intTemp, "%d", array[i]);
        strcat(msgArrayAntigo, intTemp);
    }
    strcat(msgArrayAntigo, "]");

    //Exibe a mensagem montada
    printf("\nArray atual:\n%s\n", msgArrayAntigo);

    system("pause");


    //Realiza a ordenacao do array pelo algoritmo Bubble sort
    int aux;
    for(int i = 0; i < tamanhoArray -1; i += 1)
    {
        for(int j = 0; j < (tamanhoArray -1) - i; j += 1)
        {
            if(array[j] > array[j+1])
            {
                aux = array[j];
                array[j] = array[j+1];
                array[j+1] = aux;
            }
        }
    }

    //Cria um novo ponteiro para exibir o array ordenado, e aloca a memoria
    char *msgArrayNovo = (char *)malloc(espacoExibicaoArray * sizeof(char));

    //Monta uma nova mensagem no espaco de memoria alocado
    strcpy(msgArrayNovo, "[");
    sprintf(intTemp, "%d", array[0]);
    strcat(msgArrayNovo, intTemp);

    for(int i = 1; i < tamanhoArray; i += 1)
    {
        strcat(msgArrayNovo, ",");
        sprintf(intTemp, "%d", array[i]);
        strcat(msgArrayNovo, intTemp);
    }
    strcat(msgArrayNovo, "]");

    //Exibe a nova mensagem que contem o array ordenado
    printf("\nArray ordenado:\n%s\n", msgArrayNovo);

    system("pause");


    //Libera a memoria alocada
    free(msgArrayAntigo);
    free(msgArrayNovo);


    char reqUsuario[12];
    while (1)
    {
        printf("ESC para sair. Insira um numero e eu vou dizer qual seu indice no array: "); scanf("%c", &reqUsuario);

        if (reqUsuario == "esc" || reqUsuario == "ESC")
        {
            break;
        }
    }

    return 0;
}