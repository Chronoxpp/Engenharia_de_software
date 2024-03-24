package atividades_de_fixacao;
import java.util.Scanner;

class Questao1
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1,n2,n3;

        System.out.println("Digite um numero: ");
        n1 = leitor.nextInt();

        System.out.println("Digite outro numero: ");
        n2 = leitor.nextInt();

        System.out.println("Digite o ultimo numero: ");
        n3 = leitor.nextInt();

        System.out.print("Os numeros em ordem decrescente: ");
        if(n1>n2)
        {
            if(n1>n3)
            {
                System.out.print(n1+" ");

                if(n3>n2)
                {
                    System.out.print(n3+" ");
                    System.out.print(n2);
                }
                else
                {
                    System.out.print(n2+" ");
                    System.out.print(n3);
                }
            }
            else
            {
                System.out.print(n3+" ");
                System.out.print(n1+" ");
                System.out.print(n2);
            }
        }
        else
        {
            if(n2>n3)
            {
                System.out.print(n2+" ");

                if(n1>n3)
                {
                    System.out.print(n1+" ");
                    System.out.print(n3);
                }
                else
                {
                    System.out.print(n3+" ");
                    System.out.print(n1);
                }
            }
            else
            {
                System.out.print(n3+" ");
                System.out.print(n2+" ");
                System.out.print(n1);
            }
        }

        leitor.close();
    }
}