import java.util.Scanner;

class Questao6
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int v1,resultado;
        boolean parada;
        parada = false;

        System.out.print("Digite um numero");
        v1 = leitor.nextInt();

        for(int i = 1;parada == false;i = i +1)
        {
            resultado = i * i;
            if(resultado > v1)
            {
                
            }
        }

        leitor.close();
    }
}
