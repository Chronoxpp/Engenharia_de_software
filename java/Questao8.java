import java.util.Scanner;

class Questao8
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n;
        long resultado;
        resultado = 1;

        System.out.print("Digite um numero: ");
        n = leitor.nextInt();

        if(n == 0)
        {
            resultado = 1;
        }
        else
        {
            resultado = n;
            for(int i = (n-1); i != 1; i = i - 1)
            {
                resultado = resultado * i;
            }
        }

        System.out.print("Resultado: "+resultado);

        leitor.close();
    }
}