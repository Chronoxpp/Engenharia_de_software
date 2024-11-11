package atividades_de_fixacao;
import java.util.Scanner;

class Questao9
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1;
        long anterior, atual,aux;

        System.out.print("Tamanho da sequencia: ");
        n1 = leitor.nextInt();

        atual = 1;
        aux = 1;
        anterior = 0;
        System.out.print(atual);
        for(int i = 2; i <= n1; i = i + 1)
        {
            System.out.print(","+(atual + anterior));
            atual = atual + anterior;
            anterior = aux;
            aux = atual;
        }
        System.out.println(".");

        leitor.close();
    }
}
