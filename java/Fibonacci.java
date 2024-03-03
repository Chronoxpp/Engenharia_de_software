import java.util.Scanner;

class Fibonacci
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        int enesimo;
        long anterior, atual,antigo;
        anterior = 0;
        atual = 1;
        antigo = 1;

        System.out.print("Digite um numero: ");
        enesimo = Leitor.nextInt();

        System.out.print(atual+" ");

        for(int i = 2; i <= enesimo; i = i + 1)
        {
            System.out.print((atual + anterior)+" ");
            atual = atual + anterior;
            anterior = antigo;
            antigo = atual;
        }

        Leitor.close();
    }
}
