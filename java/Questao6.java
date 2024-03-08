import java.util.Scanner;

class Questao6
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1,i;

        System.out.print("Digite um numero: ");
        n1 = leitor.nextInt();
        leitor.close();
        
        for(i = 1;(i*i) <= n1;i = i +1)
        {
        }

        System.out.print("Resultado: "+(i-1));
    }
}