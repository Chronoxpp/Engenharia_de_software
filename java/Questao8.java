import java.util.Scanner;

class Questao8
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int n1;
        long resultado;

        System.out.print("Calcular N! sendo N = ");
        n1 = leitor.nextInt();

        if(n1 == 0)
        {
            resultado = 1;
        }
        else
        {
            resultado = n1;
            for(int i = (n1-1); i != 1; i = i - 1)
            {
                resultado = resultado * i;
            }
        }

        System.out.print("Resultado: "+resultado);

        leitor.close();
    }
}