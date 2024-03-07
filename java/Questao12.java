import java.util.Scanner;

class Questao12
{
    public static void main(String[] args)
    {
        Scanner leitor = new Scanner(System.in);
        int v1,v2,result,divisor,cont;
        boolean parar = false;

        System.out.print("Digite o primeiro numero: ");
        v1 = leitor.nextInt();
        System.out.print("Digite o primeiro numero: ");
        v2 = leitor.nextInt();

        cont = 0;
        divisor = 2;
        result = 1;
        while(parar == false)
        {
            if(v1%divisor == 0)
            {
                cont = cont + 1;
                v1 = v1/divisor;
            }

            if(v2%divisor == 0)
            {
                cont = cont + 1;
                v2 = v2/divisor;
            }

            if(cont > 0)
            {
                result = result * divisor;
            }
            else
            {
                divisor = divisor + 1;
                if(v1 == 1 && v2 == 1)
                {
                    parar = true;
                }
            }
            cont = 0;
        }
        System.out.println("MMC = "+result);

        System.out.print("Digite o primeiro numero: ");
        v1 = leitor.nextInt();
        System.out.print("Digite o primeiro numero: ");
        v2 = leitor.nextInt();

        cont = 0;
        divisor = 2;
        result = 1;
        parar = false;
        while(parar == false)
        {
            if(v1%divisor == 0)
            {
                cont = cont + 1;
                v1 = v1/divisor;
            }

            if(v2%divisor == 0)
            {
                cont = cont + 1;
                v2 = v2/divisor;
            }

            if(cont == 2)
            {
                result = result * divisor;
            }
            else
            {
                if((v1%divisor) != 0 && (v2%divisor) != 0)
                {
                  divisor = divisor + 1;  
                }
                if(v1 == 1 && v2 == 1)
                {
                    parar = true;
                }
            }
            cont = 0;
        }
        System.out.println("MDC = "+result);

        leitor.close();
    }
}