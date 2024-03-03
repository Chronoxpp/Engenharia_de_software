import java.util.Scanner;

class Raizinteira
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        int v1,resultado;
        boolean parada;
        parada = false;

        System.out.print("Digite um numero");
        v1 = Leitor.nextInt();

        for(int i = 1;parada == false;i = i +1)
        {
            resultado = i * i;
            if(resultado > v1)
            {
                
            }
        }
    }
}
