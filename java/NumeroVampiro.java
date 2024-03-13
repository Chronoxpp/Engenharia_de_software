import java.util.Scanner;

class NumeroVampiro
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int possivelVampiro,numeroDeAlgarismos,aux;

        possivelVampiro = leitor.nextInt();

        aux = possivelVampiro;
        numeroDeAlgarismos = 0;

        for(numeroDeAlgarismos = 1;aux/10 != 0; numeroDeAlgarismos = numeroDeAlgarismos+1)
        {
            aux = aux/10;
        }
        System.out.print("acabou "+numeroDeAlgarismos);

        leitor.close();
    }
} 