import java.util.Scanner;

class Questao1
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int v1,v2,v3;

        System.out.println("Digite um numero: ");
        v1 = leitor.nextInt();

        System.out.println("Digite outro numero: ");
        v2 = leitor.nextInt();

        System.out.println("Digite o ultimo numero: ");
        v3 = leitor.nextInt();

        System.out.print("Os numeros em ordem decrescente: ");
        if(v1>v2)
        {
            if(v1>v3)
            {
                System.out.print(v1+" ");

                if(v3>v2)
                {
                    System.out.print(v3+" ");
                    System.out.print(v2);
                }
                else
                {
                    System.out.print(v2+" ");
                    System.out.print(v3);
                }
            }
            else
            {
                System.out.print(v3+" ");
                System.out.print(v1+" ");
                System.out.print(v2);
            }
        }
        else
        {
            if(v2>v3)
            {
                System.out.print(v2+" ");

                if(v1>v3)
                {
                    System.out.print(v1+" ");
                    System.out.print(v3);
                }
                else
                {
                    System.out.print(v3+" ");
                    System.out.print(v1);
                }
            }
            else
            {
                System.out.print(v3+" ");
                System.out.print(v2+" ");
                System.out.print(v1);
            }
        }

        leitor.close();
    }
}