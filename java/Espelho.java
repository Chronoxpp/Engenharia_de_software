import java.util.Scanner;

class Espelho
{
    public static void main(String[] args)
    {
        Scanner Leitor = new Scanner(System.in);
        long numrecebido,divisor,restop;
        divisor = 10;
        restop = 0;
        
        System.out.println("Digite um numero ");
        numrecebido = Leitor.nextLong();
        do
        {
            System.out.print((numrecebido%divisor));
            restop = (numrecebido/divisor);
            numrecebido = (numrecebido/divisor);
        }
        while(restop != 0);

        Leitor.close();
    }
}