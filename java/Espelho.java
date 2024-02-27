import java.util.Scanner;

class Espelho
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        long dividendo,divisor,restop;
        boolean parada;
        divisor = 10;
        restop = 0;
        
        System.out.println("Digite um numero ");
        dividendo = Leitor.nextLong();
        do
        {
            System.out.print((dividendo%divisor));
            restop = (dividendo/divisor);
            dividendo = (dividendo/divisor);
        /*
            if(restop == 0)
            {
                parada = true;
            }
            else
            {
                parada = false;
            }
        */
        }
        while(restop != 0);

        Leitor.close();
    }
}