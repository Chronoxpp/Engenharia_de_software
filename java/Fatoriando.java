import java.util.Scanner;

class Fatoriando
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        int n;
        long resultado;
        resultado = 1;

        System.out.print("Digite um numero: ");
        n = Leitor.nextInt();

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

        Leitor.close();
    }
}